import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate";
import state from "@/store/states";
import actions from "@/store/actions";
import mutations from "@/store/mutations";
import getters from "@/store/getters";

Vue.use(Vuex)

export default new Vuex.Store({
  plugins:[
    createPersistedState({
      paths: ['isAuthenticated', 'resMember.username', 'questionComments' , 'orderInfo']
    })
  ],
  state,
  actions,
  mutations,
  getters,
})
