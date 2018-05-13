<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <!--排序模式-->
    <v-layout wrap v-if="$store.state.page.current.sort_mode" @keyup.27="$store.commit('toggle_page_sortmode')">
      <v-flex lg12>
        <page_head/>
      </v-flex>
      <!--遍历列-->
      <v-flex lg3
              v-for="widget_column in widgets"
              :key="widget_column.column_idx"
      >
        <!--遍历Widget-->
        <draggable v-model="widgets"
                   :list="widget_column.data"
                   :options="{group:'widgets', animation: 100}"
                   @start="drag=true"
                   @change="log"
                   style="min-height: 16px;"
                   @end="drag=false">
          <div v-for="widget in widget_column.data" :key="widget.idx" style="margin-bottom: 13px;">
            <widget :data="widget" :column_idx="widget_column.column_idx"/>
          </div>
        </draggable>
      </v-flex>
    </v-layout>

    <!--正常展示模式-->
    <v-layout wrap v-if="!$store.state.page.current.sort_mode">
      <v-flex lg12>
        <page_head/>

      </v-flex>
      <!--遍历列-->
      <v-flex lg3 v-for="widget_column in widgets" :key="widget_column.column_idx"
              @mouseenter="columnEnter(widget_column.column_idx)"
              @mouseleave="columnLeave()"
      >
        <!--遍历Widget-->
        <div v-for="widget in widget_column.data" :key="widget.idx" style="margin-bottom: 13px;">
          <widget :data="widget" :column_idx="widget_column.column_idx"/>
        </div>
        <div v-if="column_over_idx===widget_column.column_idx"
             style="text-align: center;">
            <v-btn flat icon><v-icon size="44px" class="grey--text lighten-4">add</v-icon></v-btn>
        </div>
      </v-flex>

    </v-layout>
    <context_menu style="display: none;"/>
  </v-container>
</template>

<script>
  import widget from "../widget/widget"
  import page_head from "./page_head"
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
  import context_menu from '../page/context_menu'


  export default {
    name: "page",
    mounted(){
      // this.addEvent();
    },
    components: {
      widget,page_head,draggable, Sortable,context_menu
    },
    methods: {
      columnEnter:function (column_idx) {   // 显示添加Widget的按钮
        this.column_over_idx = column_idx;
      },
      columnLeave:function () {   // 隐藏添加Widget的按钮
        this.column_over_idx = null;
      },
      log: function (evt){
        console.log(evt)
      },


    },
    data: () => ({
      column_over_idx: null,
      x:0,
      y:0,
      widgets: [
          {
            column_idx:1,
            name:'',
            data:[
              {idx: 1, title: 'test1',type:'ad',description:'先保存在终端，然后再统一上传，减少并发',},
              {idx: 2, title: '岁吧点点', description:'',type:'bookmark',
                content:[
                  {idx:1,icon:'',title:'百度搜索引擎',url:'https://www.baidu.com'},
                  {idx:2,icon:'',title:'谷歌搜索引擎',url:'https://www.baidu.com'},
                ]
              },
              {idx: 3, title: 'test2',description:'描述2',type:'bookmark',
                content:[
                  {idx:1, icon:'',title: '腾讯网',url:'http://www.qq.com'},
                  {idx:2,icon:'',title: '腾讯网2',url:'http://www.qq.com'},
                  {idx:3,icon:'',title: '腾讯网3',url:'http://www.qq.com'},
                ]
              },
            ]},
          {
            column_idx:2,
            name:'',
            data: [
              {idx: 2, title: 'test2',type:'note',description:'描述',
                content:'<h2>一去二三里</h2>烟村四五家，亭台六七座<br/>支持MarkDown'
              },
              {idx: 3, title: 'test2',type:'bookmark',description:'描述',}
            ]},
          {
            column_idx:3,
            name:'',
            data: [
              {idx: 1, title: 'test1',type:'note',description:'',},
              {idx: 2, title: 'test2',type:'bookmark',description:'描述',},
              {idx: 3, title: 'test2',type:'bookmark',description:'描述',},
              {idx: 4, title: 'test2',type:'bookmark',description:'描述',}
          ]},
          {
            column_idx:4,
            name:'',
            data: [
              {idx: 1, title: 'test1',type:'bookmark',description:'描述',},
              {idx: 2, title: 'test2',type:'bookmark',description:'描述',},
              {idx: 3, title: 'test2',type:'bookmark',description:'描述',},
              {idx: 4, title: 'test2',type:'bookmark',description:'描述',},
              {idx: 5, title: 'test2',type:'bookmark',description:'描述',},
            ]},

      ]
    })
  }
</script>

<style scoped>

</style>
