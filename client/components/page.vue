<template>
  <div>
    <draggable v-model="widgetsData">

      <div v-for="element in widgetsData" :key="element.id">
        <bookmark/>
      </div>
    </draggable>
  </div>
</template>

<script>
  import bookmark from "./widget/bookmark"

  export default {
    name: "page",
    components: {
      bookmark
    },
    data: () => ({
      widgetsData: [
        {id: 1, name: 'test1'},
        {id: 2, name: 'test2'}
      ]
    }),
    }
</script>

<style scoped>

</style>
