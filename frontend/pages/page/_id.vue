<template>
    <div>
      <show_page :page_id="page_id"/>
    </div>
</template>

<script>
    import show_page from "../../components/page/show_page"
    export default {
      name: "page-id",
      validate ({ params }) {
        // Must be a number
        return /^\d+$/.test(params.id)
      },
      data(){
        return {
          page_id :this.$router.history.current.params.id
        }
      },
      mounted(){
        this.$store.commit('set_layout_title','页面');
        console.log(this.page_id)
      },
      methods:{

      },
      components: {
        show_page
      },

    }
</script>

<style scoped>

</style>
