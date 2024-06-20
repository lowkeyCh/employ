
<template>
    <el-container style="height: 100%; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%;">
            <ManagerAside></ManagerAside>
        </el-aside>

        <el-container style="height: 100%;">
            <el-header style="text-align: right; font-size: 12px; height: 100%;border-bottom: #aba9a9 1px solid;">
                <ManagerHeader></ManagerHeader>
            </el-header>

            <el-main style="height: 100%">
                <router-view></router-view>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
import ManagerAside from "@/components/manager/ManagerAside.vue";
import ManagerHeader from "@/components/manager/ManagerHeader.vue";

export default {
    components: {ManagerAside, ManagerHeader},
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