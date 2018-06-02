module.exports = {
  css: [
    'vuetify/dist/vuetify.min.css',
    'material-design-icons-iconfont/dist/material-design-icons.scss',
  ],
  modules: [
    '@nuxtjs/axios',
    '@nuxtjs/proxy'
  ],
  axios: {
    baseURL: "http://localhost:8080/api",
    // proxy: true // Can be also an object with default options
  },
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
  cache: {
    max: 1000,
    maxAge: 900000
  },
  /*
  ** Customize the progress bar color
  */
  loading: { color: '#333',height:'3px',failedColor:'red' },
  plugins: [
    '~/plugins/vuetify',
    '~/plugins/axios',
    '~/plugins/filters'
  ],
  performance:{
    gzip: true,
    prefetch: true
  },

  /*
  ** Build configuration
  */

  build: {
      vendor: ['axios'],
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
