<template>
  <v-content>
    <v-text-field
      v-model="keywords"
      :box="true"
      :row-height="24"
      :solo="true"
    ></v-text-field>
    <v-btn icon="el-icon-search" @click="search(keywords, searchURL)">搜索</v-btn>
  </v-content>


</template>

<script>
    export default {
      name: "search",

      data: () => {
        return {
          searchURL: 'https://www.google.com/search?q=',
          keywords: '',
          searchOptions: [
            {value: 'https://www.baidu.com/s?wd=', label: 'Baidu'},
            {value: 'https://www.google.com/search?q=', label: 'Google'},
            {value: 'https://cn.bing.com/search?q=', label: 'Bing'}
          ]
        }
      },
      mounted() {
        // this.select = 'Baidu'
        console.log(this.searchURL)
      },
      methods: {
        search: (keywords, searchURL) => {
          window.open(searchURL + keywords, '_blank')
        }
      }

    }
</script>

<style scoped>
  .el-select .v-input {
    width: 130px;
  }

  .input-with-select .v-input-group__prepend {
    background-color: #fff;
  }
</style>
