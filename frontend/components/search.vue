<template>

  <div style="margin-top: 15px;">
    <el-input placeholder="请输入关键字"
              v-model="keywords"
              v-on:keyup.native.13="search(keywords, searchURL)"
              class="input-with-select">
      <el-select v-model="searchURL"
                 slot="prepend"
                 placeholder="请选择"
                 style="width: 100px;">
        <el-option
          v-for="option in searchOptions"
          :key="option.value"
          :label="option.label"
          :value="option.value"/>
      </el-select>
      <el-button slot="append" icon="el-icon-search" @click="search(keywords, searchURL)">搜索</el-button>
    </el-input>
  </div>
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
  .el-select .el-input {
    width: 130px;
  }

  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }
</style>
