<template>
  <v-app>
    <!-- <v-app-bar app color="primary" dark>
      <div class="d-flex align-center">
        <span class="title mr-5">Network Supply Registration</span>
      </div>
      <v-spacer></v-spacer>
    </v-app-bar> -->

    <v-main>
      <Nsr />
    </v-main>
  </v-app>
</template>

<script>
import Nsr from "./components/Nsr";

export default {
  name: "App",

  components: {
    Nsr,
  },

  data: () => ({
    //
  }),
  created () {
    document.title = "NSR :: Network Supply Registration";
}
};
</script>
