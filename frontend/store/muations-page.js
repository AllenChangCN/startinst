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
}
