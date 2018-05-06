<template>
  <div>

        <v-card>
          <v-card-title primary-title>
            <div>
              <div class="headline">Top western road trips</div>
              <span class="grey--text">1,000 miles of wonder</span>
            </div>
          </v-card-title>
          <v-card-actions>
            <v-btn flat>Share</v-btn>
            <v-btn flat color="purple">Explore</v-btn>
            <v-spacer></v-spacer>
            <v-btn icon @click.native="show = !show">
              <v-icon>keyboard_arrow_up</v-icon>
            </v-btn>
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
        list: [
          {title: '一往无前', name: '阿法士大夫', description: 'adsfsadf'},
          {title: '二三四五', name: '就法国红酒', description: 'adsfsadf'},
          {title: '三阳开泰', name: '34而他也让他345', description: 'adsfsadf'},
          {title: '四海八荒', name: '在V型你离开家', description: 'adsfsadf'}
        ],
        activeNames: null
      }),
      methods: {

        handleChange() {
          console.log('changed');
        },
        inputChanged(value) {
          this.activeNames = value;
        },
        getComponentData() {
          return {
            on: {
              change: this.handleChange,
              input: this.inputChanged
            },
            props: {
              value: this.activeNames
            }
          };
        }
      }
    }
</script>

<style scoped>

</style>
