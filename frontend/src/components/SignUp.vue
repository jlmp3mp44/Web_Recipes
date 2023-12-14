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
        <label for="email">Email:</label>
        <input type="email" id="email" v-model="email"
               @blur="validateEmail(email)" required>
        <span v-if="emailError">Введіть правильний email</span>
      </div>
      <div class="form-group">
        <label for="password">Пароль:</label>
        <input type="password" id="password" v-model="password"
               @blur="validatePassword(password)" required>
        <span v-if="passwordError">Пароль має містити щонайменше одну
          маленьку літеру, одну велику літеру, одну цифру і був не коротший за 8 символів</span>
      </div>
      <div class="form-group">
        <label for="surname">Прізвище:</label>
        <input type="text" id="surname" v-model="surname"
               @blur="validateName(surname, 'surname')" required>
        <span v-if="surnameError">Введіть коректне прізвище</span>
      </div>
      <div class="form-group">
        <label for="name">Ім'я:</label>
        <input type="text" id="name" v-model="name"
               @blur="validateName(name, 'name')" required>
        <span v-if="nameError">Введіть коректне ім'я</span>
      </div>
      <div class="form-group">
        <label for="patronymic">По-батькові:</label>
        <input type="text" id="patronymic" v-model="patronymic"
               @blur="validateName(patronymic, 'patronymic')" required>
        <span v-if="patronymicError">Введіть коректне по-батькові</span>
      </div>
      <div class="form-group">
        <label for="birthdate">Дата народження:</label>
        <input type="date" id="birthdate" v-model="birthdate" :max="currentDate" required>
      </div>
      <div class="form-group-gender">
        <label>Виберіть стать:</label>
        <div class="gender">
          <input type="radio" id="gender1" name="gender" value="male" checked
                 class="gender" v-model="gender">
          <label for="gender1">Чоловік</label>
          <input type="radio" id="gender2" name="gender" value="female"
                 class="gender" v-model="gender">
          <label for="gender2">Жінка</label>
          <input type="radio" id="gender3" name="gender" value="other"
                 class="gender" v-model="gender">
          <label for="gender3">Інша</label>
        </div>
      </div>
      <div class="form-group">
        <label for="phoneNumber">Номер телефону:</label>
        <input type="text" id="phoneNumber" v-model="phone" v-mask="'+38 (0##) ###-##-##'"
               @blur="validatePhoneNumber"  placeholder="+38 (0__) ___-__-__"  required>
        <span v-if="phoneError">Введіть коректний номер телефону</span>
      </div>
      <div class="form-group">
        <label for="username">Ім'я користувача:</label>
        <input type="text" id="username" v-model="username"
               @blur="validateName(username, 'username')" required>
        <span v-if="nameError">Введіть коректне ім'я</span>
      </div>
      <button type="submit" class="sumbitbutton">Зареєструватися</button>
    </form>
    </div>
  </div>
</template>
<script>
import axios from 'axios';
export default {
  data() {
    return {
      email: '',
      surname: '',
      name: '',
      patronymic: '',
      username: '',
      birthdate: null,
      gender: 'male',
      phone: '',
      password: '',
      users: [],
      selectedUsers: [],
      phoneError: false,
      formError: false,
      surnameError: false,
      nameError: false,
      patronymicError: false,
      emailError: false,
      passwordError: false,
    };
  },
  computed: {
    currentDate() {
      return new Date().toISOString().split("T")[0];
    },
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    validateEmail(email) {
      let regex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
      this.emailError = !regex.test(email);
    },
    validatePassword(password) {
      const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/;

      this.passwordError = !passwordRegex.test(password);
    },
    validateName(name, type) {
      let regex = /^[A-ZА-ЯЁІЇЄ][a-zа-яёіїє]+(-[A-ZА-ЯЁІЇЄ][a-zа-яёіїє]+)?$/;
      switch (type) {
        case 'surname':
          this.surnameError = !regex.test(name);
          break;
        case 'firstname':
          this.nameError = !regex.test(name);
          break;
        case 'patronymic':
          this.patronymicError = !regex.test(name);
          break;
      }
    },
    validatePhoneNumber() {
      let regex = /^\+38 \(0\d{2}\) \d{3}-\d{2}-\d{2}$/;
      this.phoneError = !regex.test(this.phone);
    },
    checkFormError() {
      this.formError = this.emailError ||
          this.passwordError ||
          this.surnameError ||
          this.nameError ||
          this.patronymicError ||
          this.phoneError;
    },

    submitForm() {
      // Ваш код для валідації даних перед відправленням

      const userData = {
        email: this.email,
        surname: this.surname,
        name: this.name,
        patronymic: this.patronymic,
        birthdate: this.birthdate,
        gender: this.gender,
        phone: this.phone,
        password: this.password,
        username: this.username,
        role: 'user',
      };

      // Відправка даних на сервер
      axios.post('/auth/register', userData)
          .then(response => {
            // Обробка успішної відповіді від сервера
            console.log(response.data);
          })
          .catch(error => {
            // Обробка помилки
            console.error(error);
          });

      }


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
input[type="text"],
input[type="date"],
select,
input[type="tel"],
input[type="file"],
input[type="password"]{
  width: 100%;
  padding: 10px 2px 10px 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  font-size: 14px;
  background-color: #fafafa;
}

select {
  appearance: none;
  background-size: 20px;
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
.form-group-gender {
  display: block;
  font-weight: bold;
  margin-bottom: 10px;
}
.gender label {
  display: inline-block;
  padding: 5px 10px;
  background-color: #ccc;
  border: 1px solid #999;
  border-radius: 5px;
  cursor: pointer;
  margin-right: 10px;
  margin-top: 5px;
  width: 31%;
}

.gender input[type="radio"] {
  display: none;
}

.gender input[type="radio"]:checked + label {
  background-color: #15156b;
  color: #fff;
  width: 31%;
}

@media (min-width: 768px) and (max-width: 1000px) {
  header {
    padding: 20px 40px;
    height: 200px;
  }

  header, footer {
    width: 100vw;
  }

  nav ul li {
    margin-right: 40px;
  }

  nav ul li a {
    font-size: 30px;
  }

  .main {
    padding: 150px 0;
  }
  .main h1 {
    font-size: 48px;
  }

  .main p {
    font-size: 20px;
    margin-bottom: 40px;
  }
}

@media (max-width: 768px) {
  header {
    padding: 10px 20px;
  }

  header, footer {
    max-width: 100%;
  }

  nav ul li {
    margin-right: 10px;
  }

  nav ul li a {
    font-size: 18px;
  }

  .main {
    padding: 100px 0;
  }

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

