<template>
  <v-card-title>
    <div style="width: 100%;">
      <div style="display: flex;">
        <div style="flex: 100%;">
          <v-icon v-if="widgetData.widgetType==='NOTE'" size="19px">event_note</v-icon>
          <v-icon v-if="widgetData.widgetType==='BOOKMARK'" size="19px">bookmark_border</v-icon>
          &nbsp;<click_to_edit_text @text-updated="headTitleUpdated" :text="widgetData.title" :disabled="false"/>
        </div>
        <!--Widget菜单-->
        <div style="flex: 1;min-width: 80px;text-align: right;margin-right: 6px;">
          <v-tooltip right>
            <v-icon slot="activator" size="18px" v-if="widgetData.widgetType==='NOTE' && $store.state.widget.current.id===widgetData.id">
              edit
            </v-icon>
            <span v-if="widgetData.widgetType==='NOTE'">编辑</span>
            <v-icon slot="activator" size="22px" v-if="widgetData.widgetType==='BOOKMARK' && $store.state.widget.current.id===widgetData.id">
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

</template>

<script>
  import click_to_edit_text from '../global/click_to_edit_text'
  import axios from "../../plugins/axios";
  export default {
    name: "widget_layout_head",
    components: {
      click_to_edit_text
    },
    created(){

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

    },
    methods: {
      // 更新Widget title
      headTitleUpdated(val){
        delete this.widgetData['@id'];
        this.$store.state.page.current.pageInfo.widgetList[this.widgetData.id].title = val;
        axios.post('/widgets/'+this.widgetData.id+'/edit',{
          id: this.widgetData.id,
          title:this.widgetData.title,
          description: this.widgetData.description
        }).then(function (response) {
          console.log(response);
        })
      },
      // Widget右键菜单
      openContextMenu:function (e,item) {
        let that = this;
        this.linkContextmenuItems.forEach(function (elem,i) {
          that.linkContextmenuItems[i].params['item'] = item;
        });
        this.$store.commit('show_context_menu',{e:e,items:this.linkContextmenuItems})
      },
      widgetMenu:function(){

      },
      widgetMenuDelete:function (widgetData) {
        this.$store.commit("set_widget_current_data",widgetData);
        this.$store.commit("toggle_widget_delete_dialog",{action:'show'});
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
