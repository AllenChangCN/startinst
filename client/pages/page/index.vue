<template>
  <div>
    <md-card>
      <md-card-header>
        <md-card-header-text>
          <div class="md-title">Card Head</div>
          <div class="md-subhead">Subtitle here</div>
        </md-card-header-text>
        <md-menu md-size="big" md-direction="bottom-end">
          <md-button class="md-icon-button" md-menu-trigger>
            <md-icon>more_vert</md-icon>
          </md-button>

          <md-menu-content>
            <md-menu-item @click="doACall">
              <span>Call</span>
              <md-icon>phone</md-icon>
            </md-menu-item>

            <md-menu-item @click="sendMessage">
              <span>Send a message</span>
              <md-icon>message</md-icon>
            </md-menu-item>
          </md-menu-content>
        </md-menu>
      </md-card-header>
      <md-card-content>
        Lorem ipsum dolor sit amet, consectetur adipisicing elit. Optio itaque ea, nostrum odio. Dolores, sed accusantium quasi non, voluptas eius illo quas, saepe voluptate pariatur in deleniti minus sint. Excepturi.
      </md-card-content>
      <md-card-actions md-alignment="left">
        Card foot
      </md-card-actions>
    </md-card>
  </div>
</template>

<script>
  export default {
    name: 'Layouts',
    methods: {
      sendMessage () {
        window.alert('Send a message...')
      },
      doACall () {
        window.alert('Calling someone...')
      }
    }
  }
</script>

<style lang="scss" scoped>
  .md-card {
    width: 320px;
    margin: 4px;
    display: inline-block;
    vertical-align: top;
  }

  .md-card-example {
  .md-subhead {
  .md-icon {
    $size: 16px;

    width: $size;
    min-width: $size;
    height: $size;
    font-size: $size !important;
  }

  span {
    vertical-align: middle;
  }
  }

  .card-reservation {
    margin-top: 8px;
    display: flex;
    align-items: center;
    justify-content: space-between;

  .md-icon {
    margin: 8px;
  }
  }

  .md-button-group {
    display: flex;

  .md-button {
    min-width: 60px;
    border-radius: 2px;
  }
  }
  }
</style>
