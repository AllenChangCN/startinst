<template>
    <div></div>
</template>

<script>
    export default {
      name: "discuss",
      mounted(){
        window.open('https://discuss.flarum.org/','_blank')
        history.back()
      }
    }
</script>

<style scoped>

</style>
