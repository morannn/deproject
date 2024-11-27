<template>
  <div class="container">
    <div class="row">
      <div 
        v-if="departmentnum > 1" 
        class="department-box" 
        v-for="(value, index) in department" 
        :key="value.id"
      >
        <div class="department-name">
          部门名：{{ value }}(列名为事件状态)
        </div>
        <ManagerMainFlow1 ref="flow1" :alldepartment="value" :departmentnum="departmentnum" />
      </div>
      <div v-if="departmentnum == 1" class="department-box">
        <div class="department-name">
          部门名：{{ department }}(列名为事件状态)
        </div>
        <ManagerMainFlow1 @refresh-flow1="refreshManagerMainFlow1" :department="department" :departmentnum="departmentnum" />
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
.department_name {
  margin-bottom: 10px; /* 添加一些底部边距 */
  font-weight: bold; /* 加粗字体 */
  /* 其他样式根据需要添加 */
}
.column {
  flex-grow: 1; /* 每一列的大小相同 */
  padding: 10px;
  box-sizing: border-box;
}
.container {
  display: flex;
  flex-direction: column; /* 每一行一个框 */
  gap: 16px; /* 每个框之间的间距 */
}

.department-box {
  border: 1px solid #ddd; /* 边框颜色 */
  border-radius: 8px; /* 圆角 */
  padding: 16px; /* 内边距 */
  background-color: #f9f9f9; /* 背景色 */
}

.department-name {
  font-weight: bold;
  font-size: 16px;
  margin-bottom: 12px; /* 部门名称和组件之间的间距 */
}

</style>