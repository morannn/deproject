<template>
  <div class="container">
  <div class="board">
  <!-- tabSign拖拽类名 -->
  <div class="board example1">
    
    <div :class="`board-left-${value}`" v-for="(value,id) in boxmaxList">
      <el-card :class="`board-left-${value}`" shadow="hover">
        <div class="center">
          <h1>{{ value }}</h1>
        </div>
      </el-card>
      <div ref="elem" class="eme">
        <draggable :options="dragOptions" :class="`board-left-${value}`" v-model="value.taskList" :scroll=true group="taskList" animation="100" @start="onStart"
                   @end="onUpdate">
                   
          <ManagerMainCard :departmentnum="departmentnum" @refresh="refresh"  v-if="departmentnum>1" :class="`board-left-${value}`" :title="flow" @remove="remove(i, $event)" v-for="flow in contentList[id].data" :key="flow.id" :data-id="flow.id">
          </ManagerMainCard>
          
        </draggable>
        <draggable :class="`board-left-${value}`" v-model="value.taskList" :scroll=true group="taskList" animation="100" @start="onStart"
                   @end="onUpdate">
                   
          
          <ManagerMainCard :departmentnum="departmentnum" @refresh="refresh" v-if="departmentnum==1" :class="`board-left-${value}`" :title="flow" @remove="remove(i, $event)" v-for="flow in contentList1[id].data" :key="flow.id" :data-id="flow.id">
          </ManagerMainCard>
        </draggable>
        <!-- 卡片组件 -->
      </div>
      <div>
        <ManagerAddTask :departmentnum="departmentnum" @refresh="refresh" @fetchContentList1="fetchContentList1" @respones="add_task"></ManagerAddTask>
      </div>
    </div>
  </div>
</div>
</div>
</template>

<script>
import reques from '@/utils/respone'
//拖拽插件引入
import draggable from 'vuedraggable'
// 兄弟传值
import ManagerMainCard from './manager-main-card1.vue'
import ManagerAddTask from './manager.add.task.vue'

import eventBus from '@/utils/eventBus.js'
import axios from "axios";
import Vue from "vue";
export const EventBus = new Vue();
export default {
props: ["department", "departmentnum","alldepartment"],
name: "manager-main-flow",
components: {
  ManagerMainCard,
  ManagerAddTask,
  draggable,

},
data() {
  return {
    // 接收的
    boxmaxList: ["nob", "ing", "end"],
    contentList: [],//存放了所有card数据
    contentList1: [],//存放了所有card数据
    flag: false,
    List_one: [],
    index: 1,
    username: '',
    dragOptions: {
      group: 'taskList',  // 设置拖拽组
      animation: 100,  // 拖拽动画时间
      disabled: localStorage.getItem('myDataKey2')!="admin",  // 判断是否允许拖拽
    },
    savedValue: localStorage.getItem('myDataKey2')
    
    
  }
},

methods: {
  onStart(event) {
    // 记录拖拽前的卡片信息
    this.startCardInfo = {
      id: event.item.dataset.id, // 假设卡片有 dataset.id 属性
      index: event.oldIndex
    };
    // 获取拖拽起点的列名
    this.startColumnName = this.getColumnName(event.from);
  },
  onUpdate(event) {
    // 记录拖拽后的卡片信息
    this.endCardInfo = {
      index: event.newIndex
    };
    // 获取拖拽终点的列名
    this.endColumnName = this.getColumnName(event.to);  
    // 发送请求到后端更新数据库
    this.updateDatabasePosition();
  },
    
  getColumnName(container) {

    // 假设每个 board-left 容器都有一个唯一的 class 属性，例如 'board-left-nob', 'board-left-ing', 'board-left-end'
    const columnName = container.className.match(/board-left-(\w+)/)[1];
    return columnName;
  },
  refresh(){
    EventBus.$emit("refresh-data");
  },
  updateDatabasePosition() {
    // 构造请求数据
    const data = {
      startCardId: this.startCardInfo.id,
      startColumn: this.startColumnName,
      targetColumn: this.endColumnName
      // 添加其他必要的数据
    };
    const savedValue = localStorage.getItem('myDataKey2');

    
      // 发送 POST 请求到后端 API
    reques.get('/matter/updateStatus' + '/' + data.startCardId + '/' + data.targetColumn)
      .then(response => {
        this.$message({
          type: 'success',
          message: '移动成功！'
        });

        EventBus.$emit("refresh-data");

      })
      .catch(error => {
        // 处理错误
        this.$message({
          type: 'info',
          message: '移动失败！'
        });
      });
    

    
    
  },
  callFunction() {
    // 这里执行一些操作
    this.$emit('call-function', 'someData'); // 触发一个自定义事件，并传递数据
  },
  
  async fetchContentList() {

    let arr = []
    for (let index = 0; index < this.boxmaxList.length; index++) {
      const res = await axios.get("/matter/flow/status/" + this.alldepartment + "/" + this.boxmaxList[index])
      this.$set(this.contentList, index, res.data);
    }   
  
  },
  async fetchContentList1() {
    
    let arr = []
    for (let index = 0; index < this.boxmaxList.length; index++) {
      const res = await axios.get("/matter/getMatterByDepartmentAndUsername/" + this.username + '/' + this.department + "/" + this.boxmaxList[index])
      this.$set(this.contentList1, index, res.data);
    }
  },
  remove(ele, val) {
    reques({
      type: 'get',
      url: '/matter/delete/' + val
    }).then(res => {
      this.fetchContentList()
      this.fetchContentList1()
      this.refresh()
    })
  },

},
created() {
  EventBus.$on("refresh-data", () => {
  this.fetchContentList();
  this.fetchContentList1()
});

},
mounted() {
  let savedValue = localStorage.getItem('myDataKey');
  
  this.department = localStorage.getItem('myDataKey1');
  this.username = savedValue

  if (this.department != "" && this.departmentnum != 0) {
    this.fetchContentList();
    this.fetchContentList1()
  }
},
computed: {
  dragOptions() {
    // 根据 savedValue 的值来决定是否可以拖动
    return {
      draggable: this.savedValue === 'admin'
    };
  }
}


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
    min-width: 21px;
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

.container {
  overflow-x: auto;
  width: 100%;
  display: flex;
  cursor: pointer;
  user-select: none;
}

}
</style>
