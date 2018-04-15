<template>

  <div style="margin-top: 15px;">
    <el-input placeholder="请输入关键字"
              v-model="keywords"
              @keyup.enter="search(keywords)"
              class="input-with-select">
      <el-select v-model="select" slot="prepend" placeholder="请选择" style="width: 100px;">
        <el-option
          v-for="option in searchOptions"
          :key="option.value"
          :label="option.label"
          :value="option.value"/>
      </el-select>
      <el-button slot="append" icon="el-icon-search" @click="search(keywords)">搜索</el-button>
    </el-input>
  </div>
</template>

<script>
    export default {
      name: "search",
      mounted() {
        // this.select = 'Baidu'
        console.log(this.select)
      },
      data: function () {
        return {
          select: 'Baidu',
          keywords: '',
          searchOptions: [
            {value: 'https://www.baidu.com/s?wd=', label: 'Baidu'},
            {value: 'https://www.google.com/search?q=', label: 'Google'}
          ]
        }
      },
      methods: {
        search: (keywords) => {
          console.log(this.select);
          console.log(keywords);
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
