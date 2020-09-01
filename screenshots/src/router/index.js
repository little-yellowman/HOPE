import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../components/Login";
import Register from "../components/Register";
import screenshots from "../components/screenshots";
import index from "../components/admin/index.vue";
import StudentInfo from '../components/admin/StudentInfo.vue'
import Task from '../components/admin/Task.vue'
import Deatail from '../components/admin/Detail.vue'
import History from '../components/admin/History.vue'
Vue.use(VueRouter)

  const routes = [
    {path: '/', redirect: '/login'},
    {path: '/login', component: Login},
    {path: '/register',component: Register},
    {path: '/upload',component: screenshots},
	{
		path: '/admin', component: index,
		children:[
			{path:'/admin',redirect:'/stuinfo'},
			{path:'/stuinfo', component: StudentInfo},
			{path:'/task', component: Task},
			{path:'/detail', component: Deatail},
			{path: '/history', component: History}
		]
	}
	
]

const router = new VueRouter({
  routes
})

// 挂载路由导航守卫
router.beforeEach((to, from, next)=>{
	if(to.path === '/login' || to.path ==='/register') return next();
	
	const tokens = window.sessionStorage.getItem('token')
	if(!tokens) {
		// this.$message.error("请先登录~")
		return next('/login')
	}
	return next()
})

export default router
