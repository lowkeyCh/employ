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
        prop="graduateName"
        label="毕业生姓名"
        width="180"
    >
    </el-table-column>

    <el-table-column
        prop="graduateCollege"
        label="毕业院校"
        width="180"
    >
    </el-table-column>

    <el-table-column
        prop="graduateMajor"
        label="所学专业"
    >
    </el-table-column>

    <el-table-column
        prop="graduatePhone"
        label="联系电话"
    >
    </el-table-column>

    <el-table-column
        prop="rpPhase"
        label="招聘进度"
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
    if(this.$route.path != '/EnterpriseENGraduates')
      this.$route.path = '/EnterpriseENGraduates'

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
         * 如果未选择某一招聘过程就进入
         */
        if(this.$route.query.enId == undefined) {
          const loading = this.$loading({
            lock: true,
            background: 'rgba(0, 0, 0, 0.7)'
          })

          setTimeout(() => {
            loading.close();
            this.$router.push('/EnterpriseEmploymentNeed');
            this.$notify({
              title: '提示',
              message: '请选择某一用人需求',
              iconClass: 'el-icon-mouse'
            })
          }, 1000);
        } else {
          /**
           * 获取当前用人需求对应毕业生集合
           */
          this.$axios.get('http://localhost:8081/rp/query_by_en_id?enId=' + this.$route.query.enId).then(res=> {
            for(let i = 0; i < res.data.length; i++) {
              this.recruitmentProcessList[i] = {
                rpId: res.data[i].rpId,
                graduateId: res.data[i].graduateId,
                enId: res.data[i].enId,
                rpPhase: res.data[i].rpPhase,
              }
              this.formDataList[i] = {
                rpId: 0,
                rpPhase: '',
                graduateId: 0,
                quartersThird: '',
                graduateName: '',
                graduateCollege: '',
                graduateMajor: '',
                graduatePhone: '',
              }
              this.formDataList[i].rpId = res.data[i].rpId
              this.formDataList[i].rpPhase = res.data[i].rpPhase
              this.formDataList[i].quartersThird = this.$route.query.quartersThird

              /**
               * 根据当前毕业生id查询毕业生信息
               */
              this.$axios.get('http://localhost:8081/graduate/query_by_graduate_id?graduateId='+ this.recruitmentProcessList[i].graduateId).then(res3=>{
                this.formDataList[i].graduateId = res3.data.graduateId
                this.formDataList[i].graduateName = res3.data.graduateName
                this.formDataList[i].graduateCollege = res3.data.graduateCollege
                this.formDataList[i].graduateMajor = res3.data.graduateMajor
                this.formDataList[i].graduatePhone = res3.data.graduatePhone

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
            }
          })


        }
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
       * 毕业生个人基本信息
       */
      graduate: {
        graduateId: 0,
        graduateName: '',
        graduateAge: '',
        graduateSex: '',
        graduateBirthday: '',
        graduateCollege: '',
        graduateGraduateDate: '',
        graduateMajor: '',
        userId: 0,
        graduatePhone: '',
        graduateEmail: '',
        graduateQualificationCheck: '',
      },

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
       * 展示数据
       */
      formDataList: [],

      /**
       * 展示数据渲染控制
       */
      formDataListShow: true,
    }
  },

  methods: {
    goto(tableData) {
      this.$router.push({
        path: '/EnterpriseRecruitmentProcess',
        query: {
          rpId: tableData.rpId,
          graduateId: tableData.graduateId
        }
      })
    }
  },


}
</script>