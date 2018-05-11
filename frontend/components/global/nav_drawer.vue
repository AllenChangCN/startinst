<template>
  <div>
    <v-navigation-drawer
      v-model="$store.state.global.drawer"
      clipped
      fixed
      class="grey lighten-5"
      hide-overlay
      app
      :stateless="true"
      width="200"
    >
      <v-list
        dense
        class="grey lighten-5"
      >
        <template v-for="(item, i) in items">
          <v-layout
            v-if="item.heading"
            :key="i"
            row
            align-center>
            <v-flex xs6>
              <v-subheader v-if="item.heading">
                {{ item.heading }}
              </v-subheader>
            </v-flex>
            <v-flex xs6 class="text-xs-right">
            </v-flex>
          </v-layout>
          <v-divider
            v-else-if="item.divider"
            :key="i"
            dark
            class="my-3"/>
          <v-list-tile
            v-else
            :to="item.path"
            :key="i">
            <v-list-tile-action>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title class="grey--text">
                {{ item.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </template>
      </v-list>
      <v-footer class="pa-3 grey lighten-5" inset absolute>
        <p class="grey--text">&copy; StartInst. {{ new Date().getFullYear() }} 服务条款</p>
      </v-footer>
    </v-navigation-drawer>
  </div>

</template>

<script>
    export default {
      name: "nav_drawer",
      mounted(){
      },
      data: () => ({
        items: [
          { heading: '导航菜单' },

          { icon: 'home', text: '我的首页' ,path: '/'},
          { icon: 'book', text: '页面管理' ,path: '/mine/page-mgr'},
          { icon: 'explore', text: '发现页面' ,path: '/discover/inst-page'},
          // { icon: 'apps', text: '热门应用',path: '/discover/hot-apps' },
          { icon: 'extension', text: '浏览器插件' ,path: '/help/extension'},

          { divider: true },

          { icon: 'keyboard', text: '键盘快捷键' ,path: '/help/shortcut'},
          { icon: 'question_answer', text: '在线社区',path: '/help/discuss' },

        ]
      }),
      methods:{

      }
    }
</script>

<style>
  #keep main .container {
    height: 660px;
  }
  .navigation-drawer__border {
    display: none;
  }
  .text {
    font-weight: 400;
  }

</style>
