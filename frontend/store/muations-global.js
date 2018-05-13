export default {
  // 切换显示左侧菜单
  set_layout_title(state,new_title){
    state.global.title = new_title;
  },
  toggle_drawer(state){
    state.global.drawer = !state.global.drawer;
    this.commit('show_global_snackbar',{
      text:"按下\"Alt+M\"开关菜单栏",
      show:true,
      success: null,
      timeout: 2000
    });
  },
  show_global_snackbar(state,params){    // 右下角通知框
    state.global.global_snackbar = params;
  },
  // 显示右键菜单
  show_context_menu(state,params){
    state.global.contextmenu.items = params.items;
    state.global.contextmenu.x = params.e.clientX;
    state.global.contextmenu.y = params.e.clientY;
    state.global.contextmenu.show_menu = true;
  },
  // 显示确认框
  show_global_confirm(state, params){
    state.global.dialog.confirm.visible = params.visible;
    state.global.dialog.confirm.title = params.title;
    state.global.dialog.confirm.content = params.content;
    state.global.dialog.confirm.btn_action.cancel.muation = params
    if(params.btn_click==='confirm'){
      this.commit(params.muation,params.params);
    }
    if(params.btn_click==='cancel'){
      this.commit(params.cancel_muation,params.params)
    }
  }
}
