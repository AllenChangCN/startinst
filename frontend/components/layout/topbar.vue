<template>
  <div>
    <v-toolbar color="amber" app absolute clipped-left>
      <v-toolbar-side-icon @click.native="$store.commit('toggle_drawer')"/>
      <!--Logo-->
      <span class="title ml-3 mr-5"><nuxt-link to="/" style="color: black;text-decoration: none;">{{$store.state.layout.title}}</nuxt-link></span>
      <!--搜索框-->
      <v-dialog v-model="engine_switcher"
                transition="dialog-bottom-transition"
                max-width="600"
      >
        <v-btn slot="activator" large flat>{{$store.state.layout.seacher.title}} &nbsp;<v-icon>expand_more</v-icon></v-btn>
        <v-list>
          <v-subheader>切换搜索引擎</v-subheader>
          <v-list-tile
            v-for="tile in tiles"
            :key="tile.title"
            @click="switch_seacher_chosen()"
          >
            <v-list-tile-avatar>
              <v-avatar size="32px" tile>
                <!--<img :src="`/static/doc-images/bottom-sheets/${tile.img}`" :alt="tile.title">-->
              </v-avatar>
            </v-list-tile-avatar>
            <v-list-tile-content>
              <v-list-tile-title>{{ tile.title }}</v-list-tile-title>
              <v-list-tile-sub-title>{{ tile.url }}</v-list-tile-sub-title>
            </v-list-tile-content>
            <v-list-tile-action/>
            <v-list-tile-action>
              <v-icon v-if="tile.active">check</v-icon>
            </v-list-tile-action>
          </v-list-tile>
        </v-list>
      </v-dialog>
      <v-text-field
        solo-inverted
        flat
        type="text"
        label="Search"
        v-model="keywords"
        prepend-icon="search"
        @keyup.13="search(keywords, $store.state.layout.seacher.url)"
      />
      <div style="width: 26px;"></div>
      <v-tooltip bottom>
        <v-btn flat icon slot="activator" @click.native="$store.commit('toggle_editpage_dialog',{
          visible:true,
          title:'添加页面',
        })">
          <v-icon>add</v-icon>
        </v-btn>
        <span>创建页面</span>
      </v-tooltip>
      <v-tooltip bottom>
        <v-btn flat icon slot="activator">
          <v-icon>bookmark_border</v-icon>
        </v-btn>
        <span>我的页面</span>
      </v-tooltip>
      <v-tooltip bottom>
        <v-btn flat icon slot="activator">
          <v-icon>notifications_none</v-icon>
        </v-btn>
        <span>消息通知 (2)</span>
      </v-tooltip>
      &nbsp;
      &nbsp;
      <!--账户菜单-->
      <v-menu
        offset-y
        open-on-hover
        :close-on-click="false"
        :close-on-content-click="false"
        close-delay>
        <v-btn slot="activator" flat icon large>
          <v-avatar color="white">
            <v-icon dark>account_circle</v-icon>
          </v-avatar>
        </v-btn>
        <v-card>
          <v-list>
            <v-list-tile avatar>
              <v-list-tile-avatar>
                <img src="" alt="John">
              </v-list-tile-avatar>
              <v-list-tile-content>
                <v-list-tile-title>John Leider</v-list-tile-title>
                <v-list-tile-sub-title>Founder of Vuetify.js</v-list-tile-sub-title>
              </v-list-tile-content>
              <v-list-tile-action>
                <v-btn
                  :class="'red--text'"
                  icon
                >
                  <v-icon>favorite</v-icon>
                </v-btn>
              </v-list-tile-action>
            </v-list-tile>
          </v-list>
          <v-divider/>
          <v-list>
            <v-list-tile>
              <v-list-tile-action>
                <v-switch color="purple"/>
              </v-list-tile-action>
              <v-list-tile-title>Enable messages</v-list-tile-title>
            </v-list-tile>
            <v-list-tile>
              <v-list-tile-action>
                <v-switch color="purple"/>
              </v-list-tile-action>
              <v-list-tile-title>Enable hints</v-list-tile-title>
            </v-list-tile>
          </v-list>
          <v-card-actions>
            <v-spacer/>
            <v-btn flat @click="menu = false">Cancel</v-btn>
            <v-btn color="primary" flat @click="menu = false">Save</v-btn>
          </v-card-actions>
        </v-card>
      </v-menu>
      &nbsp;
      &nbsp;
      &nbsp;
    </v-toolbar>

    <edit_page_dialog/>
  </div>

</template>
<script>
    import { mapMutations,store } from 'vuex'
    import edit_page_dialog from '../page/edit_page'
    export default {
      name: "search",
      data: () => {
        return {
          engine_switcher: null,
          tiles:[
            { img: 'inbox.png', title: 'GOOGLE' ,url: 'https://www.google.com/search?q=',active:true},
            { img: 'inbox.png', title: 'BAIDU' ,url: 'https://www.baidu.com/s?wd=',active:false},
            { img: 'keep.png', title: 'STARTINST' ,url:'https://startinst.com',active:false}
          ],
          keywords: ''
        }
      },
      mounted() {
        this.engine_switcher = false;
      },
      methods: {
        switch_seacher_chosen:function (){
          this.engine_switcher = false;
          this.$store.commit('show_global_snackbar',{
            text:"切换成功",
            show:true,
            success: true,
            timeout: 600
          });
        },
        search: (keywords, active_seacher_url) => {
          window.open(active_seacher_url + keywords, '_blank')
        }
      },
      components: {
        edit_page_dialog
      }
    }
</script>

<style scoped>
  .el-select .v-input {
    width: 130px;
  }

  .input-with-select .v-input-group__prepend {
    background-color: #fff;
  }
</style>
