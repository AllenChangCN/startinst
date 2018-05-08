import Vuex from 'vuex'

import mutations from './mutations'

const createStore = () => {
  return new Vuex.Store({
    state: {
      layout:{
        title: "StartInst.",
        drawer: false,
        global_snackbar:{
          text:"默认通知",
          show:false,
          timeout:600,
          success: true
        },
        seacher: {
          title:"Google",
          url:"https://www.google.com/search?q="
        },
        dialog: {
          page_edit:{
            visible:false,
            title:"添加页面",
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
        sort_mode:true
      }
    },
    mutations
  })
}

export const state = () => ({
  locales: ['en', 'fr'],
  locale: 'en',

})

// export const mutations = {
//   SET_LANG(state, locale) {
//     if (state.locales.indexOf(locale) !== -1) {
//       state.locale = locale
//     }
//   }
// }
export default createStore
