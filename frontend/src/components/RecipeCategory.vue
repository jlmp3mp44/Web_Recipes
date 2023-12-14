<template>
  <div class="categories">
    <label v-for="category in categories" :key="category">
      <input type="radio" v-model="filters.category" :value="category" />
      {{ category }}
    </label>
  </div>
</template>

<script>
export default {
  props: {
    filters: Object,
  },
  data() {
    return {
      categories: ['Усі', 'Сніданок', 'Обід', 'Вечеря', 'Десерт'],
    };
  },
};
</script>

<style scoped>
/* Додайте стилі за потребою для вигляду класифікації за категоріями */
</style>
