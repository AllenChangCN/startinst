<template>
  <v-container>
    <v-layout>
      <v-flex xs12 sm6 v-for="widget_column in widgets" :key="widget_column.column_idx">
        <div v-for="widget in widget_column.data" :key="widget.id">
          <bookmark/>
        </div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
  import bookmark from "../widget/bookmark"

  export default {
    name: "page",
    components: {
      bookmark
    },
    data: () => ({
      widgets: [
          {
            column_idx:1,
            name:'',
            data:[
              {id: 1, name: 'test1'},
              {id: 2, name: 'test2'},
            ]},
          {
            column_idx:2,
            name:'',
            data: [
              {id: 1, name: 'test1'},
              {id: 2, name: 'test2'},
              {id: 2, name: 'test2'}
            ]},
          {
            column_idx:3,
            name:'',
            data: [
              {id: 1, name: 'test1'},
              {id: 2, name: 'test2'},
              {id: 3, name: 'test2'},
              {id: 4, name: 'test2'}
          ]},

      ]
    })
  }
</script>

<style scoped>

</style>
