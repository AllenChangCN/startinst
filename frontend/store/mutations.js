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
  },
  toggle_editpage_dialog(state,params){
    state.layout.dialog.page_edit = params
  },
  toggle_page_sortmode(state){
    state.page.current.sort_mode = !state.page.current.sort_mode;
  },
  toggle_page_editable(state){
    state.page.current.editable = !state.page.current.editable;
  },
  toggle_open_link_in_new_tab(state){
    state.page.open_link_in_new_tab = !state.page.open_link_in_new_tab;
  }
};

export default mutations
