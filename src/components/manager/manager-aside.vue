<template>
  <div>
    <el-container>
      <el-aside style="width: auto">

        <!-- el-scrollbar标签去除下边框的滚动条 -->
        <el-scrollbar style="width: 100%">
          <el-button class="fold" @click="isCollapse = !isCollapse">
            <i class="el-icon-s-unfold" v-if="isCollapse"></i>
            <i class="el-icon-s-fold" v-else></i>
          </el-button>
          <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen"
                   @close="handleClose" :collapse="isCollapse">
            <el-menu-item index="2" @click="$emit('update:activeName', 'qm_flow')">
              <i class="el-icon-s-home"></i>
              <span slot="title">所有任务</span>
            </el-menu-item>
            <el-menu-item index="2" @click="$emit('update:activeName', 'qm-flow')">
              <i class="el-icon-s-home"></i>
              <span slot="title">个人任务</span>
            </el-menu-item>
          </el-menu>
        </el-scrollbar>

      </el-aside>
    </el-container>

  </div>

</template>

<script>


</script>

<style scoped>
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  min-height: 400px;
}

.fold {
  border: 0;
}
</style>
