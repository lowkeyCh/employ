<template>
  <div>
    <div style="padding: 5px 20px 10px 0px">
      <el-input placeholder="领域/模块/职位" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
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
          prop="graduateName"
          label="毕业生姓名"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="enterpriseName"
          label="企业名称"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="quartersThird"
          label="职位名称"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="rpPhase"
          label="招聘阶段"
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
    this.$axios.get('http://localhost:8081/rp/query_all').then(res=>{


      for(let i = 0; i < res.data.length; i++) {
        this.tableDataList[i] = {
          rpId: res.data[i].rpId,
          graduateId: res.data[i].graduateId,
          enId: res.data[i].enId,
          rpPhase: res.data[i].rpPhase,
          graduateName: '',
          quartersThird: '',
          enterpriseName: '',
        }

        this.recruitmentProcessList[i] = {
          rpId: res.data[i].rpId,
          graduateId: res.data[i].graduateId,
          enId: res.data[i].enId,
          rpPhase: res.data[i].rpPhase,
        }

        this.$axios.get('http://localhost:8081/graduate/query_by_graduate_id?graduateId='+ res.data[i].graduateId).then(res2=>{
          this.tableDataList[i].graduateName = res2.data.graduateName

          this.$axios.get('http://localhost:8081/en/query_by_en_id?enId=' + res.data[i].enId,).then(res3=> {

            this.$axios.get('http://localhost:8081/enterprise/query_by_enterprise_id?enterpriseId=' + res3.data.enterpriseId).then(res4=>{
              this.tableDataList[i].enterpriseName = res4.data.enterpriseName

              this.$axios.get('http://localhost:8081/quarters/query_by_quarters_id?quartersId=' + res3.data.quartersId).then(res5=>{
                this.tableDataList[i].quartersThird = res5.data.quartersThird

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
            })
          })
        })


      }
    })
  },

  data() {
    return {
      /**
       * 招聘过程集合
       */
      recruitmentProcessList: [{
        rpId: 0,
        graduateId: 0,
        enId: 0,
        rpPhase: '',
      }],

      /**
       * 展示数据集合
       */
      tableDataList: [{
        rpId: 0,
        graduateId: 0,
        enId: 0,
        rpPhase: '',
        graduateName: '',
        quartersThird: '',
        enterpriseName: '',
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

<style scoped>

</style>