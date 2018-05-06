<template>
  <div class="widget">
    <!--广告Widget-->
    <v-card v-if="data.type==='ad'">
      <v-card-title><v-icon size="22px">monetization_on</v-icon> &nbsp;&nbsp;<b>赞助商</b></v-card-title>
    </v-card>
    <!--书签Widget+笔记Widget-->
    <v-card v-else>
      <v-card-title>
        <div style="width: 100%;">
          <div style="display: flex;">
            <div style="flex: 100%;">
              <v-icon v-if="data.type==='note'" size="22px">event_note</v-icon>
              <v-icon v-if="data.type==='bookmark'" size="22px">bookmark_border</v-icon>
              &nbsp;<b>{{data.title}}</b>
            </div>
            <div style="flex: 1;min-width: 80px;align-content: flex-end;">
              <v-btn icon flat small> <v-icon>add</v-icon></v-btn>
              <v-btn icon flat small> <v-icon>menu</v-icon></v-btn>
            </div>
          </div>
          <span class="grey--text" v-if="data.description">{{data.description}}</span>
        </div>
      </v-card-title>
      <v-card-text v-if="data.type==='bookmark'">
        <div v-if="data.content">
          <div v-for="item in data.content" :key="item.idx">
            <a :href="item.url" target="_blank">{{ item.title }}</a>
          </div>
        </div>
        <div v-else>
          暂无书签
        </div>
      </v-card-text>
      <v-card-text v-if="data.type === 'note'">
        <div v-if="data.content">
          <span v-html="data.content"></span>
        </div>
        <div v-else>
          笔记为空
        </div>
      </v-card-text>
    </v-card>
  </div>
</template>

<script>
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
    export default {
      name: "bookmark",
      components: {
        draggable, Sortable
      },
      data: () => ({
      }),
      methods: {


      },
      props:[
        'data'
      ]
    }
</script>

<style>
  .widget .card__title{ padding-top: 6px; padding-bottom: 3px;padding-right: 3px;}
  .widget .card__text{padding-top: 6px;padding-bottom: 6px;}
  .widget .btn--small{width: 22px;height: 22px;margin-top: -3px;}
</style>
