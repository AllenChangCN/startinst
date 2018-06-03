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
          <v-btn small color="primary" flat icon @click="refreshMylist()">
            <v-icon>refresh</v-icon>
          </v-btn>
          <v-menu
            offset-y
            open-on-hover
            :dense="true"
            light
          >
            <v-btn slot="activator" color="primary" dark small>参与编辑 <v-icon small>arrow_drop_down</v-icon></v-btn>
            <v-list>
              <v-list-tile>
                <v-list-tile-title>
                  <v-icon small>favorite</v-icon> 常用页面
                </v-list-tile-title>
              </v-list-tile>
              <v-list-tile>
                <v-list-tile-title>
                  <v-icon small>edit</v-icon> 参与编辑
                </v-list-tile-title>
              </v-list-tile>
              <v-list-tile>
                <v-list-tile-title>
                  <v-icon small>star</v-icon> 收藏页面
                </v-list-tile-title>
              </v-list-tile>
            </v-list>
          </v-menu>

        </div>
        <v-spacer/>
        <v-text-field
          v-model="search"
          append-icon="search"
          label="页面搜索"
          single-line
          hide-details
          @keyup.enter="fetchMyList()"
        />
      </v-card-title>
      <v-data-table
        :headers="table.headers"
        :items="table.desserts"
        item-key="id"
        :must-sort="true"
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
              <v-btn flat outline icon color="blue" @click="openOnNewTag(props.item.id)">
                <v-icon color="blue" small>open_in_new</v-icon>
              </v-btn>
              <v-btn flat outline icon color="blue">
                <v-icon color="blue" small>edit</v-icon>
              </v-btn>
              <v-btn flat outline icon color="indigo">
                <v-icon color="indigo" small>group</v-icon>
              </v-btn>
              <v-btn flat outline icon color="indigo">
                <v-icon color="indigo" small>favorite</v-icon>
              </v-btn>
            </td>
          </tr>
        </template>
        <!--<v-alert slot="no-results" :value="true" color="error" icon="warning">-->
          <!--Your search for "{{ search }}" found no results.-->
        <!--</v-alert>-->
      </v-data-table>
      <v-card-actions>
          <v-spacer/>
          <v-pagination circle v-model="pagination.pageNum" :length="pagination.pages"/>
      </v-card-actions>
    </v-card>

  </v-container>
</template>

<script>
    export default {
      name: "mylist",
      data () {
        return {
          table:{headers:[],desserts:[],totalDesserts:null},
          search: '',
          loading:false,
          pagination: {
            pageNum:1,
            pages:0,   //页面总数
          },
        }
      },
      watch: {
        "pagination.pageNum": {
          handler (val,oldVal) {
            this.fetchMyList();
          }
        }
      },
      mounted(){
        this.fetchMyList();
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
        openOnNewTag(page_id){
          window.open("/page/"+page_id,"_blank")
        },
        // 刷新数据
        refreshMylist(){
          this.fetchMyList();
          this.$store.commit('show_global_snackbar',{
            text:"数据已刷新",
            show:true,
            success: null,
            timeout: 2000
          });
        },
        // 获取数据
        fetchMyList(){
          this.fetchMyListFromApi()
            .then(data => {
              this.table.desserts = data.list;
              this.table.totalDesserts = data.total;
              this.pagination.totalItems = data.total;
              this.pagination.pages = parseInt(data.pages);
              this.pagination.pageNum = parseInt(data.pageNum);
              this.loading = false;
            })
        },
        // 获取数据（底层方法）
        async fetchMyListFromApi() {
          this.loading = true;
          let a = await (this.$axios.$get('/page/mylist/for-user/999999999999999999?page='+
            this.pagination.pageNum+'&pageSize=8'+
            "&search="+this.search));
          return a.data;
        },
      }
    }
</script>

<style scoped>

</style>
