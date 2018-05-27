<template>
  <div>
    <page_display/>
  </div>
</template>
<script>
  import page_display from "../components/page/show_page"
  import axios from 'axios'
  export default {
    async asyncData ({ params }) {
      let { data } = await axios.get("http://localhost:8080/api/page/999999999999999999/info");
      console.log(data)
      return { title: data.title }
    },
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
