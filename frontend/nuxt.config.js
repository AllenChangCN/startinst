module.exports = {
    css: [

    ],
  /*
  ** Headers of the page
  */
  head: {
    title: 'pagepots',
    meta: [
        { charset: 'utf-8' },
        { name: 'viewport', content: 'width=device-width, initial-scale=1' },
        { hid: 'description', name: 'description', content: 'Nuxt.js project' }
    ],

    link: [
      { href:'https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons',type:'stylesheet'},
      { rel: 'icon', type: 'image/x-icon', href: '/favicon.ico' },
    ],

  },

  /*
  ** Customize the progress bar color
  */
  loading: { color: '#3B8070' },
  plugins: [
    '~/plugins/vuetify'
  ],

    /*
    ** Build configuration
    */

    build: {
        /*
        ** Run ESLint on save
        */
        extend (config, { isDev, isClient }) {
          if (isDev && isClient) {
            config.module.rules.push({
              enforce: 'pre',
              test: /\.(js|vue)$/,
              loader: 'eslint-loader',
              exclude: /(node_modules)/
            })
          }
        },
        router: {
            base: '/client/'
        }
  },
}
