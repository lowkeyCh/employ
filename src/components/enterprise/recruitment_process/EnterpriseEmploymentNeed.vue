<template>
  <el-table
      :data="formDataList"
      v-if="formDataListShow"
      style="width: 100%"
  >
    <el-table-column align="center" label="ID" width="100" type="index">
    </el-table-column>

    <el-table-column
        prop="quartersThird"
        label="职位名称"
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
        prop="enRecentNumber"
        label="剩余招聘人数"
    >
    </el-table-column>

    <el-table-column
        label="操作"
        width="100">
      <template slot-scope="scope">
        <el-button @click="goto(scope.row)" type="text" size="small">查看详情</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
export default {
  mounted() {
    if(this.$route.path != '/EnterpriseEmploymentNeed')
      this.$route.path = '/EnterpriseEmploymentNeed'

    /**
     * 获取用户id并根据用户id获取企业基本信息
     */
    let userId = JSON.parse(localStorage.getItem("user")).user.userId
    this.$axios.get('http://localhost:8081/enterprise/query?userId='+ userId).then(res=> {
      this.enterprise.enterpriseId = res.data.enterpriseId
      this.enterprise.enterpriseName = res.data.enterpriseName
      this.enterprise.enterpriseRegistrationPlace = res.data.enterpriseRegistrationPlace
      this.enterprise.enterpriseRegisteredCapital = res.data.enterpriseRegisteredCapital
      this.enterprise.enterpriseLegalRepresentative = res.data.enterpriseLegalRepresentative
      this.enterprise.enterpriseFoundingDate = res.data.enterpriseFoundingDate
      this.enterprise.enterpriseEmail = res.data.enterpriseEmail
      this.enterprise.enterpriseCoreBusiness = res.data.enterpriseCoreBusiness
      this.enterprise.userId = res.data.userId
      this.enterprise.enterpriseQualificationsCheck = res.data.enterpriseQualificationsCheck

      if(res.data.enterpriseQualificationsCheck != '审核通过') {
        const loading = this.$loading({
          lock: true,
          background: 'rgba(0, 0, 0, 0.7)'
        })
        setTimeout(() => {
          loading.close();
          this.$router.push('/EnterpriseResume');
          this.$notify({
            title: '提示',
            message: '请先通过企业用人资格审查',
            iconClass: 'el-icon-tickets'
          })
        }, 1000);
      } else {
        /**
         * 根据enterpriseId来获取用人需求
         */
        this.$axios.get('http://localhost:8081/en/query_by_enterprise_id?enterpriseId=' + this.enterprise.enterpriseId).then(res=>{
          /**
           * 从数据库中读取所有职位
           */
          this.$axios.get('http://localhost:8081/quarters/query_all').then(res1=>{
            for(let k = 0; k < res1.data.length; k++) {
              this.quartersList[k] = {
                quartersId: res1.data[k].quartersId,
                quartersFirst: res1.data[k].quartersFirst,
                quartersSecond: res1.data[k].quartersSecond,
                quartersThird: res1.data[k].quartersThird,
              }
            }

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

              /**
               * 为展示数据集合赋值
               */
              this.formDataList[i] = {
                enId: 0,
                enRecentNumber: '',
                quartersThird: '',
                enEndDate: '',
              }
              this.formDataList[i].enId = this.employmentNeedList[i].enId
              this.formDataList[i].enRecentNumber = this.employmentNeedList[i].enRecentNumber
              this.formDataList[i].enEndDate = this.employmentNeedList[i].enEndDate
              for(let j = 0; j < this.quartersList.length; j++) {
                if(this.quartersList[j].quartersId == this.employmentNeedList[i].quartersId) {
                  this.formDataList[i].quartersThird = this.quartersList[j].quartersThird;
                }
              }
            }

            /**
             * 重新渲染el-upload
             */
            // 移除组件
            this.formDataListShow = false
            // 在组件移除后，重新渲染组件
            // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
            this.$nextTick(() => {
              this.formDataListShow = true
            })
          })
        })
      }
    })


  },

  data() {
    return {
      /**
       * 企业基本信息
       */
      enterprise: {
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
      },

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
      formDataList:[{
        enId: 0,
        enRecentNumber: '',
        quartersThird: '',
        enEndDate: '',
      }],

      /**
       * 数据渲染控制
       */
      formDataListShow: false
    }

  },

  methods: {
    goto(tableData) {
      console.log(tableData)
      this.$router.push({
        path: '/EnterpriseENGraduates',
        query: {
          enId: tableData.enId,
          quartersThird: tableData.quartersThird,
        }
      })
    }
  }
}
</script>