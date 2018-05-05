const mutations = {
  increment(state) {
    state.counter++
  },
  // 切换显示左侧菜单
  toggle_drawer(state){
    state.drawer = !state.drawer
  }
};

export default mutations
