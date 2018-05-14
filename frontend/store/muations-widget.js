export default {
  // 在新标签中打开连接
  toggle_open_link_in_new_tab(state){
    state.page.open_link_in_new_tab = !state.page.open_link_in_new_tab;
  },
  bookmark_openlink(state,params){
    let target = '';
    if(params.force_new_tab!==null){
      if(params.force_new_tab===true){
        target = '_blank';
      }else{
        target = '_top';
      }
    }else{
      if(state.page.open_link_in_new_tab){
        target = '_blank';
      }else{
        target = '_top'
      }
    }
    window.open(params.item.url,target)
  },
  bookmark_deletelink(state,params){
    this.commit('show_global_snackbar',{
      text:"链接已删除",
      show:true,
      success: null,
      timeout: 2000
    });
  }
}