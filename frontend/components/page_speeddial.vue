<template>
  <div class="text-xs-center" id="page_speeddial">
    <v-speed-dial
      class=""
      v-model="fab"
      bottom
      right
      fixed
      mode
      :direction="direction"
      :open-on-hover="true"
      :transition="transition">
      <v-btn
        slot="activator"
        v-model="fab"
        color="black darken-2"
        dark
        fab
        icon

        hover>
        <v-icon>edit</v-icon>
        <v-icon>clear</v-icon>
      </v-btn>
      <v-tooltip left>
        <v-btn
          fab
          slot="activator"
          dark
          small
          @click.native="$store.commit('toggle_editpage_dialog',{
            visible:true,
            title:'页面设置',
            page_id:9
          })"
          color="blue darken-2">
          <v-icon>settings</v-icon>
        </v-btn>
        <span>页面设置</span>
      </v-tooltip>
      <v-tooltip left>
        <v-btn
          fab
          slot="activator"
          dark
          small
          color="indigo">
          <v-icon>share</v-icon>
        </v-btn>
        <span>分享页面</span>
      </v-tooltip>
      <v-tooltip left>
        <v-btn
          fab
          slot="activator"
          dark
          small
          @click.native="$store.commit('show_global_snackbar',{
            show:true,
            text:'页面已删除',
            success: true
          })"
          color="red">
          <v-icon>delete</v-icon>
        </v-btn>
        <span>删除页面</span>
      </v-tooltip>
    </v-speed-dial>
  </div>

</template>
<script>
  export default {
    data: () => ({
      direction: 'top',
      fab: false,
      fling: false,
      transition: 'slide-y-reverse-transition'
    }),

    computed: {

    },

    watch: {
      top (val) {
        this.bottom = !val
      },
      right (val) {
        this.left = !val
      },
      bottom (val) {
        this.top = !val
      },
      left (val) {
        this.right = !val
      }
    }
  }
</script>
<style>
  #page_speeddial .speed-dial i.icon{
    display:flex;
    align-items:center;;}
</style>
