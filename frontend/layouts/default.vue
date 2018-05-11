<template>
  <v-app id="inspire">
    <!--菜单-->
    <nav_drawer/>
    <topbar/>
    <global_snackbar/>
    <global_dialog_confirm style="display: none;"/>
    <context-menu/>
    <!--主体页面-->
    <v-content>
      <v-layout>
          <nuxt style="width: 100%;"/>
      </v-layout>
    </v-content>
  </v-app>
</template>

<script>
  import topbar from "../components/layout/topbar"
  import nav_drawer from "../components/layout/nav_drawer"
  import global_snackbar from "../components/layout/global_snackbar"
  import global_dialog_confirm from "../components/layout/global_dialog_confirm"
  import contextMenu from '../components/layout/context_menu'

  export default {
    data: () => ({

    }),
    components:{
      topbar,nav_drawer,global_snackbar,global_dialog_confirm,contextMenu
    },
    props: {
      source: String
    }
  }
</script>

<style>

</style>
