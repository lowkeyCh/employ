<template>
  <div>
    <div style="padding: 5px 20px 10px 0px">
      <el-input placeholder="领域/模块/职位" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
      <el-button type="primary" icon="el-icon-search" style="margin-left: 10px">查询</el-button>
      <el-button @click="addShow" type="success" icon="el-icon-plus" style="margin-left: 10px">新建</el-button>
    </div>

    <el-table
        :data="tableDataList"
        v-if="tableDataListShow"
        style="width: 100%"
    >
      <el-table-column align="center" label="ID" width="100" type="index">
      </el-table-column>

      <el-table-column
          prop="quartersFirst"
          label="领域"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="quartersSecond"
          label="模块"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="quartersThird"
          label="职位"
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

    <el-dialog
        title="职业范畴"
        :visible.sync="addDialog.addShowDialog"
        style="margin-left: 400px; width: 800px"
        center
    >
      <el-form ref="addDialog.quarters" :model="addDialog.quarters" label-width="80px">
        <el-form-item label="领域">
          <el-input v-model="addDialog.quarters.quartersFirst" style="width: 200px"></el-input>
        </el-form-item>

        <el-form-item label="模块">
          <el-input v-model="addDialog.quarters.quartersSecond" style="width: 200px"></el-input>
        </el-form-item>

        <el-form-item label="职位">
          <el-input v-model="addDialog.quarters.quartersThird" style="width: 200px"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="addQuarters">立即创建</el-button>
          <el-button @click="addDialog.addShowDialog = false;">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
export default {
  mounted() {
    /**
     * 从数据库中读取所有职位
     */
    this.$axios.get('http://localhost:8081/quarters/query_all').then(res=>{
      for(let i = 0; i < res.data.length; i++) {
        this.quartersList[i] = {
          quartersId: res.data[i].quartersId,
          quartersFirst: res.data[i].quartersFirst,
          quartersSecond: res.data[i].quartersSecond,
          quartersThird: res.data[i].quartersThird,
        }

        /**
         * 展示数据赋值
         */
        this.tableDataList[i] = {
          quartersId: res.data[i].quartersId,
          quartersFirst: res.data[i].quartersFirst,
          quartersSecond: res.data[i].quartersSecond,
          quartersThird: res.data[i].quartersThird,
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
       * 职位类型集合
       */
      quartersList:[{
        quartersId: 0,
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      }],

      /**
       * 展示数据集合
       */
      tableDataList: [{
        quartersId: 0,
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      }],

      /**
       * 展示数据渲染
       */
      tableDataListShow: false,

      /**
       * 添加对话框
       */
      addDialog: {
        quarters: {
          quartersFirst: '',
          quartersSecond: '',
          quartersThird: '',
        },
        addShowDialog: false
      }
    }
  },

  methods: {
    addShow() {
      this.addDialog.quarters = {
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      }
      this.addDialog.addShowDialog = true
    },

    /**
     * 添加职位
     */
    addQuarters() {
      this.$axios.post('http://localhost:8081/quarters/add', this.addDialog.quarters).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "添加OK") {
          this.$message({message: '添加成功', type: 'success'})
        } else {
          this.$message({message: '添加失败', type: 'warning'})
        }

        this.quartersList[this.quartersList.length] = {
          quartersFirst: this.addDialog.quarters.quartersFirst,
          quartersSecond: this.addDialog.quarters.quartersSecond,
          quartersThird: this.addDialog.quarters.quartersThird,
        }

        this.tableDataList[this.tableDataList.length] = {
          quartersFirst: this.addDialog.quarters.quartersFirst,
          quartersSecond: this.addDialog.quarters.quartersSecond,
          quartersThird: this.addDialog.quarters.quartersThird,
        }

        location.reload()

        this.addDialog.addShowDialog = false

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

    update() {

    },

    delete() {

    },
  },
}
</script>

<style scoped>

</style>