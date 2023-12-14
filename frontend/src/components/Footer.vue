<template>
  <footer class="footer">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <!-- Логотип і текст компанії -->
          <div class="company-info">
            <img src="../assets/img/free-icon-pelmeni-4507367.png" alt="Company Logo" class="logo">
            <p>© 2023 Pelmen, Inc</p>
          </div>
        </div>
        <div class="col-md-6">
          <!-- Іконки телеграму, телефону та пошти -->
          <div class="contact-icons text-md-end text-center">
            <a href="https://t.me/your-telegram" target="_blank" rel="noopener noreferrer">
              <font-awesome-icon :icon="['fab', 'telegram']" />
            </a>
            <a href="tel:+1234567890">
              <font-awesome-icon :icon="['fas', 'phone']" />
            </a>
            <a href="mailto:info@example.com">
              <font-awesome-icon :icon="['far', 'envelope']" />
            </a>
          </div>
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import { faTelegram as fabTelegram } from '@fortawesome/free-brands-svg-icons'
import { faPhone as fasPhone, faEnvelope as farEnvelope } from '@fortawesome/free-solid-svg-icons'

export default {
  components: {
    FontAwesomeIcon,
  },
  data() {
    return {
      icons: {
        fabTelegram,
        fasPhone,
        farEnvelope,
      },
    }
  },
}
</script>

<style scoped>
.footer {
  background-color: #f8f9fa;
  padding: 20px 0;
  border-top: 1px solid #ddd; /* Додавання полоски між футером і іншим контентом */
}

.company-info {
  display: flex;
  align-items: center;
}

.logo {
  width: 30px; /* Задайте розмір логотипу за потребою */
  margin-right: 10px;
  margin-bottom: 15px;
}

.contact-icons {
  font-size: 24px;
}

.contact-icons a {
  margin-left: 20px;
}
.contact-icons font-awesome-icon {
  margin-right: 5px;
}

@media (max-width: 768px) {
  .company-info {
    flex-direction: column;
    align-items: center;
    text-align: center;
  }

  .logo {
    margin-bottom: 0;
  }

  .contact-icons {
    margin-bottom: 20px;

  }
}
</style>

