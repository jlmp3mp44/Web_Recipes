<template>
  <div class="recipes">
    <recipe-filter :filters="filters" />
    <recipe-category :filters="filters" />

    <div class="recipe-list">
      <div v-for="recipe in filteredRecipes" :key="recipe.id" class="recipe-item">
        <!-- Виведіть інформацію про рецепт (назва, інгредієнти, час, калорії) -->
      </div>
    </div>
  </div>
</template>

<script setup>
import RecipeFilter from "@/components/RecipeFilter.vue";
import RecipeCategory from "@/components/RecipeCategory.vue";



const filteredRecipes = ref(recipes.value);
const filters = ref({
  ingredient: '',
  time: 0,
  calories: 0,
  category: '',
});

watch(filters, filterRecipes);

function filterRecipes() {
  // Реалізуйте логіку фільтрації
  // Оновіть filteredRecipes згідно зі встановленими фільтрами
}
</script>

<style scoped>
/* Додайте стилі за потребою для вигляду сторінки рецептів */
</style>