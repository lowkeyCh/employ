<script>
export default {

}
</script>

<template>
    <el-menu :default-openeds="['1', '3']"
             background-color="#545c64"
             text-color="#fff"
             active-text-color="#ffd04b"
             style="height: 200vh;"
             router
             default-active="/ManagerHome"
    >

        <el-menu-item index="/ManagerHome"><i class="el-icon-s-home"></i>首页</el-menu-item>
        <el-submenu>

            <template slot="title"><i class="el-icon-s-check"></i>用户信息管理</template>

            <el-menu-item-group title="企业信息管理" style="font-weight: bolder">
                <el-menu-item index="/ManagerCompany">企业基本信息管理</el-menu-item>
                <el-menu-item index="/ManagerComaudit">企业用人资格审查</el-menu-item>
            </el-menu-item-group>

            <el-menu-item-group title="毕业生信息管理" style="font-weight: bolder">
                <el-menu-item index="/ManagerMain">毕业生基本信息管理</el-menu-item>
                <el-menu-item index="/ManagerGraduationQualifications">毕业生就业资格审查</el-menu-item>
            </el-menu-item-group>

        </el-submenu>
        <el-menu-item index="/ManagerQuarters"><i class="el-icon-notebook-1"></i>职位管理</el-menu-item>
        <el-menu-item index="/ManagerEN"><i class="el-icon-s-marketing"></i>用人需求管理</el-menu-item>
        <el-menu-item index="/ManagerRP"><i class="el-icon-cpu"></i>招聘进度管理</el-menu-item>
        <el-menu-item index="/ManagerUser"><i class="el-icon-ship"></i>账号管理</el-menu-item>
    </el-menu>
</template>

<style scoped>

</style>