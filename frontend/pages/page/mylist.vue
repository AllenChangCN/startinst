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
        :headers="headers"
        :items="desserts"
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
          <v-pagination v-model="pagination.page" :length="pages"/>
      </v-card-actions>
    </v-card>

  </v-container>
</template>

<script>
    export default {
      name: "extension",
      data () {
        return {
          headers:[],desserts:[],totalDesserts:null,
          search: '',
          loading:false,
          pagination: {},
        }
      },
      computed: {
        pages () {
          if (this.pagination.rowsPerPage == null ||
            this.pagination.totalItems == null
          ) return 0;
          return Math.ceil(this.pagination.totalItems / this.pagination.rowsPerPage)
        }
      },
      watch: {
        pagination: {
          handler () {
            this.fetchMyList()
              .then(data => {
                this.desserts = data;
                this.totalDesserts = 20;
              })
          },
          deep: true
        }
      },
      mounted(){
        this.$store.commit('set_layout_title','页面管理')
        this.fetchMyList()
          .then(data => {
            console.log(data);
            this.desserts = data;
            this.totalDesserts = 20;
          });
        this.headers = [
          { text: '标题', value: 'title' },
          { text: '标签', value: 'tagList' },
          { text: '页面描述', value: 'description' },
          { text: '浏览/留言/收藏', value: 'view' },
          { text: '创建于', value: 'createdAt' },
          { text: '操作', value: 'actions' }
        ]
      },
      methods:{
        async fetchMyList() {
          this.loading = true;
          let mylist = await this.$axios.$get('/page/mylist/for-user/999999999999999999');
          return mylist.data;
        },
      }
    }
</script>

<style scoped>

</style>
