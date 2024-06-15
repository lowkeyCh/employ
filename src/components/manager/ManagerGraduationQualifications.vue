<script>
  export default {
    name:"MyMain",
    data() {
      const tableData = [
        {
          date: '后端工程师',
          name: '腾讯',
          address: '2021'
        }
      ]
      return {
        tableData,
      }
    }
  }
</script>

<template>
  <div>
    <div style="margin-bottom: 5px">
      <el-input placeholder="杜俊橙" style="width: 200px;" suffix-icon="el-icon-search"></el-input>
      <el-button type="primary" istyle="margin-left: 10px">查询</el-button>
      <el-button type="success">重置</el-button>
      <el-button type="info">新增</el-button>
    </div>
    <el-table :data="tableData"
              :header-cell-style="{background:'#989d9f',color:'#555555'}"
              border
    >
      <el-table-column prop="date" label="就业职位" width="140">
      </el-table-column>
      <el-table-column prop="name" label="公司名称" width="120">
      </el-table-column>
      <el-table-column prop="address" label="入职年份">
      </el-table-column>
      <el-table-column prop="operate" label="操作">
        <el-button type="primary" icon="el-icon-edit" circle></el-button>
        <el-button type="danger" icon="el-icon-delete" circle></el-button>
      </el-table-column>
    </el-table>
  </div>
</template>

<style>

</style>