<script>

</script>

<template>
  <el-menu
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      default-active="/EnterpriseHome"
      :collapse-transition="false"
      style="height: 100vh"
      router
  >

    <el-menu-item index="/EnterpriseHome" >
      <i class="el-icon-user-solid"></i>
      <span slot="title">企业信息</span>
    </el-menu-item>

    <el-menu-item index="/EnterpriseResume">
      <i class="el-icon-folder-checked"></i>
      <span slot="title">用人资格上传</span>
    </el-menu-item>

    <el-menu-item index="/EnterpriseRequire">
      <i class="el-icon-s-claim"></i>
      <span slot="title">发布用人需求</span>
    </el-menu-item>

    <el-menu-item index="/EnterpriseRecruit">
      <i class="el-icon-share"></i>
      <span slot="title">正在招收</span>
    </el-menu-item>

  </el-menu>
</template>

<style>

</style>