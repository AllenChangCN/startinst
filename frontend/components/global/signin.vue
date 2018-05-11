<template>
  <v-layout row justify-center>
    <v-dialog v-model="$store.state.global.dialog.signin.visible" max-width="500px">
      <v-card>
        <v-card-title>
          <span class="headline">登录 StartInst.</span>
        </v-card-title>
        <v-card-text>
          <v-container grid-list-md>
            <v-layout wrap>
              <v-flex xs12>
                <v-text-field solo label="用户名" prepend-icon="account_box"/>
              </v-flex>
              <v-flex xs12>
                <v-text-field solo label="密码" type="password" prepend-icon="security"/>
              </v-flex>
            </v-layout>
          </v-container>
        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="blue darken-1" flat @click.native="dialog = false">注册账号</v-btn>
          <v-btn color="blue darken-1" flat @click.native="dialog = false">忘记密码</v-btn>
          <v-btn color="blue darken-1" @click.native="dialog = false">
            <span style="color: white;font-weight: 600;">登录</span>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-layout>
</template>
<script>
  export default {
    layout:'empty',
    data: () => ({

    }),
    components:{
    },
    props: {
      source: String
    }
  }
</script>
