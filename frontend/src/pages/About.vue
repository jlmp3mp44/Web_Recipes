<template>
  <div class="app">
    <Header />

    <main class="about-us">
      <section class="section">
        <h1>Про нас</h1>
        <p>
          Ми - команда кулінарів, які пристрастно діляться своєю любов'ю до готування та
          смачної їжі. Наша мета - надихати та допомагати всім гурманам готувати чудові страви вдома.
          Наш проєкт - це результат спільних зусиль професійних кулінарів та програмістів, які спрямовані
          на полегшення кулінарного бізнесу. Ми віримо у те, що добре організований сайт може значно підвищити
          ефективність та якість готування. Наша команда працює безперервно для того, щоб надати вам найкращі
          інструменти для досягнення вашого кулінарного успіху.
        </p>
      </section>

      <!-- Додайте додаткові розділи або блоки з інформацією "Про нас" за потребою -->

    </main>

    <Footer />
  </div>
</template>

<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
</script>

<style scoped>
/* Додайте стилі за потребою для вигляду сторінки "Про нас" */
.about-us {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

h1 {
  font-size: 2em;
  color: #333;
}

p {
  line-height: 1.5;
  color: #666;
}

.app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
.footer {
  margin-top: auto; /* Розташовує футер внизу екрану */
}
</style>
