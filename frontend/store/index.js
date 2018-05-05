import Vuex from 'vuex'

import mutations from './mutations'

const createStore = () => {
  return new Vuex.Store({
    state: {
      counter: 0,
      drawer: false
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
