<template>
    <v-expansion-panel
      id="page_head"
    >
      <v-expansion-panel-content
        :hide-actions="false"
        >
        <div slot="header" id="title">
          <div style="display: flex;">
              <div style="flex: 100%;">
                <b><v-icon>title</v-icon> / 王的导航</b>
              </div>
            <v-tooltip bottom>
              <v-icon slot="activator" small @click.stop="settingsClick()" color="blue">settings</v-icon>
              <span>页面设置</span>
            </v-tooltip>
            <v-tooltip bottom>
              <v-icon slot="activator" small @click.stop="settingsClick()" color="red">share</v-icon>
              <span>页面分享</span>
            </v-tooltip>
          </div>
        </div>
        <v-card>
          <v-card-text class="grey lighten-3">
            困难像弹簧，你强他就弱，你弱他就强。<br>
            页面描述、浏览量、收藏量信息
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
</style>
