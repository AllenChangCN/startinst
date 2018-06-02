import Vue from 'vue'
import moment from 'moment'

Vue.filter('timeFormat', function (val) {
  if (val) {
    return moment.unix(val/1000).fromNow();
  }
});
