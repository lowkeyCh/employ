<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%;">
        <GraduateAside></GraduateAside>
    </el-aside>
    <el-container style="height: 100%;">
      <el-header style="text-align: right; font-size: 12px; height: 100%;border-bottom: #aba9a9 1px solid;">
          <GraduateHeader></GraduateHeader>
      </el-header>
      <el-main style="height: 100%">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import GraduateAside from "@/components/graduate/GraduateAside.vue";
import GraduateHeader from "@/components/graduate/GraduateHeader.vue";
export default {
    components: {GraduateHeader, GraduateAside},
};
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    line-height: 60px;
}
  .el-main{
      padding: 5px;
  }
  .el-aside {
    color: #333;
}
</style>