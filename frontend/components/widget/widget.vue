<template>


  <!--Widget排序模式-->
  <div class="widget sortmode" v-if="$store.state.page.sort_mode">
    <v-card v-if="data.type==='ad'" class="ad">
      <v-card-title><v-icon size="19px">monetization_on</v-icon> &nbsp;&nbsp;<b>赞助商</b></v-card-title>
    </v-card>
    <v-card v-else>
      <v-card-title>
        <div style="width: 100%;">
          <div style="display: flex;">
            <div style="flex: 100%;">
              <v-icon v-if="data.type==='note'" size="19px">event_note</v-icon>
              <v-icon v-if="data.type==='bookmark'" size="19px">bookmark_border</v-icon>
              &nbsp;<b>{{data.title}}</b>
            </div>
          </div>
        </div>
      </v-card-title>
    </v-card>
  </div>


  <!--正常模式-->
  <div class="widget" v-else>
    <!--广告Widget-->
    <v-card v-if="data.type==='ad'">
      <v-card-title><v-icon size="19px">monetization_on</v-icon> &nbsp;&nbsp;<b>赞助商</b></v-card-title>
    </v-card>
    <v-card v-else @mouseenter="widgetEnter()" @mouseleave="widgetLeave()">
      <!--Widget标题-->
      <v-card-title>
        <div style="width: 100%;">
          <div style="display: flex;">
            <div style="flex: 100%;">
              <v-icon v-if="data.type==='note'" size="19px">event_note</v-icon>
              <v-icon v-if="data.type==='bookmark'" size="19px">bookmark_border</v-icon>
              &nbsp;<b>{{data.title}}</b>
            </div>
            <div style="flex: 1;min-width: 80px;text-align: right;margin-right: 6px;">
              <v-tooltip right>
                <v-icon slot="activator" size="18px" v-if="data.type==='note'&&column_idx+'_'+data.idx===column_over_idx+'_'+widget_over_idx">
                 edit
                </v-icon>
                <span v-if="data.type==='note'">编辑</span>
                <v-icon slot="activator" size="22px" v-if="data.type==='bookmark'&&column_idx+'_'+data.idx===column_over_idx+'_'+widget_over_idx">
                  add
                </v-icon>
                <span v-if="data.type==='bookmark'">添加</span>
              </v-tooltip>
              &nbsp;
              <v-menu
                offset-y
                open-on-hover
                lazy
                :open-delay="200"
              >
                <!--<v-btn slot="activator" color="primary" dark>Dropdown</v-btn>-->
                <v-icon slot="activator" @click="widgetMenu()" size="22px">menu</v-icon>
                <v-list class="widget_menu_list">
                  <v-list-tile @click="widgetMenu()">
                    <v-list-tile-title><v-icon size="small">delete</v-icon> 删除</v-list-tile-title>
                  </v-list-tile>
                  <v-list-tile @click="widgetMenu()">
                    <v-list-tile-title><v-icon size="small">edit</v-icon> 编辑</v-list-tile-title>
                  </v-list-tile>
                  <v-list-tile @click="widgetMenu()">
                    <v-list-tile-title><v-icon size="small">input</v-icon> 复制到</v-list-tile-title>
                  </v-list-tile>
                </v-list>
              </v-menu>
            </div>
          </div>
          <span class="grey--text" v-if="data.description">{{data.description}}</span>
        </div>
      </v-card-title>
      <v-card-text v-if="data.type==='bookmark'"> <!-- 书签 -->
        <div v-if="data.content">
          <draggable v-model="data.content" :options="{group:'people'}" @start="drag=true" @end="drag=false">
            <div v-for="item in data.content" :key="item.idx">
              <a :href="item.url" target="_blank">{{ item.title }}</a>
            </div>
          </draggable>
        </div>
        <div v-else>
          暂无书签
        </div>
      </v-card-text>
      <v-card-text v-if="data.type === 'note'">
        <div v-if="data.content">
          <span v-html="data.content"></span>
        </div>
        <div v-else>
          笔记为空
        </div>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
  export default {
    name: "bookmark",
    components: {
      draggable, Sortable
    },
    data: () => ({
      widget_over_idx: null,
      column_over_idx: null
    }),
    methods: {
      widgetEnter:function () {
        this.widget_over_idx = this.data.idx;
        this.column_over_idx = this.column_idx;
      },
      widgetLeave:function () {
        this.widget_over_idx = null;
        this.column_over_idx = null;
      },
      widgetMenu:function () {

      }

    },
    props:[
      'data','column_idx'
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
  .widget_menu_list .list__tile{height: 23px;font-size: 14px;padding: 0 8px;}
  .sortmode {cursor: move;}
  .sortmode .ad{cursor: not-allowed}
</style>
