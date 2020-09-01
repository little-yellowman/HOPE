import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
import router from './router'
import './plugins/element.js'

Vue.config.productionTip = false
Vue.config.devtools = true

//请求拦截
axios.interceptors.request.use(function (config) {
    // console.log(config)
    if(sessionStorage.getItem('token')){
        config.headers.token =sessionStorage.getItem('token')
    }
    return config
}, function (error) {
    return Promise.reject(error)
});

// 配置请求的根路径
axios.defaults.baseURL = 'http://127.0.0.1:8081/ssss/'
// Vue.prototype给 组件 起别名
Vue.prototype.$http = axios
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')

