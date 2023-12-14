<template>
  <div class="filters">
    <label>
      Інгредієнт:
      <input v-model="filters.ingredient" />
    </label>

    <label>
      Час приготування (хв):
      <input type="number" v-model="filters.time" />
    </label>

    <label>
      Калорії:
      <input type="number" v-model="filters.calories" />
    </label>

    <label>
      Категорія:
      <select v-model="filters.category">
        <option value="">Усі</option>
        <option value="breakfast">Сніданок</option>
        <option value="lunch">Обід</option>
        <option value="dinner">Вечеря</option>
        <option value="dessert">Десерт</option>
      </select>
    </label>
  </div>
</template>

<script>
export default {
  props: {
    filters: Object,
  },
};
</script>

<style scoped>
/* Додайте стилі за потребою для вигляду фільтрів */
</style>