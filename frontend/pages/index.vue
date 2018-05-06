<template>
  <div class="text-xs-center">
    asdfasdf
    <page_speeddial/>
  </div>

</template>
<script>
  import page_speeddial from "../components/page_speeddial"
  export default {
    data: () => ({

    }),
    mounted(){
      this.$store.commit('set_layout_title','StartInst.')
    },
    components: {
      page_speeddial
    },
    watch: {

    }
  }
</script>
<style>

</style>
