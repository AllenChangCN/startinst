<template>
  <v-layout row justify-center>
    <v-dialog
      v-model="$store.state.global.dialog.page_edit.visible"
      origin="left top"
      max-width="500px"
    >
      <v-card>
        <v-card-title>
          <span class="headline">{{$store.state.global.dialog.page_edit.title}}</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex lg12 md12>
                <v-text-field label="页面名称" required v-model="pageForm.name"/>
              </v-flex>
              <v-flex lg12 md12>
                <v-select
                  :loading="loading"
                  :items="items"
                  :rules="[() => (pageForm.tagList.length > 0 && pageForm.tagList.length <= 3) || '请选择1-3个标签']"
                  :search-input.sync="search"
                  v-model="pageForm.tagList"
                  label="设置标签"
                  autocomplete
                  multiple
                  single-line
                  no-data-text="按下回车，创建并选中新标签"
                  cache-items
                  hide-selected
                  deletable-chips
                  chips
                  item-text="name"
                  item-value="id"
                  required
                  @keyup.enter="createNewTag"
                />
              </v-flex>
              <v-flex lg12 md12>
                <v-text-field
                  label="页面描述"
                  v-model="pageForm.description"
                  multi-line/>
              </v-flex>
              <v-flex lg12 md12>
                <v-checkbox
                  :label="(pageForm.isOpen===true?'公开':'私有')+'页面'"
                  v-model="pageForm.isOpen"
                />
              </v-flex>
            </v-layout>
          </v-container>
          <small>* 必填项</small>
        </v-card-text>
        <v-card-actions>
          <v-spacer/>
          <v-btn color="blue darken-1" flat @click="$store.commit('toggle_editpage_dialog',{
            visible:false
          })">关闭</v-btn>
          <v-btn color="blue darken-1" flat @click.native="createNewPage">保存</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>

<script>
  export default {
    name: 'edit',
    mounted(){
      this.querySelections('');
    },
    data: () => ({
      dialog: false,
      loading: false,
      items: [],
      search: '',
      pageForm:{
        name:"",
        isOpen: true,
        tagList: [],
        description:""
      }
    }),
    watch: {
      search (val) {
        // val && this.querySelections(val)
        this.querySelections(val)
      }
    },
    methods:{
      async querySelections (v) {
        this.loading = true;
        let tagList = await (this.$axios.get('/tag/search?keyword='+v));
        this.items = tagList.data.data;
        this.loading = false
      },
      // 添加一个新的Tag并选中
      async createNewTag() {
        if(this.search != null && this.search.length >= 3){
          let newTag = await (this.$axios.post('/tag/create', {name: this.search}));
          this.search = '';
          console.log(newTag.data.data);
          this.items.push(newTag.data.data);
          this.pageForm.tagList.push(newTag.data.data);
          this.$store.commit('show_global_snackbar',{
            text:"创建新标签",
            show:true,
            success: null,
            timeout: 2000
          });
        }else{
          console.log("create new tag failed.")
        }
      },
      // 创建新页面
      async createNewPage(){
        console.log(this.pageForm);
        this.$store.commit('show_global_snackbar',{
          text:"创建新页面",
          show:true,
          success: null,
          timeout: 2000
        });
      }
    }
  }
</script>

<style scoped>

</style>
