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
              <v-flex lg12>
                <v-text-field label="页面名称" required/>
              </v-flex>
              <v-flex lg12>
                <v-select
                  :loading="loading"
                  :items="items"
                  :rules="[() => (select.length > 0 && select.length <= 3) || '请选择1-3个标签']"
                  :search-input.sync="search"
                  v-model="select"
                  label="设置标签"
                  autocomplete
                  multiple
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
              <v-flex lg12>
                <v-text-field
                  label="页面描述"
                  multi-line/>
              </v-flex>
              <v-flex lg12>
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
          <v-btn color="blue darken-1" flat @click.native="dialog = false">保存</v-btn>
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
      search: null,
      select: [],
      pageForm:{
        isOpen: true
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
      createNewTag(){  // 添加一个新的Tag并选中
        console.log(this.search)
      }
    }
  }
</script>

<style scoped>

</style>
