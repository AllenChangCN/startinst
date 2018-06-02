import Vue from 'vue'
import moment from 'moment'

Vue.filter('timeFormat', function (val) {
  if (val) {
    let sec = val/1000;
    let now = moment();
    let then = moment.unix(sec);
    let diff = now.diff(then,"hours");
    if(diff<=120){
      return then.fromNow();
    }else{
      return then.format('YYYY-MM-DD HH:mm');
    }
  }
});
