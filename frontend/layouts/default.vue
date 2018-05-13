<template>
  <v-app id="inspire">
    <!--菜单-->
    <nav_drawer/>
    <topbar/>
    <global_snackbar/>
    <global_dialog_confirm style="display: none;"/>
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
  import global_dialog_confirm from "../components/global/dialog_confirm"

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
      topbar,nav_drawer,global_snackbar,global_dialog_confirm
    },
    props: {
      source: String
    }
  }
</script>

<style>

</style>
