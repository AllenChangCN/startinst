<template>
  <div>
    <!--Widget排序模式-->
    <div class="widget sortmode" v-if="$store.state.page.current.sort_mode">
      <v-card v-if="widgetData.widgetType==='AD'" class="ad">
        <v-card-title>
          <v-icon size="19px">monetization_on</v-icon> &nbsp;&nbsp;<b>赞助商</b>
        </v-card-title>
      </v-card>
      <v-card v-else>
        <v-card-title>
          <div style="width: 100%;">
            <div style="display: flex;">
              <div style="flex: 100%;">
                <!--idget图标-->
                <v-icon v-if="widgetData.widgetType==='NOTE'" size="19px">event_note</v-icon>
                <v-icon v-if="widgetData.widgetType==='BOOKMARK'" size="19px">bookmark_border</v-icon>
                &nbsp;<b>{{widgetData.title}}</b>
              </div>
            </div>
          </div>
        </v-card-title>
      </v-card>
    </div>
    <!--正常模式-->
    <div class="widget" v-if="!$store.state.page.current.sort_mode">
      <!--广告Widget-->
      <v-card v-if="widgetData.widgetType ==='AD'">
        <v-card-title>
          <v-icon size="19px">monetization_on</v-icon> &nbsp;&nbsp;<b>赞助商</b>
        </v-card-title>
      </v-card>
      <v-card v-else @mouseenter="widgetEnter()" @mouseleave="widgetLeave()">
        <!--Widget标题-->
        <v-card-title>
          <div style="width: 100%;">
            <div style="display: flex;">
              <div style="flex: 100%;">
                <v-icon v-if="widgetData.widgetType==='NOTE'" size="19px">event_note</v-icon>
                <v-icon v-if="widgetData.widgetType==='BOOKMARK'" size="19px">bookmark_border</v-icon>
                &nbsp;<b>{{widgetData.title}}</b>
              </div>
              <!--Widget菜单-->
              <div style="flex: 1;min-width: 80px;text-align: right;margin-right: 6px;">
                <v-tooltip right>
                  <v-icon slot="activator" size="18px" v-if="widgetData.widgetType==='NOTE'&&posX+'_'+widgetData.posY===columnOverIdx+'_'+widgetOverIdx">
                    edit
                  </v-icon>
                  <span v-if="widgetData.widgetType==='NOTE'">编辑</span>
                  <v-icon slot="activator" size="22px" v-if="widgetData.widgetType==='BOOKMARK'&&posX+'_'+widgetData.posY===columnOverIdx+'_'+widgetOverIdx">
                    add
                  </v-icon>
                  <span v-if="widgetData.widgetType==='BOOKMARK'">添加</span>
                </v-tooltip>
                &nbsp;
                <v-menu
                  offset-y
                  open-on-hover
                  lazy
                  transition="scale-transition"
                  :open-delay="200"
                >
                  <!--<v-btn slot="activator" color="primary" dark>Dropdown</v-btn>-->
                  <v-icon slot="activator" @click="widgetMenu()" size="22px">menu</v-icon>
                  <v-list class="widget_menu_list">
                    <v-list-tile @click="widgetMenu()">
                      <v-list-tile-title><v-icon size="small">settings</v-icon> 面板设置</v-list-tile-title>
                    </v-list-tile>
                    <v-list-tile @click="widgetMenu()">
                      <v-list-tile-title><v-icon size="small">input</v-icon> 复制到</v-list-tile-title>
                    </v-list-tile>
                    <v-list-tile @click="widgetMenuDelete(widgetData)">
                      <v-list-tile-title><v-icon size="small">delete</v-icon> 删除面板</v-list-tile-title>
                    </v-list-tile>
                  </v-list>
                </v-menu>
              </div>
            </div>
            <span class="grey--text" v-if="widgetData.description">{{widgetData.description}}posX:{{widgetData.posX}},posY:{{widgetData.posY}}</span>
          </div>
        </v-card-title>
        <v-card-text v-if="widgetData.widgetType==='BOOKMARK'"> <!-- 书签 -->
          <div v-if="widgetData.content">
            <!--拖拽排序Link-->
            <draggable v-model="widgetData.content" :options="{group:'people'}" @start="drag=true" @end="drag=false">
              <div v-for="item in widgetData.content" :key="item.id">
              <span
                class="link"
                @click.stop="$store.commit('BOOKMARK_openlink',{item:item,force_new_tab:null})"
                @contextmenu.prevent="openContextMenu($event,item)"
              >
                {{ item.title }}
              </span>
              </div>
            </draggable>
          </div>
          <div v-else>
            暂无书签
          </div>
        </v-card-text>
        <v-card-text v-if="widgetData.widgetType === 'NOTE'">
          <div v-if="widgetData.content">
            <span v-html="widgetData.content"></span>
          </div>
          <div v-else>
            暂无内容
          </div>
        </v-card-text>
      </v-card>
    </div>
  </div>


</template>

<script>
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
  export default {
    name: "widget",
    components: {
      draggable, Sortable
    },
    mounted(){
      // console.log(this.widgetData);
    },
    data: () => ({
      widgetOverIdx: null,
      columnOverIdx: null,
      linkContextmenuItems:[
        { title: '新页面打开' ,icon:'open_in_new' ,mutation:'bookmark_openlink',params:{force_new_tab:true}},
        { title: '当前页面打开' ,icon:'open_in_browser' ,mutation:'bookmark_openlink',params:{force_new_tab:false}},
        { title: '编辑书签' ,icon:'edit' ,mutation:false,params:{}},
        { title: '删除书签' ,icon:'delete',mutation:'bookmark_deletelink',params:{}}
      ]
    }),
    watch:{
      widgetData:function () {
        console.log(this.widgetData)
      }
    },
    methods: {
      openContextMenu:function (e,item) {
        let that = this;
        this.linkContextmenuItems.forEach(function (elem,i) {
          that.linkContextmenuItems[i].params['item'] = item;
        });
        this.$store.commit('show_context_menu',{e:e,items:this.linkContextmenuItems})
      },
      widgetEnter:function () {
        this.widgetOverIdx = this.widgetData.posY;
        this.columnOverIdx = this.posX;
      },
      widgetLeave:function () {
        this.widgetOverIdx = null;
        this.columnOverIdx = null;
      },
      widgetMenu:function () {

      },
      widgetMenuDelete:function (widgetData) {
        this.$store.commit("menu_widget_delete_click", widgetData);
      }
    },
    props:[
      'widgetData','posX'
    ],
  }
</script>

<style>
  .widget .card__title{ padding-top: 6px; padding-bottom: 3px;padding-right: 3px;}
  .widget .card__text{padding-top: 6px;padding-bottom: 6px;}
  .widget .btn--small{width: 19px;height: 19px;margin-top: -3px;}
  .widget .material-icons{margin-top: -1px;}
  .widget .material-icons:hover{color: black;}
  .widget .tooltip--right .material-icons:hover{cursor: pointer;}
  .widget_menu_list .list__tile{height: 26px;font-size: 14px;padding: 0 10px;}
  .widget .link{cursor: pointer;color: #3d3d3d;}
  .widget .link:hover{text-decoration: underline;}
  .sortmode {cursor: move;}
  .sortmode .ad{cursor: not-allowed}
</style>
