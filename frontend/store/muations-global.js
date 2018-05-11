export default {
  // 切换显示左侧菜单
  set_layout_title(state,new_title){
    state.layout.title = new_title;
  },
  toggle_drawer(state){
    state.layout.drawer = !state.layout.drawer;
    this.commit('show_global_snackbar',{
      text:"按下\"Alt+M\"开关菜单栏",
      show:true,
      success: null,
      timeout: 2000
    });
  },
  show_global_snackbar(state,params){    // 右下角通知框
    state.layout.global_snackbar = params;
  },
  toggle_editpage_dialog(state,params){     // 页面编辑Dialog
    state.layout.dialog.page_edit = params
  },
  // 显示右键菜单
  show_context_menu(state,data){
    state.layout.contextmenu.items = data.items;
    state.layout.contextmenu.x = data.e.clientX;
    state.layout.contextmenu.y = data.e.clientY;
    state.layout.contextmenu.show_menu = true;

  }
}
