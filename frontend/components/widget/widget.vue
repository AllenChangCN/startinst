<template>
  <div>
    <div v-if="data.type === 'bookmark'">
      <v-card>
        <v-card-title primary-title>
          <div>
            <div class="headline">{{data.title}}</div>
            <span class="grey--text">1,000 miles of wonder</span>
          </div>
        </v-card-title>
        <v-card-actions>
          <v-btn flat>Share</v-btn>
          <v-btn flat color="purple">Explore</v-btn>
          <v-spacer/>
          <v-icon>keyboard_arrow_up</v-icon>
        </v-card-actions>
      </v-card>
    </div>
    <div v-if="data.type === 'note'">
      <v-card>
        <v-card-title primary-title>
          <div>
            <div class="headline">{{data.title}}</div>
            <span class="grey--text">asdfasdf</span>
          </div>
        </v-card-title>
        <v-card-actions>
          <v-btn flat>Share</v-btn>
          <v-btn flat color="purple">Explore</v-btn>
          <v-spacer/>
          <v-icon>keyboard_arrow_up</v-icon>
        </v-card-actions>
      </v-card>
    </div>

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

<style scoped>

</style>
