<script>
import EnterpriseAside from "@/components/enterprise/EnterpriseAside.vue";
import EnterpriseHeader from "@/components/enterprise/EnterpriseHeader.vue";

export default {
  name: "EnterpriseIndex",
  components: {EnterpriseHeader, EnterpriseAside}
}
</script>

<template>
  <el-container style="height: 100%; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246);height: 100%;">
      <EnterpriseAside></EnterpriseAside>
    </el-aside>

    <el-container style="height: 100%;">
      <el-header style="text-align: right; font-size: 12px; height: 100%;border-bottom: #aba9a9 1px solid;">
        <EnterpriseHeader></EnterpriseHeader>
      </el-header>

      <el-main style="height: 100%">
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<style>
.el-container.is-vertical {
  flex-direction: column;

}

</style>