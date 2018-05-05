module.exports = {
    css: [
      'vuetify/dist/vuetify.min.css',
      'material-design-icons-iconfont/dist/material-design-icons.scss',
    ],
  /*
  ** Headers of the page
  */
  head: {
    title: 'StartInst.',
    meta: [
        { charset: 'utf-8' },
        { name: 'viewport', content: 'width=device-width, initial-scale=1' },
        { hid: 'description', name: 'description', content: 'Nuxt.js project' }
    ],

    link: [
      { href:'//fonts.cat.net/css?family=Roboto:300,400,500,700|Material+Icons',type:'stylesheet'},
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
