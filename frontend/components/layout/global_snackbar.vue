<template>
  <v-snackbar
    :timeout="$store.state.layout.global_snackbar.timeout"
    v-model="$store.state.layout.global_snackbar.show"
    @click="$store.commit('show_global_snackbar',{
        show:false
    })">
    <span>{{ $store.state.layout.global_snackbar.text }}</span>
    <span v-if="$store.state.layout.global_snackbar.success">
      <v-icon color="white">check</v-icon>
    </span>
    <span v-else>
       <v-icon color="white">clear</v-icon>
    </span>
  </v-snackbar>
</template>

<script>
    export default {
        name: "global_snackbar",
    }
</script>

<style scoped>

</style>
