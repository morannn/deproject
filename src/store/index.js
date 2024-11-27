import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)
// 记事本
const notepad = {
  namespaced: true,
  state: {
    content: ''
  },
  getters: {},
  mutations: {},
  actions: {}
}

export default new Vuex.Store({
  state: {
    myData: null
  },
  mutations: {
    // 定义一个 mutation 来更新 myData
    SET_MY_DATA(state, data) {
      state.myData = data;
    }
  },
  actions: {
    // 如果需要在异步操作后调用 mutation，可以定义一个 action
    setMyData({ commit }, data) {
      commit('SET_MY_DATA', data);
    }
  }
});
