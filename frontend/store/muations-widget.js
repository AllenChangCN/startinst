export default {
  // 在新标签中打开连接
  toggle_open_link_in_new_tab(state){
    state.page.open_link_in_new_tab = !state.page.open_link_in_new_tab;
  },
}
