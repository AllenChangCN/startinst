<template>
  <v-content>
    <v-container>
      <v-layout style="margin-top: 20%">
        <v-flex lg4/>
        <v-flex lg4>
            <v-card>
              <v-card-title primary-title class="text-sm-center">
                <h2 style="margin: 13px 0;margin-bottom: 20px;">登录 StartInst.</h2>
              </v-card-title>
              <v-form>
                <v-text-field prepend-icon="person" solo name="Username" label="用户名"/>
                <v-text-field prepend-icon="lock" solo name="Password" label="密码" type="password"/>
                <v-btn to="/" color="orange darken-2"  block large><span style="color: white;font-weight: 600;">登录</span></v-btn>
                <v-divider/>
                <v-layout row>
                  <v-flex sm6>
                    <v-btn to="/signup" color="orange darken-2" block large flat>注册</v-btn>
                  </v-flex>
                  <v-flex sm6>
                    <v-btn color="orange darken-2" large block flat>找回密码</v-btn>
                  </v-flex>
                </v-layout>

              </v-form>
            </v-card>
        </v-flex>
        <v-flex lg4/>
      </v-layout>
    </v-container>
  </v-content>

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
