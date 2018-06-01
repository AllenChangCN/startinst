<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <!--通过用户画像和人工智能推荐-->
    <v-breadcrumbs divider="/">
      <v-breadcrumbs-item
        v-for="item in [{text:'首页',disabled:false},{text:'页面管理',disabled:false}]"
        :key="item.text"
        :disabled="item.disabled"
      >
        {{ item.text }}
      </v-breadcrumbs-item>
    </v-breadcrumbs>
    <v-data-table
      :headers="mylist.headers"
      :items="mylist.desserts"
      item-key="id"
      no-data-text="暂无数据"
    >
      <template slot="items" slot-scope="props">
        <tr>
          <td>{{ props.item.title }}</td>
          <td>
            <v-chip :key="tag.id" outline color="primary" v-for="tag in props.item.tagList">{{tag.name}}</v-chip>
          </td>
          <td>{{ props.item.description }}</td>
          <td>{{ props.item.favorite }}</td>
          <td>{{ props.item.createdAt }}</td>
        </tr>
      </template>
    </v-data-table>
  </v-container>
</template>

<script>
    export default {
      name: "extension",
      data () {
        return {
          mylist:{headers:[],desserts:[]},
        }
      },
      mounted(){
        this.$store.commit('set_layout_title','页面管理')
        this.fetchMyList();
        this.mylist.headers = [
          { text: '页面标题', value: 'title' },
          { text: '标签', value: 'tagList' },
          { text: '页面描述', value: 'description' },
          { text: '收藏量', value: 'favorite' },
          { text: '创建时间', value: 'createdAt' }
        ]
      },
      methods:{
        async fetchMyList() {
          let mylist = await this.$axios.$get('/page/mylist/for-user/999999999999999999');
          this.mylist.desserts = mylist.data;
        }
      }
    }
</script>

<style scoped>

</style>
