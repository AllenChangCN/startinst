<template>
  <div class="text-xs-center">
    <page_display/>
    <page_speeddial/>
  </div>

</template>
<script>
  import page_speeddial from "../components/page_speeddial"
  import page_display from "../components/page/show_page"
  export default {
    data: () => ({

    }),
    mounted(){
      this.$store.commit('set_layout_title','StartInst.')
    },
    components: {
      page_speeddial,page_display
    },
    watch: {

    }
  }
</script>
<style>

</style>
