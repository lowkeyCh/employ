<template>
  <div>
    <div style="padding: 5px 20px 10px 0px">
      <el-input placeholder="账号" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
      <el-button type="primary" icon="el-icon-search" style="margin-left: 10px">查询</el-button>
    </div>

    <el-table
        :data="tableDataList"
        v-if="tableDataListShow"
        style="width: 100%"
    >
      <el-table-column align="center" label="ID" width="100" type="index">
      </el-table-column>

      <el-table-column
          prop="userName"
          label="用户名"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="userPassword"
          label="密码"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="userIdentity"
          label="身份"
      >
      </el-table-column>

      <el-table-column
          label="操作"
          width="100"
      >

        <template slot-scope="scope">
          <el-button @click="update(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="delete(scope.row)" type="text" size="small">删除</el-button>
        </template>

      </el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  mounted() {
    /**
     * 从数据库中读取所有用户
     */
    this.$axios.get('http://localhost:8081/user/query_all').then(res=>{
      for(let i = 0; i < res.data.length; i++) {
        this.userList[i] = {
          userId: res.data[i].userId,
          userName: res.data[i].userName,
          userPassword: res.data[i].userPassword,
          userIdentity: res.data[i].userIdentity,
        }

        this.tableDataList[i] = {
          userId: res.data[i].userId,
          userName: res.data[i].userName,
          userPassword: res.data[i].userPassword,
          userIdentity: res.data[i].userIdentity,
        }
      }

      /**
       * 重新渲染el-upload
       */
      // 移除组件
      this.tableDataListShow = false
      // 在组件移除后，重新渲染组件
      // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
      this.$nextTick(() => {
        this.tableDataListShow = true
      })
    })
  },

  data() {
    return {
      /**
       * 用户数据列表
       */
      userList: [{
        userId: 0,
        userName: '',
        userPassword: '',
        userIdentity: '',
      }],

      /**
       * 展示数据集合
       */
      tableDataList: [{
        userId: 0,
        userName: '',
        userPassword: '',
        userIdentity: '',
      }],

      /**
       * 展示数据渲染
       */
      tableDataListShow: false
    }
  },

  methods: {

  }
}
</script>