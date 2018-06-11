import axios from '~/plugins/axios'
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
  },
  // 设置当前操作的Widget的数据
  set_widget_current_data(state, param){
    state.widget.current = param;
  },
  // Widget编辑菜单
  menu_widget_delete(state, params){
    let that = this;
    state.page.current.pageInfo.widgetList.forEach(function(elem,i){
      if(elem.id === params.id){  // 删除与选定widget ID相等的
        axios.post('widgets/'+elem.id+'/delete').then(function(response)
        {
          if(response.data.code === "0") // 从服务器上删除成功
          {
            let ret = state.page.current.pageInfo.widgetList.splice(i, 1);
            console.log('splice widget id: ',ret[0].id);
            that.commit('show_global_snackbar',{
              text:"面板已删除",
              show:true,
              success: null,
              timeout: 2000
            });
          }
        });
      }
    })
  }
}
