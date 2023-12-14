<template>
  <div>
    <div v-for="(item, index) in items" :key="index" class="accordion-item">
      <div @click="toggleItem(index)" class="accordion-header">
        <span>{{ item.question }}</span>
        <font-awesome-icon :icon="['fas', 'chevron-down']" :class="{ 'rotate-icon': activeItem === index }" />
      </div>
      <div v-show="activeItem === index" class="accordion-content">
        {{ item.answer }}
      </div>
    </div>
  </div>
</template>

<script>
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faChevronDown } from '@fortawesome/free-solid-svg-icons';

export default {
  components: {
    FontAwesomeIcon,
  },
  props: {
    items: Array,
  },
  data() {
    return {
      activeItem: null,
    };
  },
  methods: {
    toggleItem(index) {
      this.activeItem = this.activeItem === index ? null : index;
    },
  },
};
</script>

<style scoped>
.accordion-item {
  border: 1px solid #ddd;
  margin-bottom: 10px;
}

.accordion-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px;
  cursor: pointer;
  background-color: #f8f9fa;
}

.accordion-content {
  padding: 0 10px 50px 20px;
  border-top: 1px solid #ddd;
  overflow: hidden; /* Додаємо стиль overflow */
  max-height: 0; /* За замовчуванням приховуємо контент */
  transition: max-height 0.3s ease-in-out; /* Задаємо анімацію для плавного розгортання */
}

.rotate-icon {
  transform: rotate(180deg);
}

/* Додаємо стиль, щоб контент розгортався, коли активний */
.accordion-content.show {
  max-height: 1000px; /* Максимальна висота для розгортання контенту */
}
</style>
