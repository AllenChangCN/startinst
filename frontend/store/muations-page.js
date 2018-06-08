export default {
  toggle_page_sortmode(state){     // 页面的widget是否在排序模式
    state.page.current.sort_mode = !state.page.current.sort_mode;
  },

  toggle_editpage_dialog(state,params){     // 页面编辑Dialog
    state.global.dialog.page_edit = params
  },
  // 页面编辑状态
  toggle_page_editable(state){
    state.page.current.editable = !state.page.current.editable;
  },
  // 显示右键菜单
  show_context_menu(state,params){
    state.page.contextmenu.items = params.items;
    state.page.contextmenu.x = params.e.clientX;
    state.page.contextmenu.y = params.e.clientY;
    state.page.contextmenu.show_menu = true;
  },
  set_page_info(state,param){
    state.page.current.pageInfo = param;
  }
}
