<template>
<div>
  <div class="container">

    <div class="row" v-for="states in status_List">
      <div class="column">
        {{states}}
    </div>
  </div>
</div>
</div>


</template>

<script>
import reques from '@/utils/respone'
//拖拽插件引入
import Sortable from 'sortablejs'
import draggable from 'vuedraggable'
// 兄弟传值
import ManagerMainCard from './manager-main-card1.vue'
import ManagerAddTask from './manager.add.task.vue'
import eventBus from '@/utils/eventBus.js'
export default {
  props: ['department'],
  name: "manager-main-flow",
  components: {
    ManagerMainCard,
    ManagerAddTask,
    draggable,
  },
  data() {
    return {
      status_List: ["nob","ing","end"],
      matternob:[],
      mattering:[],
      matterend:[]
    }
  },
  mounted() {
    console.log("ee")
    this.findmatterBystatusanddepart();
  },
  methods:{
    async findmatterBystatusanddepart(){
      const data1 = await reques.get("/matter/flow/status/"+this.department+'/'+"nob");
      // 判断是否能拿到数据,拿到数据后使用map来遍历数组获得他的id号

      if (data1.data.result == true) {
        this.matternob=data1.data.data
        console.log(this.matternob)
      }
      const data2 = await reques.get("/matter/flow/status/"+this.department+'/'+"ing");
      // 判断是否能拿到数据,拿到数据后使用map来遍历数组获得他的id号
      if (data2.data.result == true) {
        this.mattering=data2.data.data

      }
      const data3 = await reques.get("/matter/flow/status/"+this.department+'/'+"end");
      // 判断是否能拿到数据,拿到数据后使用map来遍历数组获得他的id号
      if (data3.data.result == true) {
        this.matterend=data3.data.data

      }
    }
  }

}
</script>


<style lang="less" scoped>
.container {
  display: flex;
  flex-wrap: wrap;
}

.row {
  display: flex;
}

.column {
  flex: 1; /* 每一列的大小相同 */
  padding: 10px;
  box-sizing: border-box;
  border: 1px solid black; /* 添加边框 */
}
</style>
