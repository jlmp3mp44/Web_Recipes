import { createApp } from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import router from '@/router/index';
import { library } from '@fortawesome/fontawesome-svg-core'
import { fas } from '@fortawesome/free-solid-svg-icons'
import { far } from '@fortawesome/free-regular-svg-icons'
import { fab } from '@fortawesome/free-brands-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'
import VueTheMask from 'vue-the-mask'
import axios from 'axios';

library.add(fas, far, fab)

const app = createApp(App);
app.component('font-awesome-icon', FontAwesomeIcon)
axios.defaults.baseURL = 'http://localhost:8080';

app.use(router);
app.use(VueTheMask);

app.mount('#app')
