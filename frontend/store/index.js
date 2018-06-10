import Vuex from 'vuex'
import mutations from './mutations'

const createStore = () => {
  return new Vuex.Store({
    state: {
      global:{
        userinfo:{
          userId: '',
        },
        title: "StartInst.",
        authenticated:false,
        drawer: false,// 左侧菜单栏
        global_snackbar:{ // 右下角的通知
          text:"默认通知",
          show:false,
          timeout:600,
          success: true
        },
        seacher: {      // 搜索框
          title:"Google",
          url:"https://www.google.com/search?q="
        },
        dialog: {
          confirm:{
            visible:false,
            title: '确认框',
            content: '确认内容',
            btn_actions:{}
          },
          page_edit:{
            visible:false,
            title:"创建页面",
            page_id:0
          },
          notification:{visible:false},
          signin:{
            visible:false
          },
          signup:{
            visible:false
          }
        }
      },
      page:{
        open_link_in_new_tab:true,
        current:{
          sort_mode:false,
          editable: false,
          is_owner: false,
          pageInfo: {widgetList:[]}
        },
        contextmenu:{     // 右键菜单
          show_menu:false,
          x:0,
          y:0,
          items:[]  // 菜单列表
        },

      },
      widget:{

      }
    },
    mutations
  })
};

export const state = () => ({
  locales: ['en', 'fr'],
  locale: 'en',

});

// export const mutations = {
//   SET_LANG(state, locale) {
//     if (state.locales.indexOf(locale) !== -1) {
//       state.locale = locale
//     }
//   }
// }
export default createStore
