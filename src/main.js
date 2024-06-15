import Vue from 'vue';
import App from './App.vue';
import ElementUI from "element-ui";
import 'element-ui/lib/theme-chalk/index.css';
import router from "@/router/index.js";
import axios from "axios";
import './assets/global.css';
import * as echarts from 'echarts';
import { createPinia } from 'pinia'
import piniaPersist from 'pinia-plugin-persist'


// 引入pinia 与其插件
const pinia = createPinia()
Vue.use(pinia)
pinia.use(piniaPersist)


Vue.prototype.$echarts = echarts;
Vue.prototype.$axios = axios;
Vue.config.productionTip = false;

Vue.use(router);
Vue.use(ElementUI);

new Vue({
    render: h => h(App),
    router
}).$mount('#app')
