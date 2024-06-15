<script>
  export default {
    name:"MyCompanyAside",
    methods:{
      toEnterpriseHome() {
        this.$router.push('/EnterpriseHome')
      },
      toEnterpriseResume() {
        this.$router.push('/EnterpriseResume')
      },
      toEnterpriseRequire() {
        this.$router.push('/EnterpriseRequire')
      },
      toEnterpriseRecruit() {
        this.$router.push('/EnterpriseRecruit')
      }
    }
  }
</script>

<template>
  <el-menu
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      default-active="/CompanyHome"
      :collapse-transition="false"
      style="height: 100vh"
      router
  >

    <el-menu-item @click="toEnterpriseHome">
      <i class="el-icon-user-solid"></i>
      <span slot="title">企业信息</span>
    </el-menu-item>

    <el-menu-item @click="toEnterpriseResume">
      <i class="el-icon-folder-checked"></i>
      <span slot="title">录取档案</span>
    </el-menu-item>

    <el-menu-item @click="toEnterpriseRequire">
      <i class="el-icon-s-claim"></i>
      <span slot="title">发布用人需求</span>
    </el-menu-item>

    <el-menu-item @click="toEnterpriseRecruit">
      <i class="el-icon-share"></i>
      <span slot="title">正在招收</span>
    </el-menu-item>

  </el-menu>
</template>

<style>

</style>