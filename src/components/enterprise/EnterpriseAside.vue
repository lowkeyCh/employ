<template>
  <el-menu
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :default-active="this.$route.path"
      :collapse-transition="false"
      style="height: 200vh"
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

    <el-submenu>
      <template slot="title"><i class="el-icon-share"></i>正在招收</template>

      <el-menu-item-group title="员工招聘" style="font-weight: bolder">
        <el-menu-item index="/EnterpriseEmploymentNeed">用人需求查看</el-menu-item>
        <el-menu-item index="/EnterpriseENGraduates">申请毕业生集合</el-menu-item>
        <el-menu-item index="/EnterpriseRecruitmentProcess">招聘进度</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

  </el-menu>
</template>