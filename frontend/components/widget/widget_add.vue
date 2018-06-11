<template>
  <v-layout row justify-center>
    <v-dialog v-model="$store.state.page.current.widget_edit_dialog" persistent max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">添加面板</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12 sm12 md12>
                <v-text-field label="面板名称" required v-model="$store.state.page.current.widget_edit_form.title"/>
              </v-flex>
              <v-flex xs12 sm12>
                <v-select
                  :items="[{text:'书签',value:'BOOKMARK'}, {text:'备忘录',value:'NOTE'}]"
                  label="面板类型"
                  required
                  v-model="$store.state.page.current.widget_edit_form.widgetType"
                  item-value="value"
                  item-text="text"
                />
              </v-flex>
              <v-flex xs12 sm12 md12>
                <v-text-field label="描述" multi-line v-model="$store.state.page.current.widget_edit_form.description" required/>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer/>
          <v-btn color="gray lighten-1" flat @click.native="$store.commit('toggle_widget_edit_dialog',{action:'close'})">关闭</v-btn>
          <v-btn color="primary" @click.native="$store.commit('toggle_widget_edit_dialog',{action:'save'})">保存</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>

<script>
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
  import widget_head from './widget_layout_head'
  export default {
    name: "widget_add",
    components: {

    },
    mounted(){
      // console.log(this.widgetData);
    },
    data: () => ({
      dialog: true
    }),
    watch:{

    },
    methods: {

    },
    props:[

    ],
  }
</script>

<style>

</style>
