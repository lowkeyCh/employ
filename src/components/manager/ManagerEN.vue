<template>
  <div>
    <div style="padding: 5px 20px 10px 0px">
      <el-input placeholder="企业/职位" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
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
          prop="enterpriseName"
          label="企业"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="quartersThird"
          label="职位"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="enPay"
          label="薪资"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="enEndDate"
          label="截止日期"
          width="180"
      >
      </el-table-column>

      <el-table-column
          prop="enWorkPlace"
          label="工作地点"
      >
      </el-table-column>

      <el-table-column
          label="操作"
          width="180"
      >

        <template slot-scope="scope">
          <el-button @click="details(scope.row)" type="text" size="small">详情</el-button>
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
     * 获取所有用人需求集合
     */
    this.$axios.get('http://localhost:8081/en/query_all').then(res=>{
      /**
       * 从数据库中查询所有企业并保存在enterpriseList中
       */
      this.$axios.get('http://localhost:8081/enterprise/query_all').then(res2=>{
        /**
         * 从数据库中读取所有职位
         */
        this.$axios.get('http://localhost:8081/quarters/query_all').then(res3=>{
          for(let i = 0; i < res3.data.length; i++) {
            this.quartersList[i] = {
              quartersId: res3.data[i].quartersId,
              quartersFirst: res3.data[i].quartersFirst,
              quartersSecond: res3.data[i].quartersSecond,
              quartersThird: res3.data[i].quartersThird,
            }
          }
          console.log(this.quartersList)


          for(let i = 0; i < res2.data.length; i++) {
            this.enterpriseList[i] = {
              enterpriseId: res2.data[i].enterpriseId,
              enterpriseName: res2.data[i].enterpriseName,
              enterpriseRegistrationPlace: res2.data[i].enterpriseRegistrationPlace,
              enterpriseRegisteredCapital: res2.data[i].enterpriseRegisteredCapital,
              enterpriseLegalRepresentative: res2.data[i].enterpriseLegalRepresentative,
              enterpriseFoundingDate: res2.data[i].enterpriseFoundingDate,
              enterpriseEmail: res2.data[i].enterpriseEmail,
              enterpriseCoreBusiness: res2.data[i].enterpriseCoreBusiness,
              userId: res2.data[i].userId,
              enterpriseQualificationsCheck: res2.data[i].enterpriseQualificationsCheck,
            }
          }
          console.log(this.enterpriseList)


          for(let i = 0; i < res.data.length; i++) {
            this.employmentNeedList[i] = {
              enId: res.data[i].enId,
              enterpriseId: res.data[i].enterpriseId,
              quartersId: res.data[i].quartersId,
              enPay: res.data[i].enPay,
              enNumber: res.data[i].enNumber,
              enRecentNumber: res.data[i].enRecentNumber,
              enOccupationDescription: res.data[i].enOccupationDescription,
              enWorkPlace: res.data[i].enWorkPlace,
              enEndDate: res.data[i].enEndDate,
            }

            this.tableDataList[i] = {
              enId: res.data[i].enId,
              enPay: res.data[i].enPay,
              enWorkPlace: res.data[i].enWorkPlace,
              enEndDate: res.data[i].enEndDate,
              enterpriseName: '',
              quartersThird: '',
            }

            for(let j = 0; j < this.quartersList.length; j++) {
              if(res.data[i].quartersId == this.quartersList[j].quartersId) {
                this.tableDataList[i].quartersThird = this.quartersList[j].quartersThird
              }
            }

            for(let j = 0; j < this.enterpriseList.length; j++) {
              if(res.data[i].enterpriseId == this.enterpriseList[j].enterpriseId) {
                this.tableDataList[i].enterpriseName = this.enterpriseList[j].enterpriseName
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
          }

        })
      })
    })
  },

  data() {
    return {
      /**
       * 用人需求集合
       */
      employmentNeedList: [{
        enId: 0,
        enterpriseId: 0,
        quartersId: 0,
        enPay: '',
        enNumber: '',
        enRecentNumber: '',
        enOccupationDescription: '',
        enWorkPlace: '',
        enEndDate: '',
      }],

      /**
       * 企业基本信息集合
       */
      enterpriseList: [{
        enterpriseId: 0,
        enterpriseName: '',
        enterpriseRegistrationPlace: '',
        enterpriseRegisteredCapital: '',
        enterpriseLegalRepresentative: '',
        enterpriseFoundingDate: '',
        enterpriseEmail: '',
        enterpriseCoreBusiness: '',
        userId: 0,
        enterpriseQualificationsCheck: '',
      }],

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
        enId: 0,
        enPay: '',
        enWorkPlace: '',
        enEndDate: '',
        enterpriseName: '',
        quartersThird: '',
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