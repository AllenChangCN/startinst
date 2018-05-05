<template>
  <v-app id="inspire">
    <!--菜单-->
    <nav_drawer/>
    <topbar/>
    <v-content>
      <v-container fluid fill-height class="grey lighten-4">
        <v-layout justify-center align-center>
            <nuxt/>
        </v-layout>
      </v-container>
    </v-content>

  </v-app>
</template>

<script>
  import topbar from "../components/layout/topbar"
  import nav_drawer from "../components/layout/nav_drawer"
  export default {
    data: () => ({

    }),
    components:{
      topbar,nav_drawer
    },
    props: {
      source: String
    }
  }
</script>

<style>

</style>
