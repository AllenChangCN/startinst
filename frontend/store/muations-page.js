import axios from '~/plugins/axios'
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
  },
  // 加载当前页面的数据
  load_current_page(state,param){
    let that = this;
    axios.get('/page/'+param.page_id+'/info').then(function(response){
      that.commit('set_page_info',response.data.data);
    });
  },
  // 删除Widget的确认框
  toggle_widget_delete_dialog(state,param){
    if(param.action === 'confirm')   // action: confirm、show、close
    {
      this.commit("menu_widget_delete",state.widget.current);
    }
    state.page.current.widget_delete_dialog = !state.page.current.widget_delete_dialog;
  },
  // 切换Widget对话框的可见性
  toggle_widget_edit_dialog(state,param){
    if(param.action === 'save')   // action: show/save/close
    {
      this.commit('create_widget');
    }
    state.page.current.widget_edit_dialog = !state.page.current.widget_edit_dialog;
  }
}
