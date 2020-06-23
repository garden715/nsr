<template>
  <v-dialog v-model="dialog" width="500">
    <template v-slot:activator="{ on, attrs }">
      <v-btn class="mx-2" color="" v-bind="attrs" v-on="on">
        제조사
      </v-btn>
    </template>

    <v-card>
      <v-card-title class="headline grey lighten-2" primary-title>
        <span>제조사 관리</span>
        <v-spacer></v-spacer>
        <v-dialog v-model="newVendorDialog" max-width="300px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on"
              >새로운 제조사</v-btn
            >
          </template>
          <v-card>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col>
                    <v-text-field
                      v-model="editedItem.name"
                      label="Name"
                    ></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">닫기</v-btn>
              <v-btn color="blue darken-1" text @click="save(editedItem)"
                >저장</v-btn
              >
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-card-title>

      <v-data-table
        :headers="headers"
        :items="vendors"
        :items-per-page="5"
        class="elevation-1"
      >
        <template v-slot:item.id="{ item }">
          <v-icon small class="mr-2" @click="editItem(item)">
            fas fa-edit
          </v-icon>
          <v-icon small @click="deleteItem(item)">
            fas fa-trash
          </v-icon>
        </template>
      </v-data-table>
      <v-divider></v-divider>

      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn color="primary" text @click="dialog = false">
          닫기
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
import axios from "axios";

export default {
  name: "ControlVendor",
  data: () => ({
    dialog: false,
    newVendorDialog: false,
    headers: [
      { text: "이름", value: "name" },
      { text: "Action", value: "id" },
    ],
    vendors: [],
    editedIndex: -1,
    editedItem: {
      id: 0,
      name: "",
      createdDate: "",
      modifiedDate: "",
    },
    defaultItem: {
      id: 0,
      name: "",
      createdDate: "",
      modifiedDate: "",
    },
  }),
  methods: {
    close() {
      this.newVendorDialog = false;
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem);
        this.editedIndex = -1;
      });
    },
    save(item) {
      if (this.editedIndex > -1) {
        const baseURI = "/api/vendor";
        axios.put(`${baseURI}`, item).then(() => {
          Object.assign(this.vendors[this.editedIndex], item);
          this.close();
        });
      } else {
        const baseURI = "/api/vendor";
        axios.post(`${baseURI}`, item).then(() => {
          this.vendors.push(item);
          this.close();
        });
      }
    },
    editItem(item) {
      this.editedIndex = this.vendors.indexOf(item);
      this.editedItem = Object.assign({}, item);
      this.newVendorDialog = true;
    },
    deleteItem(item) {
      if (!confirm("삭제하시겠습니까?")) {
        return;
      }

      const index = this.vendors.indexOf(item);
      const baseURI = "/api/vendor";
      axios.delete(`${baseURI}/${item.id}`).then(() => {
        this.vendors.splice(index, 1);
      });
    },
  },
  mounted: function() {
    const baseURI = "/api/vendor";
    axios.get(`${baseURI}`).then((result) => {
      this.vendors = result.data;
    });
  },
};
</script>
