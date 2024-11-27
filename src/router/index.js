import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
import Login from '@/components/Login.vue'
import manager from '@/components/manager/manager.vue'
import managerAside from '@/components/manager/manager-aside.vue'
const routes = [
  // 重定向
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  { path: '/manager', component: manager },
  { path: '/aside', component: managerAside },
]

const router = new VueRouter({
  mode: 'hash',
  routes
})
// 安全路由守卫


export default router
