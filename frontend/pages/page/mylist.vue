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
          <v-btn color="success" small>
            参与编辑&nbsp;
            <v-icon dark small>edit</v-icon>
          </v-btn>
          <v-btn color="info" small>
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
        :headers="table.headers"
        :items="table.desserts"
        item-key="id"
        :must-sort="false"
        hide-actions
        :loading="loading"
        :pagination.sync="pagination"
        no-data-text="暂无数据"
      >
        <!--表格字段解析-->
        <template slot="items" slot-scope="props">
          <tr>
            <td>{{ props.item.title }}</td>
            <td>
              <v-chip :key="tag.id" v-for="tag in props.item.tagList">{{tag.name}}</v-chip>
            </td>
            <td>{{ props.item.description }}</td>
            <td>{{ props.item.view }} / {{ props.item.comment }} / {{ props.item.favorite }}</td>
            <td>{{ props.item.createdAt | timeFormat }}</td>
            <td class="justify-center layout px-0">
              <v-btn flat outline icon color="blue">
                <v-icon color="blue" small>edit</v-icon>
              </v-btn>
              <v-btn flat outline icon color="indigo">
                <v-icon color="indigo" small>delete</v-icon>
              </v-btn>
            </td>
          </tr>
        </template>
        <v-alert slot="no-results" :value="true" color="error" icon="warning">
          Your search for "{{ search }}" found no results.
        </v-alert>
      </v-data-table>
      <v-card-actions>
          <v-spacer/>
          <v-pagination circle v-model="pagination.page" :length="pagination.pages"/>
      </v-card-actions>
    </v-card>

  </v-container>
</template>

<script>
    export default {
      name: "extension",
      data () {
        return {
          table:{headers:[],desserts:[],totalDesserts:null},
          search: '',
          loading:false,
          pagination: {
            page:0,
            pages:0,   //页面总数
          },
        }
      },
      watch: {
        "pagination.page": {
          handler (val,oldVal) {
            console.log(val,oldVal);
            this.fetchMyList(this.pagination.page)
              .then(data => {
                this.table.desserts = data.list;
                this.table.totalDesserts = data.total;
                this.pagination.totalItems = data.total;
                this.pagination.pages = parseInt(data.pages);
                this.loading = false;
              })
          },
        }
      },
      mounted(){
        this.pagination.page = 1;
        this.$store.commit('set_layout_title','页面管理');
        this.table.headers = [
          { text: '标题', value: 'title' },
          { text: '标签', value: 'tagList' },
          { text: '页面描述', value: 'description' },
          { text: '浏览/留言/收藏', value: 'view' },
          { text: '创建于', value: 'createdAt' },
          { text: '操作', value: 'actions' }
        ]
      },
      methods:{
        // 获取page列表
        async fetchMyList(page) {
          this.loading = true;
          let mylist = await this.$axios.$get('/page/mylist/for-user/999999999999999999?page='+page+'&pageSize=5');
          return mylist.data;
        },
      }
    }
</script>

<style scoped>

</style>
