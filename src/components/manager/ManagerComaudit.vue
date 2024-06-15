<script setup>

</script>

<template>
    <div>
        <div style="margin-bottom: 5px">
            <el-input placeholder="请输入名字" style="width: 200px;" suffix-icon="el-icon-search"></el-input>
            <el-button type="primary" istyle="margin-left: 10px">查询</el-button>
            <el-button type="success">重置</el-button>
            <el-button type="info">新增</el-button>
        </div>
        <el-table :data="tableData"
                  :header-cell-style="{background:'#989d9f',color:'#555555'}"
                  border
        >
            <el-table-column prop="date" label="日期" width="140">
            </el-table-column>
            <el-table-column prop="name" label="审核书" width="120">
            </el-table-column>
            <el-table-column prop="address" label="地址">
            </el-table-column>
            <el-table-column prop="operate" label="操作">
                <el-button type="primary" icon="el-icon-edit" circle></el-button>
                <el-button type="danger" icon="el-icon-delete" circle></el-button>
            </el-table-column>
        </el-table>
    </div>
</template>

<style scoped>

</style>