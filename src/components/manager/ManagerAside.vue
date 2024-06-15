<script>
export default {
  name:"ManagerAside",
  methods:{
    toManagerHome() {
      this.$router.push('/ManagerHome')
    },
    toManagerCompany() {
      this.$router.push('/ManagerCompany')
    },
    toManagerComaudit() {
      this.$router.push('/ManagerComaudit')
    },
    toManagerMain() {
      this.$router.push('/ManagerMain')
    },
    toManagerGraduationQualifications() {
      this.$router.push('/ManagerGraduationQualifications')
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

        <el-menu-item index="1" @click="toManagerHome"><i class="el-icon-s-home"></i>首页</el-menu-item>
        <el-submenu index="2">
            <template slot="title"><i class="el-icon-s-check"></i>用户信息管理</template>
            <el-menu-item-group>
                <template slot="title">企业信息管理</template>
                <el-menu-item index="2-1" @click="toManagerCompany">企业基本信息管理</el-menu-item>
                <el-menu-item index="2-2" @click="toManagerComaudit">企业招聘资格审查</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="学生信息管理">
                <el-menu-item index="2-3" @click="toManagerMain">学生基本信息管理</el-menu-item>
                <el-menu-item index="2-4" @click="toManagerGraduationQualifications">学生就业信息查询</el-menu-item>
            </el-menu-item-group>
        </el-submenu>
        <el-menu-item index="3"><i class="el-icon-notebook-1"></i>就业协议书管理</el-menu-item>
        <el-menu-item index="4"><i class="el-icon-s-marketing"></i>就业数据统计</el-menu-item>
        <el-menu-item index="5"><i class="el-icon-cpu"></i>学院专业管理</el-menu-item>
        <el-menu-item index="6"><i class="el-icon-ship"></i>企业类型管理</el-menu-item>
    </el-menu>
</template>

<style scoped>

</style>