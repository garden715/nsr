<template>
  <v-container>
    <v-row>
      <v-col>
        <control-model/>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <template>
          <v-data-table
            :headers="headers"
            :items="models"
            :items-per-page="5"
            class="elevation-1"
          ></v-data-table>
        </template>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from "axios";
import ControlModel from "./ControlModel"

export default {
  name: "Nsr",
  components: {
    ControlModel
  },

  data: () => ({
    headers: [
      {
        text: "분류",
        align: "start",
        sortable: false,
        value: "kind_name",
      },
      { text: "제조사", value: "vendor_name" },
      { text: "모델", value: "name" },
      { text: "IDC", value: "location_name" },
      { text: "갯수", value: "count" },
    ],
    models: [],
  }),
  mounted: function() {
    const baseURI = "/api/model";
    axios.get(`${baseURI}`).then((result) => {
      console.log(result.data)
      this.models = result.data;
    });
  },
};
</script>
