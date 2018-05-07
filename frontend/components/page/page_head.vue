<template>
    <v-expansion-panel
      id="page_head"
    >
      <v-expansion-panel-content
        :hide-actions="false"
        >
        <div slot="header"
             id="title"
        ><b><v-icon>title</v-icon> / 王的导航</b></div>
        <v-card>
          <v-card-text class="grey lighten-3">
            困难像弹簧，你强他就弱，你弱他就强
          </v-card-text>
        </v-card>
      </v-expansion-panel-content>
    </v-expansion-panel>
</template>

<script>
    export default {
        name: "page_head"
    }
</script>

<style>
  #page_head .expansion-panel__header{padding: 6px 16px;}
</style>
