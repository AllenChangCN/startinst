export default {
  // 在新标签中打开连接
  toggle_open_link_in_new_tab(state){
    state.page.open_link_in_new_tab = !state.page.open_link_in_new_tab;
  },
  bookmark_openlink(state,param){
    let target = '';
    if(param.force_new_tab!==null){
      if(param.force_new_tab===true){
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
    window.open(param.item.url,target)
  }
}
