<template>
  <v-app id="inspire">
    <!--菜单-->
    <nav_drawer/>
    <topbar/>
    <global_snackbar/>
    <context_menu/>
    <!--主体页面-->
    <v-content>
      <v-layout>
          <nuxt style="width: 100%;"/>
      </v-layout>
    </v-content>
  </v-app>
</template>

<script>
  import topbar from "../components/global/topbar"
  import nav_drawer from "../components/global/nav_drawer"
  import global_snackbar from "../components/global/snackbar"
  import context_menu from '../components/global/context_menu'

  export default {
    data: () => ({

    }),
    head () {
      return {
        title:'StartInst. - 上网，从这里开始',
        meta: [
          { hid: 'description', name: 'description', content: 'My custom description' }
        ]
      }
    },
    components:{
      topbar,nav_drawer,global_snackbar,context_menu
    },
    props: {
      source: String
    }
  }
</script>

<style>

</style>
