<template>
  <v-container
    grid-list-lg
    align-start
    fluid
  >
    <!--通过用户画像和人工智能推荐-->
    <v-card>
      <v-card-title>
        <div>
          <v-btn color="success">
            参与编辑&nbsp;
            <v-icon dark small>add</v-icon>
          </v-btn>
          <v-btn color="info" disabled>
            我的收藏&nbsp;
            <v-icon dark small>favorite</v-icon>
          </v-btn>
        </div>
        <v-spacer/>
        <v-text-field
          v-model="search"
          append-icon="search"
          label="页面搜索"
          single-line
          hide-details
        />
      </v-card-title>
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
          <td>{{ props.item.view }} / {{ props.item.comment }} / {{ props.item.favorite }}</td>
          <td>{{ props.item.createdAt | timeFormat }}</td>
        </tr>
      </template>
    </v-data-table>
    </v-card>
  </v-container>
</template>

<script>
    export default {
      name: "extension",
      data () {
        return {
          mylist:{headers:[],desserts:[]},
          search: ''
        }
      },
      mounted(){
        this.$store.commit('set_layout_title','页面管理')
        this.fetchMyList();
        this.mylist.headers = [
          { text: '标题', value: 'title' },
          { text: '标签', value: 'tagList' },
          { text: '页面描述', value: 'description' },
          { text: '浏览/留言/收藏', value: 'view' },
          { text: '创建于', value: 'createdAt' }
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
