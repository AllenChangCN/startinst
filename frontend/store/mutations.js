const mutations = {
  // 切换显示左侧菜单
  set_layout_title(state,new_title){
    state.layout.title = new_title;
  },
  toggle_drawer(state){
    state.layout.drawer = !state.layout.drawer
  },
  show_global_snackbar(state,params){
    state.layout.global_snackbar = params;
  }
};

export default mutations
