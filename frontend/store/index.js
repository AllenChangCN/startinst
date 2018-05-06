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
        }
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
