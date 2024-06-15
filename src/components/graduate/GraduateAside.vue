<script>
export default {
  name:"MyAside",
  methods : {
    toGraduateWork() {
      this.$router.push('/GraduateWork')
    },
    toGraduateStudent() {
      this.$router.push('/GraduateStudent')
    },
    toGraduateResumeDelivery() {
      this.$router.push('/GraduateResumeDelivery')
    },
    toGraduateResumeDetails() {
      this.$router.push('/GraduateResumeDetails')
    }
  }
}

</script>

<template>
    <el-menu :default-openeds="['1', '3']"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
             style="height: 100vh;"
    >

        <el-menu-item index="1" ><i class="el-icon-s-home"></i>首页</el-menu-item>
        <el-menu-item index="2" @click="toGraduateStudent"><i class="el-icon-notebook-1"></i>学生基本信息</el-menu-item>
        <el-menu-item index="3" @click="toGraduateResumeDelivery"><i class="el-icon-s-marketing"></i>简历投递情况</el-menu-item>
        <el-menu-item index="4" @click="toGraduateResumeDetails"><i class="el-icon-cpu"></i>简历查看</el-menu-item>
        <el-menu-item index="5" @click="toGraduateWork"><i class="el-icon-ship"></i>找工作</el-menu-item>
    </el-menu>
</template>

<style scoped>

</style>