<template>
  <v-dialog v-model="$store.state.global.dialog.confirm.visible" max-width="290">
      <v-card>
        <v-card-title class="headline">{{$store.state.global.dialog.confirm.title}}</v-card-title>
        <v-card-text>{{$store.state.global.dialog.confirm.content}}</v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="green darken-1" flat="flat" @click.native="cancel_click()">取消</v-btn>
          <v-btn color="green darken-1" flat="flat" @click.native="confirm_click()">确认</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
    export default {
      name: "dialog_confirm",
      data:()=>({
        btn_action: null
      }),
      mounted(){
        this.btn_action = this.$store.state.global.dialog.confirm.btn_action
      },
      methods:{
        confirm_click:function () {
          let json = JSON.parse(JSON.stringify(this.$store.state.global.dialog.confirm));
          json.visible = false;
          this.$store.commit('show_global_confirm',json);
          this.$store.commit('show_global_snackbar',{
            text:"确认操作",
            show:true,
            success: null,
            timeout: 2000
          });
        },
        cancel_click:function () {
          let json = JSON.parse(JSON.stringify(this.$store.state.global.dialog.confirm));
          json.visible = false;
          this.$store.commit('show_global_confirm',json);
          this.$store.commit('show_global_snackbar',{
            text:"取消操作",
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
