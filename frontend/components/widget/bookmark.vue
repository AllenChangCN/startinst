<template>
  <div>

        <v-card>
          <v-card-title primary-title>
            <div>
              <div class="headline">{{widget_data.title}}</div>
              <span class="grey--text">1,000 miles of wonder</span>
            </div>
          </v-card-title>
          <v-card-actions>
            <v-btn flat>Share</v-btn>
            <v-btn flat color="purple">Explore</v-btn>
            <v-spacer></v-spacer>
            <v-icon>keyboard_arrow_up</v-icon>
          </v-card-actions>
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
        'widget_data'
      ]
    }
</script>

<style scoped>

</style>
