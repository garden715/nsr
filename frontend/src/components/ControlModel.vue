<template>
  <div class="text-center">
    <v-dialog v-model="dialog" width="1000">
      <template v-slot:activator="{ on, attrs }">
        <v-btn color="red lighten-2" dark v-bind="attrs" v-on="on">
          제조사
        </v-btn>
      </template>

      <v-card>
        <v-card-title class="headline grey lighten-2" primary-title>
          제조사 관리
        </v-card-title>

        <v-dialog v-model="newVendorDialog" max-width="500px">
          <template v-slot:activator="{ on, attrs }">
            <v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on"
              >New Item</v-btn
            >
          </template>
          <v-card>
            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6" md="4">
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

        <template>
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
        </template>

        <v-divider></v-divider>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" text @click="dialog = false">
            닫기
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "ControlModel",
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
    },
    defaultItem: {
      id: 0,
      name: "",
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
        Object.assign(this.vendors[this.editedIndex], item);
        this.close();
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
      console.log(result.data);
      this.vendors = result.data;
    });
  },
};
</script>
