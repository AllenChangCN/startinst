<template>
  <v-menu
    v-model="$store.state.layout.contextmenu.show_menu"
    :position-x="$store.state.layout.contextmenu.x"
    :position-y="$store.state.layout.contextmenu.y"
    offset-y
    close-on-content-click
    transition="scale-transition"
    absolute
    style="display: none;"
  >
    <v-list id="contextmenu">
      <v-list-tile v-for="item in $store.state.layout.contextmenu.items" :key="item.title" @click="$store.commit(item.action)">
        <v-list-tile-title icon>
          <v-icon small>{{ item.icon }}</v-icon> {{ item.title }}</v-list-tile-title>
      </v-list-tile>
    </v-list>
  </v-menu>
</template>

<script>
    export default {
      name: "context_menu",
      data: () => ({

      }),
      methods: {
        menu:function () {

        }
      },
      mounted(){
        // console.log('hello context')
      }
    }
</script>

<style>
  .portrait.card{
    margin: 0 auto;
    max-width: 600px;
    width: 100%;
  }
  #contextmenu .list__tile{height: 26px;font-size: 14px;padding: 0 10px;}

</style>
