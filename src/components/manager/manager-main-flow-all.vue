<template>
  <div class="container">
    <div class="row">
      
      <div v-if="departmentnum>1" class="column" v-for="(value, index) in department" :key="value.id">
        部门名：{{ value }}(列名为事件状态)
      
        <ManagerMainFlow1 ref="flow1" :alldepartment="value" :departmentnum="departmentnum"></ManagerMainFlow1>
        <!-- 确保组件ManagerMainFlow已经被导入并注册 -->
      </div>
      <div v-if="departmentnum==1" class="column">
        部门名：{{ department }}
        <ManagerMainFlow1 @refresh-flow1="refreshManagerMainFlow1" :department="department" :departmentnum="departmentnum"></ManagerMainFlow1>
        <!-- 确保组件ManagerMainFlow已经被导入并注册 -->
      </div>
    </div>
  </div>

</template>


<script>

import ManagerMainFlow1 from "./manager-main-flow1.vue";
import reques from "@/utils/respone";
export default {
  name: "manager-main-flow-all",
  components: {ManagerMainFlow1},
  props:["department","departmentnum"],
  data(){
    return {
      username:''
  }
  },

  mounted() {
    this.delayedAction();
    this.Port_calls();
  },
  methods:{
    refreshManagerMainFlow1() {
      this.$refs.flow1.refreshData();
    },
    async delayedAction() {
      // 设置延时，例如2秒后执行
      setTimeout(() => {
        // 延时执行的代码
        
      }, 500);
    },
  }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-wrap: wrap;
}

.row {
  display: flex;
}

.column {
  flex-grow: 1; /* 每一列的大小相同 */
  padding: 10px;
  box-sizing: border-box;
}

</style>