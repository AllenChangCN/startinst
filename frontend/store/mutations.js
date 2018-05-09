const mutations = {
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
  toggle_page_sortmode(state){     // 页面的widget是否在排序模式
    state.page.current.sort_mode = !state.page.current.sort_mode;
  },
  // 页面编辑状态
  toggle_page_editable(state){
    state.page.current.editable = !state.page.current.editable;
  },
  // 在新标签中打开连接
  toggle_open_link_in_new_tab(state){
    state.page.open_link_in_new_tab = !state.page.open_link_in_new_tab;
  },
  // 显示右键菜单
  show_context_menu(state,e){
    state.layout.contextmenu.x = e.clientX;
    state.layout.contextmenu.y = e.clientY;
    state.layout.contextmenu.show_menu = true
  }
};

export default mutations
