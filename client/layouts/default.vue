<template>

  <div>
    <el-container>
      <el-header>
        <div>
          <el-row :gutter="20">
            <el-col :span="4">
              <div class="grid-content bg-purple">
                <h1 style="margin-top: 20px;">pageagg.com</h1>
              </div>
            </el-col>
            <el-col :span="15">
              <div class="grid-content bg-purple">
                <search/>
              </div>
            </el-col>
            <el-col :span="5">
              <div class="grid-content bg-purple">
                <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
                  <el-submenu index="2">
                    <template slot="title"><i class="el-icon-view"></i> 探索</template>
                    <el-menu-item index="2-1">选项1</el-menu-item>
                    <el-menu-item index="2-2">选项2</el-menu-item>
                    <el-menu-item index="2-3">选项3</el-menu-item>
                  </el-submenu>
                  <el-menu-item index="3">我的</el-menu-item>
                </el-menu>
              </div>
            </el-col>
          </el-row>
        </div>
      </el-header>
      <el-main>
        <div class="line"></div>
        <div style="min-height: 680px;">
          <nuxt/>
        </div>
        <div class="line"></div>
      </el-main>
      <el-footer>
        footer
      </el-footer>
    </el-container>

  </div>
</template>
<script>
  import search from "../components/search"

  export default {
    data() {
      return {
        activeIndex: null
      }
    },
    methods: {
      handleSelect: () => {

      }
    },
    components: {
      search
    }
  }
</script>
<style>
  .input-with-select .el-input-group__prepend {
    background-color: #fff;
  }
</style>
