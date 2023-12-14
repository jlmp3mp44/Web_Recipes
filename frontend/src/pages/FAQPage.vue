<script setup>
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import FAQ from "@/components/FAQ.vue";
</script>

<template>
  <div id="app">
  <Header/>
  <FAQ/>
  <Footer/>
  </div>
</template>
<style scoped>
#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}
.faq {
  min-width: 800px;
  margin: 0 auto;
  height: auto; /* або height: 100%; */
}
.footer {
  margin-top: auto; /* Розташовує футер внизу екрану */
}
</style>