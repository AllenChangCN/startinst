<template>
  <v-layout row justify-center>
    <v-dialog
      v-model="$store.state.layout.dialog.page_edit.visible"
      origin="left top"
      max-width="500px"
    >
      <v-card>
        <v-card-title>
          <span class="headline">{{$store.state.layout.dialog.page_edit.title}}</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex lg12>
                <v-text-field label="页面名称" required/>
              </v-flex>
              <v-flex lg12>
                <v-select
                  :items="['0-17', '18-29', '30-54', '54+']"
                  label="设置标签（最多3个）"
                  required
                />
              </v-flex>
              <v-flex lg12>
                <v-text-field
                  label="页面描述"
                  multi-line/>
              </v-flex>
              <v-flex lg12>
                <v-checkbox
                  :label="(pageForm.isPublic===true?'公开':'私有')+'页面'"
                  v-model="pageForm.isPublic"
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
    data: () => ({
      dialog: false,
      pageForm:{
        isPublic: true
      }
    })
  }
</script>

<style scoped>

</style>
