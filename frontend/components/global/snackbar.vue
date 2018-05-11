<template>
  <v-snackbar
    :timeout="$store.state.global.global_snackbar.timeout"
    v-model="$store.state.global.global_snackbar.show"
    @click="$store.commit('show_global_snackbar',{
        show:false
    })"
    right
    bottom
  >
    <span>{{ $store.state.global.global_snackbar.text }}</span>
    <span v-if="$store.state.global.global_snackbar.success">
      <v-icon color="white">check</v-icon>
    </span>
    <span v-else-if="$store.state.global.global_snackbar.success===false">
       <v-icon color="white">clear</v-icon>
    </span>
    <span v-else>
       <v-icon color="white">info_outline</v-icon>
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
