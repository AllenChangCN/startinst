<template>
  <div>
    <!--<draggable element="el-collapse" :list="list" :component-data="getComponentData()">-->
    <!--<el-collapse-item v-for="e in list" :title="e.title" :name="e.name" :key="e.name">-->
    <!--<div>{{e.description}}</div>-->
    <!--</el-collapse-item>-->
    <!--</draggable>-->
    啊是打发斯蒂芬
  </div>
</template>

<script>
  export default {
    name: "search",
    mounted() {
    },
    data: () => ({
      list: [
        {title: '11', name: '34345', description: 'adsfsadf'},
        {title: '11', name: '34345', description: 'adsfsadf'},
        {title: '11', name: '34345', description: 'adsfsadf'},
        {title: '11', name: '34345', description: 'adsfsadf'}
      ],
      activeNames: null
    }),

    methods: {
      handleChange() {
        console.log('changed');
      },
      inputChanged(value) {
        this.activeNames = value;
      },
      getComponentData() {
        return {
          on: {
            change: this.handleChange,
            input: this.inputChanged
          },
          props: {
            value: this.activeNames
          }
        };
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>
