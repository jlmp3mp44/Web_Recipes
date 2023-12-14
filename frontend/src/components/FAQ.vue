<template>
  <div class="faq">
    <h2>Часті запитання</h2>
    <accordion :items="faqItems" />
  </div>
</template>

<script>
import Accordion from "@/components/Accordion.vue";

export default {
  components: {
    Accordion
  },
  data() {
    return {
      faqItems: [
        {
          question: "Як додати рецепт?",
          answer: "Для додавання рецепту перейдіть у розділ 'Додати рецепт' та заповніть всі необхідні поля."
        },
        {
          question: "Як видаляти рецепти?",
          answer: "Ви можете видаляти свої рецепти в розділі 'Мої рецепти'."
        },
        {
          question: "Як створювати власні меню?",
          answer: "Щоб створювати власні меню, потрібно зареєструватися на сайті. Після реєстрації ви зможете створювати власні меню, додавати рецепти до них, а також видаляти рецепти з меню."
        }
      ]
    };
  }
};
</script>

<style scoped>
.faq {
  max-width: 800px;
  margin: 0 auto;
}

h2 {
  color: #333;
}
</style>
