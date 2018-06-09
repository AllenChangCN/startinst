<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <!--排序模式-->
    <v-layout row wrap v-if="$store.state.page.current.sort_mode" @keyup.27="$store.commit('toggle_page_sortmode')">
      <v-flex lg12 xs12 md12>
        <page_heAD/>
      </v-flex>
      <!--遍历列-->
      <v-flex lg3 xs6 md3
              v-for="widget_column in widgets"
              :key="widget_column.posX"
      >
        <!--遍历Widget-->
        <draggable v-model="widgets"
                   :list="widget_column.widgetGroup"
                   :options="{group:'widgets', animation: 100}"
                   @start="drag=true"
                   @change="log"
                   style="min-height: 16px;"
                   @end="drag=false">
          <div v-for="widget in widget_column.widgetGroup" :key="widget.posY" style="margin-bottom: 13px;">
            <widget :widgetData="widget" :posX="widget_column.posX"/>
          </div>
        </draggable>
      </v-flex>
    </v-layout>

    <!--正常展示模式-->
    <v-layout wrap v-if="!$store.state.page.current.sort_mode">
      <v-flex lg12 xs12 md12>
        <page_heAD/>
      </v-flex>
      <!--遍历列-->
      <v-flex lg3 xs6 md3 v-for="widget_column in widgets" :key="widget_column.posX"
              @mouseenter="columnEnter(widget_column.posX)"
              @mouseleave="columnLeave()"
      >
        <!--遍历Widget-->
        <div v-for="widget in widget_column.widgetGroup" :key="widget.posY" style="margin-bottom: 13px;">
          <widget :widgetData="widget" :posX="widget_column.posX"/>
        </div>
        <div v-if="columnOverIdx===widget_column.posX"
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
  import page_heAD from "./page_heAD"
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
  import context_menu from '../page/context_menu'
  export default {
    name: "show_page",
    mounted(){
      // 获取初始化数据
      this.fetchPageData();
      // console.log(this.widgets)
    },
    components: {
      widget,page_heAD,draggable, Sortable,context_menu
    },
    methods: {
      columnEnter:function (posX) {   // 显示添加Widget的按钮
        this.columnOverIdx = posX;
      },
      columnLeave:function () {   // 隐藏添加Widget的按钮
        this.columnOverIdx = null;
      },
      log: function (evt){
        console.log(evt)
      },
      async fetchPageData() {
        let pageInfo = (await this.$axios.$get('/page/'+this.page_id+'/info')).data;
        this.$store.commit('set_page_info',pageInfo);
      },
    },
    watch:{
      "$store.state.page.current.pageInfo":function(){
        let widgetData = {};
        let rawWidgetList = this.$store.state.page.current.pageInfo.widgetList;
        rawWidgetList.forEach(function(elem,i){
          if(!widgetData[elem.posX]) widgetData[elem.posX] = {};
          if(!widgetData[elem.posX]['widgetGroup']) widgetData[elem.posX]['widgetGroup'] = [];
          if(!widgetData[elem.posX]['posX']) widgetData[elem.posX]['posX'] = parseInt(elem.posX);
          widgetData[elem.posX]['widgetGroup'].push(elem);
        });
        this.widgets =  widgetData;
        console.info("page info updated.")
      }
    },
    data: () => ({
      columnOverIdx: null,
      widgets:[{posX:1,widgetGroup:[]}],
      // widgets: [
      //     {
      //       posX:1,
      //       widgetGroup:[
      //         {posY: 1, title: '赞助商',widgetType:'AD', description:'先保存在终端，然后再统一上传，减少并发'},
      //         {posY: 2, title: '岁吧点点',widgetType:'BOOKMARK', description:''},
      //         {posY: 3, title: 'test2',widgetType:'BOOKMARK',description:'描述2'},
      //       ]
      //     }
      // ]
    }),
    props:[
      'page_id','homepage','is_owner'
    ],
  }
</script>

<style scoped>

</style>
