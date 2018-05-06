<template>
  <v-toolbar color="amber" app absolute clipped-left>
    <v-toolbar-side-icon @click.native="$store.commit('toggle_drawer')"/>
    <!--Logo-->
    <span class="title ml-3 mr-5"><nuxt-link to="/" style="color: black;text-decoration: none;">{{$store.state.layout.title}}</nuxt-link></span>
      <!--搜索框-->
      <v-dialog v-model="search_sheet"
                transition="dialog-bottom-transition"
                max-width="600"
      >
        <v-btn slot="activator" large flat>{{$store.state.layout.seacher.title}} &nbsp;<v-icon>expand_more</v-icon></v-btn>
        <v-list>
          <v-subheader>选择搜索引擎</v-subheader>
          <v-list-tile
            v-for="tile in tiles"
            :key="tile.title"
            @click="search_sheet=false"
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
        <v-btn flat icon slot="activator" @click.native="$store.commit('show_global_snackbar',{
          text:'页面创建成功',
          show:true
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
              <!--<img src="/static/doc-images/john.jpg" alt="John">-->
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
</template>
<script>
    // import { mapMutations } from 'vuex'
    export default {
      name: "search",
      data: () => {
        return {
          search_sheet: false,
          tiles:[
            { img: 'inbox.png', title: 'GOOGLE' ,url: 'https://www.google.com/search?q=',active:true},
            { img: 'inbox.png', title: 'BAIDU' ,url: 'https://www.baidu.com/s?wd=',active:false},
            { img: 'keep.png', title: 'STARTINST' ,url:'https://startinst.com',active:false},
          ],
          keywords: ''
        }
      },
      mounted() {
      },
      methods: {
        search: (keywords, active_seacher_url) => {
          window.open(active_seacher_url + keywords, '_blank')
        },
        switch_seacher_chosen:() => {
          // this.search_sheet = false;

          // this.$store.commit('show_global_snackbar',{
          //   text:"默认通知",
          //   show:true,
          //   success: true
          // });
        }
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
