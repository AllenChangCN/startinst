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
  import http from "../components/global/http"

  export default {
    mounted(){

    },
    data: () => ({

    }),
    head () {
      return {
        title:'StartInst. - 让连接创造更大的价值',
        meta: [
          { hid: 'description', name: 'description', content: '网络连接器' }
        ]
      }
    },
    components:{
      topbar,nav_drawer,global_snackbar,global_dialog_confirm,http
    }
  }
</script>

<style>

</style>
