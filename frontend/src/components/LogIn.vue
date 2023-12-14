<template>
  <button @click="goBack" class="back-button">
    <span class="arrow">&larr;</span> Назад
  </button>
  <div class="registration-form-container">
    <div class="logo">
      <img src="../assets/img/free-icon-pelmeni-4507367.png" alt="My Logo" class="logo-img">
      <p class="logo-text">Pelmen</p>
    </div>
    <div class="registration-container">
      <form class="registration-form" @submit.prevent="submitForm">
        <div class="form-group">
          <label for="username">Ім'я користувача:</label>
          <input type="text" id="username" v-model="username" required>
        </div>
        <div class="form-group">
          <label for="password">Пароль:</label>
          <input type="password" id="password" v-model="password"
                 @blur="validatePassword(password)" required>
          <span v-if="passwordError">Пароль має бути не менше 8 символів</span>
        </div>
        <button type="submit" class="submit-button">Увійти</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      username: '', // Змінено з email на username
      password: '',
      passwordError: false,
      formError: false,
    };
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    validatePassword(password) {
      this.passwordError = password.length < 8;
    },
    checkFormError() {
      this.formError = this.passwordError;
    },
    submitForm() {
      this.checkFormError();
      if (!this.formError) {
        const user = {
          username: this.username,
          password: this.password,
        };

        axios.post('/auth/login', user)
            .then(response => {
              const jwt = response.data.jwt;
              localStorage.setItem('jwt', jwt);
              this.$router.push('/');
            })
            .catch(error => {
              console.error('Login failed', error);
              alert('Login failed. Please check your credentials.');
            });
      } else {
        alert("Будь ласка, перевірте поля форми на наявність помилок.");
      }
    },
  },
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Russo+One&display=swap');
body {
  font-family: Arial, sans-serif;
  background-color: #f0f0f0;
  margin: 0;
  padding: 0;
}

.logo {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
}

.logo-img {
  width: 45px;
  object-fit: cover;
  cursor: pointer;
  transition: transform 0.3s ease;
  margin-bottom: 10px; /* Додано маржу вниз для відступу від тексту */
}

.logo-text {
  font-family: 'Russo One', sans-serif;
  font-size: 40px;
  color: #15156b;
  margin-top: 5px; /* Додано маржу вгору для відступу від фото */
  margin-left: 5px;
}

.back-button {
  /* Стилі для кнопки, ви можете додати свої власні стилі */
  padding: 10px 15px;
  font-size: 16px;
  background-color: #f0f0f0;
  color: #15156b;
}

.back-button:hover {
  background-color: #e0e0e0;
}

.arrow {
  /* Стилі для стрілки, можна налаштувати власні */
  margin-right: 5px;
}

.registration-form-container {
  width: 100%;
  max-width: 500px;
  margin: 10px auto;
  padding: 20px;
  background-color: #fff;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 10px;
  text-align: center;
}

h1 {
  font-size: 24px;
  margin-bottom: 20px;
}

.registration-form {
  text-align: left;
}

.form-group {
  margin-bottom: 5px;
  display: flex;
  flex-direction: column;

}

label {
  display: block;
  font-weight: bold;
}

input[type="email"],
input[type="password"]{
  width: 100%;
  padding: 10px 2px 10px 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 14px;
  background-color: #fafafa;
}

button {
  background-color: #15156b;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  font-size: 16px;
  cursor: pointer;
  margin-bottom: 10px;
}

button:hover {
  background-color: #1d1de3;
}
.user-data li {
  margin-bottom: 20px;
}


@media (min-width: 768px) and (max-width: 1000px) {
  .main h1 {
    font-size: 48px;
  }

  .main p {
    font-size: 20px;
    margin-bottom: 40px;
  }
}

@media (max-width: 768px) {
  .main h1 {
    font-size: 36px;
  }

  .main p {
    font-size: 18px;
    margin-bottom: 30px;
  }
  .registration-container {
    max-width: 85%;
  }
  .registration-form {
    max-width: 90%;
  }

  .gender input[type="radio"]:checked + label {
    width: 29%;
  }
  .gender label {
    width: 29%;
  }
}
</style>