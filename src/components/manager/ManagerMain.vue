<script>
export default {
    name:"MyMain",
    data() {
        const tableData = [
          {
            date: '2021-05-02',
            name: '杜俊橙',
            address: '重庆交通大学'
          }, {
            date: '2021-05-03',
            name: '张仁鼎',
            address: '重庆邮电大学'
          }, {
            date: '2021-05-04',
            name: '朱思骏',
            address: '西南大学'
          },{
            date: '2021-05-04',
            name: '陈世星',
            address: '重庆邮电大学'
          }
        ]
        return {
            tableData,
        }
    },
    //后端接口
    // loadPost(){
    //   //this.$axios.post().then()
    // },
    // beforeMount() {
    //     //this.loadGet();
    //     this.loadPost()
    // }
}
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
        <el-table-column prop="name" label="姓名" width="120">
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