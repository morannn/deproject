<template>
  <div class="board">
    <!-- tabSign拖拽类名 -->
    <div class="board example1">
      <div>{{department}}</div>
      <div class="board-left " v-for="(value,id) in boxmaxList">
        <el-card shadow="hover">
          <div class="center">
            <h1>{{ value }}</h1>
            <h1>{{id}}</h1>
          </div>
        </el-card>
        <div ref="elem" class="eme">
          <draggable v-model="value.taskList" :scroll=true group="taskList" animation="100" @start="onStart"
                     @end="onUpdate">
            <ManagerMainCard :title="flow" @remove="remove(i, $event)" v-for="flow in contentList[id].data" :key="flow.id">
            </ManagerMainCard>
          </draggable>
          <!-- 卡片组件 -->
        </div>
        <div>
          <ManagerAddTask @respones="add_task"></ManagerAddTask>
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
import enevrBus from '@/utils/eventBus.js'
import ManagerMainCard from './manager-main-card1.vue'
import ManagerAddTask from './manager.add.task.vue'

import eventBus from '@/utils/eventBus.js'
import axios from "axios";
export default {
  props:["department"],
  name: "manager-main-flow",
  components: {
    ManagerMainCard,
    ManagerAddTask,
    draggable,

  },
  data() {
    return {
      // 接收的
      boxmaxList: ["nob","ing","end"],
      contentList:[],//存放了所有card数据
      flag: false,
      List_one: [],
      index: 1
    }
  },

  methods: {
    async fetchContentList() {

      let arr = []
      for (let index = 0; index < this.boxmaxList.length; index++) {
        const res = await axios.get("/matter/flow/status/" + this.department + "/" + this.boxmaxList[index])
        this.$set(this.contentList, index, res.data);
      }
      // console.log(this.contentList[0].result)
    },

  },
  created() {
    this.fetchContentList();
  },
  mounted() {
  },

}
</script>

<style lang="less" scoped>
.board {
  width: 100%;
  display: flex;
  cursor: pointer;
  user-select: none;

  /deep/.el-card {
    .el-card__body {
      min-width: 261px;
    }
  }

  .opo {
    height: 1000px;
    border: 1px solid;
  }

  .board-left {
    border-right: 0.0625rem solid #e7e7e7;
    flex: 1;
    height: 100%;

    .center {
      display: flex;
      justify-content: space-between;

      span {
        transition: all 0.3s;
      }

      span:hover {
        transform: rotate(180deg);
        transform: scale(1.5);
      }
    }
  }

  .qm_tom {
    margin-top: 15px;
  }


}
</style>
