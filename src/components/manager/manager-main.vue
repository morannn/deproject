<template>

  <el-tabs :value="activeName" @tab-click="handleClick" class="mainDiv" >
    <el-tab-pane name="qm_flow">
      <ManagerMainFlowAll :department="departments" :departmentnum="departmentNum" > </ManagerMainFlowAll>
    </el-tab-pane>

    <el-tab-pane name="qm-flow" class="board">
      <ManagerMainFlowAll :department="department" :departmentnum="departmentNum1"> </ManagerMainFlowAll>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
import axios from 'axios';
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
      department:'',
      username:'',
      departmentNum:0,
      departmentNum1:1
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
        this.departmentNum=data.data.data.length
      }
    },
    getdepartment() {
      
      axios.get("/user/getMatterByUsername/"+this.username).then(res=>{
        
        if (res.data.result == true) {
           this.department=res.data.data
           this.$store.commit('setMyData1', { key: this.department });
           localStorage.setItem('myDataKey1', this.department);
        }
      })
      // 判断是否能拿到数据,拿到数据后使用map来遍历数组获得他的id号
      
    },

  },
  mounted(){
    
    let savedValue = localStorage.getItem('myDataKey');
    this.username=savedValue
    this.getdepartment();

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
