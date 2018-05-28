<template>
  <div>
    <page_display/>
  </div>
</template>
<script>
  import page_display from "../../components/page/show_page"
  import axios from 'axios'
  export default {
    data: () => ({

    }),
    mounted(){
      this.$store.commit('set_layout_title','StartInst.')
    },
    components: {
      page_display
    },
    watch: {

    }
  }
</script>
<style>

</style>
