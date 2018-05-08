<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <v-layout wrap>
      <v-flex lg12>
        <page_head/>
      </v-flex>
      <!--遍历列-->
      <v-flex lg3 v-for="widget_column in widgets" :key="widget_column.column_idx">
        <!--遍历Widget-->
        <div v-for="widget in widget_column.data" :key="widget.idx" style="margin-bottom: 13px;">
          <widget :data="widget" :column_idx="widget_column.column_idx"/>
        </div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  import widget from "../widget/widget"
  import page_head from "./page_head"

  export default {
    name: "page",
    components: {
      widget,page_head
    },
    data: () => ({
      widgets: [
          {
            column_idx:1,
            name:'',
            data:[
              {idx: 1, title: 'test1',type:'ad',description:'先保存在终端，然后再统一上传，减少并发',},
              {idx: 2, title: '岁吧点点', description:'',type:'bookmark', content:[
                {idx:1,icon:'',title:'百度搜索引擎',url:'https://www.baidu.com'},
                ]},
              {idx: 2, title: 'test2',description:'描述2',type:'bookmark',content:[
                {idx:1, icon:'',title: '腾讯网',url:'http://www.qq.com'},
                {idx:2,icon:'',title: '腾讯网2',url:'http://www.qq.com'},
                {idx:3,icon:'',title: '腾讯网3',url:'http://www.qq.com'},
                ]},
            ]},
          {
            column_idx:2,
            name:'',
            data: [
              {idx: 2, title: 'test2',type:'note',description:'描述',content:'<h2>一去二三里</h2>烟村四五家，亭台六七座<br/>支持MarkDown'},
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
