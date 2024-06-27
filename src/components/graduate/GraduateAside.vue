<script>
export default {
  methods : {

  }
}

</script>

<template>
    <el-menu
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
             style="height: 100vh;"
             router
             :default-active="this.$route.path"
    >
      <el-menu-item index="/GraduateStudent"><i class="el-icon-notebook-1"></i>学生基本信息</el-menu-item>
      <el-menu-item index="/GraduateResumeDetails"><i class="el-icon-cpu"></i>毕业资格上传</el-menu-item>
      <el-menu-item index="/GraduateWork"><i class="el-icon-ship"></i>找工作</el-menu-item>
      <el-submenu>
        <template slot="title"><i class="el-icon-s-marketing"></i>简历投递情况</template>

        <el-menu-item-group title="招聘过程" style="font-weight: bolder">
          <el-menu-item index="/GraduateEmploymentNeed">招聘过程状况</el-menu-item>
          <el-menu-item index="/GraduateRecruitmentProcess">招聘进度</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
</template>

<style scoped>

</style>