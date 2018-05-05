<template>
  <v-toolbar color="amber" app absolute clipped-left>
    <v-toolbar-side-icon @click.native="$store.commit('toggle_drawer')"/>
    <!--Logo-->
    <span class="title ml-3 mr-5"><nuxt-link to="/" style="color: black;text-decoration: none;">StartInst.</nuxt-link></span>
      <!--搜索框-->
      <v-bottom-sheet v-model="search_sheet">
        <v-btn slot="activator" large flat>{{engine}} &nbsp;<v-icon>expand_more</v-icon></v-btn>
        <v-list>
          <v-subheader>选择搜索引擎</v-subheader>
          <v-list-tile
            v-for="tile in tiles"
            :key="tile.title"
            @click="search_sheet = false"
          >
            <v-list-tile-avatar>
              <v-avatar size="32px" tile>
                <!--<img :src="`/static/doc-images/bottom-sheets/${tile.img}`" :alt="tile.title">-->
              </v-avatar>
            </v-list-tile-avatar>
            <v-list-tile-title>{{ tile.title }}</v-list-tile-title>
          </v-list-tile>
        </v-list>
      </v-bottom-sheet>

      <v-text-field
        solo-inverted
        flat
        type="text"
        label="Search"
        prepend-icon="search"
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
        <v-divider></v-divider>
        <v-list>
          <v-list-tile>
            <v-list-tile-action>
              <v-switch color="purple"></v-switch>
            </v-list-tile-action>
            <v-list-tile-title>Enable messages</v-list-tile-title>
          </v-list-tile>
          <v-list-tile>
            <v-list-tile-action>
              <v-switch color="purple"></v-switch>
            </v-list-tile-action>
            <v-list-tile-title>Enable hints</v-list-tile-title>
          </v-list-tile>
        </v-list>
        <v-card-actions>
          <v-spacer></v-spacer>
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
    import { mapMutations } from 'vuex'
    export default {
      name: "search",
      data: () => {
        return {
          search_sheet: false,
          engine: "Google",
          tiles:[
            { img: 'inbox.png', title: 'Google' ,url: 'https://www.google.com/search?q='},
            { img: 'inbox.png', title: 'Baidu' ,url: 'https://www.baidu.com/s?wd='},
            { img: 'keep.png', title: 'StartInst' },
          ],
          search_url: 'https://www.google.com/search?q=',
          keywords: '',

        }
      },
      mounted() {
        this.engine = "Google";
        this.search_url = 'https://www.google.com/search?q=';
      },
      methods: {
        search: (keywords, search_url) => {
          window.open(search_url + keywords, '_blank')
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
