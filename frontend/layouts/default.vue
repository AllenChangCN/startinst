<template>
  <v-app id="inspire">
    <!--菜单-->
    <nav_drawer/>
    <topbar/>
    <global_snackbar/>
    <!--主体页面-->
    <v-content>
      <v-layout>
          <nuxt/>
      </v-layout>
    </v-content>
  </v-app>
</template>

<script>
  import topbar from "../components/layout/topbar"
  import nav_drawer from "../components/layout/nav_drawer"
  import global_snackbar from "../components/layout/global_snackbar"
  export default {
    data: () => ({

    }),
    components:{
      topbar,nav_drawer,global_snackbar
    },
    props: {
      source: String
    }
  }
</script>

<style>

</style>
