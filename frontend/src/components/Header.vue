<template>
  <div>
    <header class="navbar navbar-expand-md navbar-light d-flex flex-wrap align-items-center justify-content-between py-3 mb-4 border-bottom">
      <router-link to="/" class="navbar-brand d-flex align-items-center text-decoration-none">
        <div class="logo">
          <img src="../assets/img/free-icon-pelmeni-4507367.png" alt="My Logo" class="logo-img">
          <p class="logo-text">Pelmen</p>
        </div>
      </router-link>

      <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas" data-bs-target="#navbarNav"
              aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="offcanvas offcanvas-end" tabindex="-1" id="navbarNav" aria-labelledby="navbarNavLabel">
        <div class="offcanvas-header">
          <h5 class="offcanvas-title" id="navbarNavLabel">Navigation</h5>
          <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
        </div>
        <div class="linkpages">
          <div class="offcanvas-body">
            <ul class="navbar-nav mb-2 mb-md-0">
              <!-- Ваші інші елементи меню тут -->
              <li class="nav-item"><router-link to="/" class="nav-link px-2">Home</router-link></li>
              <li class="nav-item"><router-link to="#" class="nav-link px-2">Menu</router-link></li>
              <li class="nav-item"><router-link to="/recipes" class="nav-link px-2">Recipes</router-link></li>
              <li class="nav-item"><router-link to="/faq" class="nav-link px-2">FAQs</router-link></li>
              <li class="nav-item"><router-link to="/about" class="nav-link px-2">About</router-link></li>

              <!-- Відображається, якщо користувач аутентифікований -->
              <li v-if="isAuthenticated" class="nav-item">
                <router-link to="/profile" class="nav-link px-2">Profile</router-link>
              </li>
              <li v-if="isAuthenticated" class="nav-item">
                <button @click="logout" class="nav-link px-2">Logout</button>
              </li>
            </ul>
          </div>
        </div>
      </div>

      <!-- Змінна кнопка або ім'я користувача, в залежності від аутентифікації -->
      <div class="col-md-3 text-end">
        <router-link v-if="!isAuthenticated" to="/login" class="btn btn-outline-primary me-2">Login</router-link>
        <router-link v-if="!isAuthenticated" to="/signup" class="btn btn-primary">Sign-up</router-link>
        <div v-if="isAuthenticated" class="d-flex align-items-center">
          <span class="me-2">{{ username }}</span>
          <!-- Замініть код наступним, щоб відображати ім'я користувача та кнопку для виходу -->
          <button @click="logoutUser" class="btn btn-link">Logout</button>
        </div>
      </div>
    </header>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import axios from "axios";

export default {

  setup() {
    const isAuthenticated = ref(false);
    const username = ref("");
    const router = useRouter();

    // Перевірити стан аутентифікації під час завантаження компонента
    onMounted(() => {
      checkAuthentication();
    });

    const checkAuthentication = () => {
      // Викликати серверний ендпоінт для перевірки аутентифікації
      axios.get("/auth/me")
          .then(response => {
            isAuthenticated.value = true;
            username.value = response.data.username;
          })
          .catch(() => {
            isAuthenticated.value = false;
            username.value = "";
          });
    };

    const logoutUser = () => {
      // Викликати серверний ендпоінт для виходу
      axios.post("/auth/logout")
          .then(() => {
            isAuthenticated.value = false;
            username.value = "";
            router.push("/"); // Перенаправити на головну сторінку (або іншу, якщо необхідно)
          })
          .catch(error => {
            console.error("Logout failed", error);
          });
    };

    return {
      isAuthenticated,
      username,
      checkAuthentication,
      logoutUser,
    };
  },

  data() {
    return {
      isAuthenticated: false,
      username: '', // Ім'я користувача
      //avatar: "", // URL аватару користувача
      showProfileMenu: false, // Для відображення/приховування меню профілю
    };
  },
  methods: {


    toggleProfileMenu() {
      this.showProfileMenu = !this.showProfileMenu;
    },
    loginUser(username) {
      this.isAuthenticated = true;
      this.username = username;
      // Оновити хедер або перенаправити користувача
      // ...
    },
    logoutUser() {
      this.isAuthenticated = false;
      this.username = '';
      // Оновити хедер або перенаправити користувача
      //this.avatar = "";
    },
  },
};
</script>
<style scoped>
.logo {
  display: flex;
  flex-direction: row;
  align-items: center;
}

.logo-img {
  width: 25px;
  object-fit: cover;
  cursor: pointer;
  transition: transform 0.3s ease;
  margin-bottom: 10px;
}

.logo-text {
  font-family: 'Russo One', sans-serif;
  font-size: 25px;
  color: #15156b;
  margin-top: 7px;
  margin-left: 5px;
}

/* Додано стилі для розміщення елементів по краях */
header {
  width: 100%;
  padding: 0 15px;
  box-sizing: border-box;
}

/* Додано стилі для правильного розміщення кнопки зменшення меню на менших екранах */
.navbar-toggler {
  margin-left: auto;
  border: 1px solid #ddddff;
  background-color: #d2d1d1;
}

.linkpages {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: 15%;
}

.nav-item1 {
  display: none;
}

/* Додано стилі для вирівнювання тексту навігаційних посилань на великих екранах */
@media (max-width: 768px) {
  .col-md-3 {
    display: none;
  }
  .linkpages {
    display: flex;
    flex-direction: column;
    align-items: start;
    margin-left: 0;
  }
  .nav-item1 {
    display: block;
  }
}
</style>

<script setup>
</script>