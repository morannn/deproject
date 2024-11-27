<template>

  <el-tabs :value="activeName" @tab-click="handleClick" class="mainDiv" >
    <el-tab-pane name="qm_flow">
      <ManagerMainFlowAll :department="departments" :departmentnum="departmentNum"> </ManagerMainFlowAll>
    </el-tab-pane>

    <el-tab-pane name="qm-flow" class="board">


    </el-tab-pane>
  </el-tabs>
</template>
<script>

import ManagerMainFlow1 from "./manager-main-flow1.vue";
import ManagerMainFlowAll from "./manager-main-flow-all.vue";
import reques from "@/utils/respone";
export default {
  props: ['activeName'],
  name: "manager-main",
  components: {
    ManagerMainFlow1,
    ManagerMainFlowAll,
  },
  data() {
    return {
      departments:[],
      departmentNum:0
      // activeName: 'flow'
    };
  },
  methods: {
    handleClick(tab, event) {

    },
    async getalldepartments() {
      // 调取获取的值
      const data = await reques.get("/matter/alldepartments");
      // 判断是否能拿到数据,拿到数据后使用map来遍历数组获得他的id号

      if (data.data.result == true) {
        this.departments=data.data.data
        console.log(this.departments)
        this.departmentNum=data.data.data.length
      }
    },

  },
  beforeMount(){
    this.getalldepartments();
  },
}
</script>


<style scoped>
.mainDiv>>>.el-tabs__header {
  margin: 0px;
}
.board{
  display: table-row;
}

.mainDiv>>>.el-tabs__nav-scroll {
  overflow: hidden;
  display: none;
  height: 0px;
}
</style>
