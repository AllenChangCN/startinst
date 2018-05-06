<template>
  <div></div>
</template>

<script>
    export default {
      name: "logout",
      mounted(){
        history.back();
        this.$store.commit('show_global_snackbar',{
          text:"退出登录",
          show:true,
          success: true,
          timeout: 1200
        });
      }
    }
</script>

<style scoped>

</style>
