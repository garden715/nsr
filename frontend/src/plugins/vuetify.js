import Vue from "vue";
import Vuetify from "vuetify/lib";
import '@fortawesome/fontawesome-free/css/all.css'
import '@mdi/font/css/materialdesignicons.css' // Ensure you are using css-loader


Vue.use(Vuetify);

const opts = {
  icons: {
    // iconfont: ["mdi"], // 'mdi' || 'mdiSvg' || 'md' || 'fa' || 'fa4' || 'faSvg'
  },
};

export default new Vuetify(opts);
