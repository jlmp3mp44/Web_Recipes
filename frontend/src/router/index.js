import Home from "@/pages/Home.vue";
import SignUp from "@/components/SignUp.vue";
import Login from "@/components/Login.vue";
import FAQ from "@/pages/FAQPage.vue";
import About from "@/pages/About.vue";
import Recipes from "@/pages/RecipesPage.vue";
import { createRouter, createWebHistory } from "vue-router";

const routes = [
    { path: '/', component: Home },
    { path: '/home', component: Home},
    { path: '/signup', component: SignUp},
    { path:  '/login', component: Login},
    { path:  '/faq', component: FAQ},
    { path:  '/about', component: About},
    { path:  '/recipes', component: Recipes},
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})
export default router;

