<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span>卡片名称</span>
        <el-dropdown style="float: right; padding: 3px 0">
        <span class="el-dropdown-link">
           操作<i class="el-icon-arrow-down el-icon--right"></i>
        </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item><i class="el-icon-edit"></i> 改名</el-dropdown-item>
            <el-dropdown-item><i class="el-icon-sort"></i> 排序</el-dropdown-item>
            <el-dropdown-item><i class="el-icon-document"></i> 复制</el-dropdown-item>
            <el-dropdown-item><i class="el-icon-setting"></i> 设置</el-dropdown-item>
            <el-dropdown-item divided><i class="el-icon-edit-outline"></i> 编辑</el-dropdown-item>
            <el-dropdown-item><i class="el-icon-circle-close-outline"></i> 删除</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
      <draggable v-model="list">
        <div v-for="element in list" :key="element.id">
          {{element.title}}{{element.name}}
        </div>
      </draggable>
    </el-card>
  </div>
</template>

<script>
  import draggable from 'vuedraggable'
  import Sortable from 'sortablejs'
    export default {
      name: "bookmark",
      components: {
        draggable, Sortable
      },
      data: () => ({
        list: [
          {title: '一往无前', name: '阿法士大夫', description: 'adsfsadf'},
          {title: '二三四五', name: '就法国红酒', description: 'adsfsadf'},
          {title: '三阳开泰', name: '34而他也让他345', description: 'adsfsadf'},
          {title: '四海八荒', name: '在V型你离开家', description: 'adsfsadf'}
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

<style scoped>

</style>
