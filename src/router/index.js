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
router.beforeEach((to, from, next) => {
  // to表示去哪个路由，from表示来自哪个路由，next表示放行
  if (to.path === '/manager' || to.path === '/aside') {
    // 判断要去的路由条件
    if (localStorage.getItem('token')) {
      next() // 放行
    } else {
      next('/login')
    }
  } else {
    next()
  }
})

export default router
