<template>
  <el-table
      :data="tableData"
      v-if="tableDataShow"
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
        prop="enterpriseName"
        label="公司名称"
    >
    </el-table-column>

    <el-table-column
        prop="enRecentNumber"
        label="剩余招聘人数"
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
    if(this.$route.path != '/GraduateEmploymentNeed')
      this.$route.path = '/GraduateEmploymentNeed'

    /**
     * 获取用户id并根据用户id获取毕业生个人基本信息
     */
    let userId = JSON.parse(localStorage.getItem("user")).user.userId
    this.$axios.get('http://localhost:8081/graduate/query?userId='+ userId).then(res=>{
      this.graduate.graduateId = res.data.graduateId
      this.graduate.graduateName = res.data.graduateName
      this.graduate.graduateAge = res.data.graduateAge
      this.graduate.graduateSex = res.data.graduateSex
      this.graduate.graduateBirthday = res.data.graduateBirthday
      this.graduate.graduateCollege = res.data.graduateCollege
      this.graduate.graduateGraduateDate = res.data.graduateGraduateDate
      this.graduate.graduateMajor = res.data.graduateMajor
      this.graduate.userId = res.data.userId
      this.graduate.graduatePhone = res.data.graduatePhone
      this.graduate.graduateEmail = res.data.graduateEmail
      this.graduate.graduateQualificationCheck = res.data.graduateQualificationCheck

      /**
       * 判断是否审核通过
       */
      if(this.graduate.graduateQualificationCheck != '审核通过') {
        const loading = this.$loading({
          lock: true,
          background: 'rgba(0, 0, 0, 0.7)'
        })
        setTimeout(() => {
          loading.close();
          this.$router.push('/GraduateResumeDetails');
          this.$notify({
            title: '提示',
            message: '请先通过毕业资格审查',
            iconClass: 'el-icon-tickets'
          })
        }, 1000);
      }


      /**
       * 获取所有用人需求集合
       */
      this.$axios.get('http://localhost:8081/en/query_all').then(res2=>{
        for(let j = 0; j < res2.data.length; j++) {
          this.employmentNeedList[j] = {
            enId: res2.data[j].enId,
            enterpriseId: res2.data[j].enterpriseId,
            quartersId: res2.data[j].quartersId,
            enPay: res2.data[j].enPay,
            enNumber: res2.data[j].enNumber,
            enRecentNumber: res2.data[j].enRecentNumber,
            enOccupationDescription: res2.data[j].enOccupationDescription,
            enWorkPlace: res2.data[j].enWorkPlace,
            enEndDate: res2.data[j].enEndDate,
          }
        }

        /**
         * 从数据库中查询所有企业并保存在enterpriseList中
         */
        this.$axios.get('http://localhost:8081/enterprise/query_all').then(res3=>{
          for(let k = 0; k < res3.data.length; k++) {
            this.enterpriseList[k] = {
              enterpriseId: res3.data[k].enterpriseId,
              enterpriseName: res3.data[k].enterpriseName,
              enterpriseRegistrationPlace: res3.data[k].enterpriseRegistrationPlace,
              enterpriseRegisteredCapital: res3.data[k].enterpriseRegisteredCapital,
              enterpriseLegalRepresentative: res3.data[k].enterpriseLegalRepresentative,
              enterpriseFoundingDate: res3.data[k].enterpriseFoundingDate,
              enterpriseEmail: res3.data[k].enterpriseEmail,
              enterpriseCoreBusiness: res3.data[k].enterpriseCoreBusiness,
              userId: res3.data[k].userId,
              enterpriseQualificationsCheck: res3.data[k].enterpriseQualificationsCheck,
            }
          }

          /**
           * 从数据库中读取所有职位
           */
          this.$axios.get('http://localhost:8081/quarters/query_all').then(res4=>{
            for(let m = 0; m < res4.data.length; m++) {
              this.quartersList[m] = {
                quartersId: res4.data[m].quartersId,
                quartersFirst: res4.data[m].quartersFirst,
                quartersSecond: res4.data[m].quartersSecond,
                quartersThird: res4.data[m].quartersThird,
              }
            }

            /**
             * 获取所有所投简历列表
             */
            this.$axios.get('http://localhost:8081/rp/query_by_graduate_id?graduateId=' + this.graduate.graduateId).then(res1=> {
              for(let i = 0; i < res1.data.length; i++) {
                this.recruitmentProcessList[i] = {
                  rpId: res1.data[i].rpId,
                  graduateId: res1.data[i].graduateId,
                  enId: res1.data[i].enId,
                  rpPhase: res1.data[i].rpPhase,
                }

                /**
                 * 初始化数据
                 * */
                this.tableData[i] = {
                  enterpriseId: 0,
                  quartersId: 0,
                  rpId: 0,
                  enId: 0,
                  rpPhase: '',
                  quartersThird: '',
                  enterpriseName: '',
                  enEndDate: '',
                  enRecentNumber: '',
                }

                this.tableData[i].rpId = res1.data[i].rpId;
                this.tableData[i].enId = res1.data[i].enId;
                this.tableData[i].rpPhase = res1.data[i].rpPhase;
              }

              /**
               * 匹配用人需求中的数据
               */
              for(let q = 0; q < this.tableData.length; q++) {
                for(let r = 0; r < this.employmentNeedList.length; r++) {
                  if(this.tableData[q].enId == this.employmentNeedList[r].enId) {
                    this.tableData[q].quartersId = this.employmentNeedList[r].quartersId;
                    this.tableData[q].enterpriseId = this.employmentNeedList[r].enterpriseId;
                    this.tableData[q].enRecentNumber = this.employmentNeedList[r].enRecentNumber;
                    this.tableData[q].enEndDate = this.employmentNeedList[r].enEndDate;
                  }
                }
              }

              /**
               * 匹配企业中的数据
               */
              for(let q = 0; q < this.tableData.length; q++) {
                for(let r = 0; r < this.enterpriseList.length; r++) {
                  if(this.tableData[q].enterpriseId == this.enterpriseList[r].enterpriseId) {
                    this.tableData[q].enterpriseName = this.enterpriseList[r].enterpriseName;
                  }
                }
              }

              /**
               * 匹配职业类型中的数据
               */
              for(let q = 0; q < this.tableData.length; q++) {
                for(let r = 0; r < this.quartersList.length; r++) {
                  if(this.tableData[q].quartersId == this.quartersList[r].quartersId) {
                    this.tableData[q].quartersThird = this.quartersList[r].quartersThird;
                  }
                }
              }

              /**
               * 重新渲染
               */
              // 移除组件
              this.tableDataShow = false
              // 在组件移除后，重新渲染组件
              // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
              this.$nextTick(() => {
                this.tableDataShow = true
              })
            })
          })
        })
      })
    })




  },

  data() {
    return {
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
       * 所投简历列表
       */
      recruitmentProcessList: [],

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
       * 企业基本信息
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
       * 展示数据表
       */
      tableData: [],

      /**
       * 数据展示控制
       */
      tableDataShow: true,
    }
  },

  methods: {
    goto(tableData) {
      console.log(tableData)
      this.$router.push({
        path: '/GraduateRecruitmentProcess',
        query: {
          rpId: tableData.rpId,
          enterpriseId: tableData.enterpriseId
        }
      })
    }
  }
}
</script>