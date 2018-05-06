<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <v-layout wrap>
      <v-flex lg3 v-for="widget_column in widgets" :key="widget_column.column_idx">
        <div v-for="widget in widget_column.data" :key="widget.idx">
          <widget :data="widget"/>
        </div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  import widget from "../widget/widget"

  export default {
    name: "page",
    components: {
      widget
    },
    data: () => ({
      widgets: [
          {
            column_idx:1,
            name:'',
            data:[
              {idx: 1, title: '岁吧点点', type:'bookmark', content:"asdf"},
              {idx: 2, title: 'test2',type:'bookmark',content:"asdf"},
            ]},
          {
            column_idx:2,
            name:'',
            data: [
              {idx: 1, title: 'test1',type:'bookmark',},
              {idx: 2, title: 'test2',type:'note',},
              {idx: 3, title: 'test2',type:'bookmark',}
            ]},
          {
            column_idx:3,
            name:'',
            data: [
              {idx: 1, title: 'test1',type:'bookmark',},
              {idx: 2, title: 'test2',type:'bookmark',},
              {idx: 3, title: 'test2',type:'bookmark',},
              {idx: 4, title: 'test2',type:'bookmark',}
          ]},
          {
          column_idx:4,
          name:'',
          data: [
            {idx: 1, title: 'test1',type:'bookmark',},
            {idx: 2, title: 'test2',type:'bookmark',},
            {idx: 3, title: 'test2',type:'bookmark',},
            {idx: 4, title: 'test2',type:'bookmark',},
            {idx: 5, title: 'test2',type:'bookmark',},
          ]},

      ]
    })
  }
</script>

<style scoped>

</style>
