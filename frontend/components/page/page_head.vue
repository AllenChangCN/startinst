<template>
    <v-expansion-panel
      id="page_head"
    >
      <v-expansion-panel-content
        hide-actions
        >
        <div slot="header" id="title">
          <div style="display: flex;">
            <div style="flex:5">
              <b><v-icon small>title</v-icon> / {{getPropFromPageInfo('title')}}</b>
              <span v-if="!$store.state.page.current.sort_mode"
                    style="font-size: 11px;"
                    class="grey--text" >&nbsp; | &nbsp;查看更多</span>
            </div>
            <div style="flex: 5;text-align: right;">
              <v-btn
                title="按下ESC键退出"
                small
                v-if="$store.state.page.current.sort_mode"
                color="primary"
                id="exit_sortmode"
                depressed
                @click.stop="exit_sortmode"
              >
                <v-icon small color="white">close</v-icon>关闭排序模式
              </v-btn>
              <!--HomePage切换-->
              <div v-if="homepage">
                <v-tooltip bottom v-if="!$store.state.page.current.sort_mode">
                  <v-icon slot="activator" small @click.stop="settingsClick()">arrow_back</v-icon>
                  <span>键盘"←"键</span>
                </v-tooltip>
                <v-tooltip bottom v-if="!$store.state.page.current.sort_mode" v-for="item in [
                  {name:'网的导航', id:1,checked:true},
                  {name:'指令下', id:2,checked:false}
                ]" :key="item.id">
                  <v-icon slot="activator" small @click.stop="settingsClick()" v-if="item.checked">radio_button_checked</v-icon>
                  <v-icon slot="activator" small @click.stop="settingsClick()" v-else>radio_button_unchecked</v-icon>
                  <span>{{item.name}}</span>
                </v-tooltip>
                <v-tooltip bottom v-if="!$store.state.page.current.sort_mode">
                  <v-icon slot="activator" small @click.stop="settingsClick()">arrow_forward</v-icon>
                  <span>键盘"→"键</span>
                </v-tooltip>
              </div>
            </div>
            <div style="width: 125px;text-align: right" v-if="!$store.state.page.current.sort_mode">
              <v-tooltip bottom>
                <v-icon slot="activator" size="20px" @click.stop="$store.commit('toggle_page_sortmode')">sort</v-icon>
                <span>面板排序</span>
              </v-tooltip>
              <v-tooltip bottom>
                <v-icon slot="activator" small @click.stop="settingsClick()">settings</v-icon>
                <span>页面设置</span>
              </v-tooltip>
              <v-tooltip bottom>
                <v-icon slot="activator" small @click.stop="settingsClick()">favorite</v-icon>
                <span>收藏页面</span>
              </v-tooltip>
              <!--私有、公有按钮-->
              <v-tooltip bottom>
                <v-icon
                  v-if="getPropFromPageInfo('isOpen')==='true'||getPropFromPageInfo('isOpen')===true"
                        slot="activator" small @click.stop="switch_page_protect()">lock_open</v-icon>
                <v-icon v-else slot="activator" small @click.stop="switch_page_protect()">lock</v-icon>
                <span v-if="getPropFromPageInfo('isOpen')==='true'||getPropFromPageInfo('isOpen')===true">公开</span>
                <span v-else>私有</span>
              </v-tooltip>
            </div>
          </div>
        </div>
        <v-card>
          <v-card-text class="grey lighten-3" v-if="!$store.state.page.current.sort_mode">
            {{getPropFromPageInfo('description')}}
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
</template>

<script>
    export default {
      name: "page_head",
      mounted(){
        this.addEvent();
      },
      props:[
        'homepage'
      ],
      methods:{
        // 从store里获取页面数据
        getPropFromPageInfo(prop){
          if(this.$store.state.page.current.page_info == null){
            return '';
          }else{
            return this.$store.state.page.current.page_info[prop];
          }
        },
        settingsClick:function () {

        },
        switch_page_protect:function () {    // 切换页面，当前页面是否允许其他人访问，并收藏


        },
        exit_sortmode:function () {
          this.$store.commit('show_global_snackbar',{
            text:"按下\"Esc\"退出排序模式",
            show:true,
            success: null,
            timeout: 2000
          });
          this.$store.commit('toggle_page_sortmode')
        },
        addEvent:function(){
          var that = this;
          window.addEventListener('keyup', function(event) {
            // If down arrow was pressed...
            if (event.keyCode === 27&& that.$store.state.page.current.sort_mode) {
              that.exit_sortmode();
            }
            if(event.keyCode===39){
              that.$store.commit('show_global_snackbar',{
                text:"按下\"→\"键到下一页",
                show:true,
                success: null,
                timeout: 2000
              });
            }
            if(event.keyCode===37){
              that.$store.commit('show_global_snackbar',{
                text:"按下\"←\"键到上一页",
                show:true,
                success: null,
                timeout: 2000
              });
              that.$store.commit('show_global_snackbar',{
                text:"已经是第一页",
                show:true,
                success: null,
                timeout: 2000
              });
            }
          });
        },
        destroyed(){
          window.removeEventListener('keyup');
        }
      }
    }
</script>

<style>
  #page_head .expansion-panel__header{padding: 6px 16px;}
  #page_head .material-icons{margin: 0 3px;}
  #page_head .material-icons:hover{color: #000;}
  #page_head #exit_sortmode{padding: 0;height: 20px;margin: 0;}
  #page_head .btn__content{}
</style>
