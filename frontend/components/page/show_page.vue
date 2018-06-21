<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <!--排序模式-->
    <v-layout row wrap v-if="$store.state.page.current.sort_mode" @keyup.27="$store.commit('toggle_page_sortmode')">
      <v-flex lg12 xs12 md12>
        <page_head/>
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
                   @change="widgetMoved"
                   style="min-height: 16px;"
                   @end="drag=false">
          <div v-for="widget in widget_column.widgetGroup" :key="widget.id" style="margin-bottom: 13px;">
            <widget :widgetData="widget" :posX="widget_column.posX" :widgetId="widget.id"/>
          </div>
        </draggable>
      </v-flex>
    </v-layout>

    <!--正常展示模式-->
    <v-layout wrap v-if="!$store.state.page.current.sort_mode">
      <v-flex lg12 xs12 md12>
        <page_head/>
      </v-flex>
      <!--遍历列-->
      <v-flex lg3 xs6 md3 v-for="widget_column in widgets" :key="widget_column.posX"
              @mouseenter="columnEnter(widget_column.posX)" @mouseleave="columnLeave()"
      >
        <!--遍历Widget-->
        <div v-for="widget in widget_column.widgetGroup" :key="widget.id" style="margin-bottom: 13px;">
          <widget :widgetData="widget" :posX="widget_column.posX" :widgetId="widget.id"/>
        </div>
        <!--鼠标划过时显示添加Widget按钮-->
        <div v-if="columnOverIdx===widget_column.posX" style="text-align: center;">
          <!--在当前列添加新的Widget-->
          <v-btn flat icon @click="createWidget(widget_column.posX)"><v-icon size="44px" class="grey--text lighten-4">add</v-icon></v-btn>
        </div>
      </v-flex>
    </v-layout>
    <context_menu style="display: none;"/>
    <widget_add/>

    <!--Widget 删除确认框-->
    <v-dialog v-model="$store.state.page.current.widget_delete_dialog" max-width="290">
      <v-card>
        <v-card-title class="headline">确认要删除面板？</v-card-title>
        <v-card-text>面板删除后不可恢复。</v-card-text>
        <v-card-actions>
          <v-spacer/>
          <v-btn color="gray lighten-1" flat="flat" @click="$store.commit('toggle_widget_delete_dialog',{action:'close'})">关闭</v-btn>
          <v-btn color="green darken-1" flat="flat" @click="$store.commit('toggle_widget_delete_dialog',{action:'confirm'})">确认</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
  import widget from "../widget/widget_layout"
  import page_head from "./page_head"
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
  import context_menu from '../page/context_menu'
  import widget_add from "../widget/widget_add"
  export default {
    name: "show_page",
    mounted(){
      // 获取初始化数据
      this.fetchPageData();
    },
    components: {
      widget,page_head,draggable, Sortable,context_menu, widget_add
    },
    methods: {
      columnEnter:function (posX) {   // 显示添加Widget的按钮
        this.columnOverIdx = posX;
      },
      columnLeave:function () {   // 隐藏添加Widget的按钮
        this.columnOverIdx = null;
      },
      widgetMoved: function (evt){ // 排序Widget
        if(evt.moved !== undefined){
          console.log('moved.');
          this.posMovedMessage.widgetId = evt.moved.element.id;
          this.posMovedMessage.posX = evt.moved.element.posX;
          this.posMovedMessage.posY = (parseInt(evt.moved.element.posY) + (evt.moved.newIndex - evt.moved.oldIndex)).toString();
          console.log(this.posMovedMessage)
        }else if(evt.added !== undefined){
          console.log('added.');
          console.log(evt.added);
        }else if(evt.removed !== undefined){
          console.log('removed.');
          console.log(evt.removed);
        }
      },
      fetchPageData() {
        this.$store.commit('load_current_page',{page_id:this.page_id});
      },
      createWidget(posX){   // 添加一个Widget
        this.$store.state.page.current.widget_edit_form.posX = posX;
        this.$store.state.page.current.widget_edit_form.pageId = this.$store.state.page.current.pageInfo.id;
        this.$store.commit('toggle_widget_edit_dialog',{action:'show'});
      }
    },
    watch:{
      "$store.state.page.current.pageInfo.widgetList":function(){
        let widgetData = [];
        let rawWidgetList = this.$store.state.page.current.pageInfo.widgetList;
        Object.keys(rawWidgetList).forEach(function(key){
          if(!widgetData[rawWidgetList[key].posX]) widgetData[rawWidgetList[key].posX] = {};
          if(!widgetData[rawWidgetList[key].posX]['widgetGroup']) widgetData[rawWidgetList[key].posX]['widgetGroup'] = [];
          if(!widgetData[rawWidgetList[key].posX]['posX']) widgetData[rawWidgetList[key].posX]['posX'] = parseInt(rawWidgetList[key].posX);
          widgetData[rawWidgetList[key].posX]['widgetGroup'].push(rawWidgetList[key]);
        });
        this.widgets =  widgetData;
        console.info("page info updated.")
      }
    },
    data: () => ({
      deleteDialog: true,
      columnOverIdx: null,
      posMovedMessage:{}, // {widgetId:null,posX:null,posY:null},
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
