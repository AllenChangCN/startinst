<template>
    <v-expansion-panel
      id="page_head"
    >
      <v-expansion-panel-content
        :hide-actions="false"
        >
        <div slot="header" id="title">
          <div style="display: flex;">
            <div style="flex:1">
              <b><v-icon>title</v-icon> / 王的导航</b>
            </div>
            <div style="flex: 1;text-align: center;">
              <v-tooltip bottom>
                <v-icon slot="activator" @click.stop="settingsClick()">radio_button_checked</v-icon>
                <span>王的导航</span>
              </v-tooltip>
              <v-tooltip bottom>
                <v-icon slot="activator" @click.stop="settingsClick()">radio_button_unchecked</v-icon>
                <span>天地一体</span>
              </v-tooltip>
            </div>
            <div style="flex: 1;text-align: right;margin-right: 20px;">
              <v-tooltip bottom>
                <v-icon slot="activator" @click.stop="settingsClick()">settings</v-icon>
                <span>页面设置</span>
              </v-tooltip>
              <v-tooltip bottom>
                <v-icon slot="activator" @click.stop="settingsClick()">share</v-icon>
                <span>页面分享</span>
              </v-tooltip>
            </div>
          </div>
        </div>
        <v-card>
          <v-card-text class="grey lighten-3">
            困难像弹簧，你强他就弱，你弱他就强。<br>
            页面描述、浏览量、收藏量信息 <br>
            帮助 <br>
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
</template>

<script>
    export default {
      name: "page_head",
      methods:{
        settingsClick:function () {

        }
      }
    }
</script>

<style>
  #page_head .expansion-panel__header{padding: 6px 16px;}
  #page_head .material-icons{margin: 0 3px;}
  #page_head .material-icons:hover{color: #000;}
</style>
