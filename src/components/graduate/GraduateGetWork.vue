<template>
  <div v-if="getWorkShow">
    <div style="display:flex;justify-content:center">
      <el-input prefix-icon="el-icon-search" style="width:600px;margin-right:10px" placeholder="输入岗位名称" size="small">     </el-input>
      <el-button type="primary" icon="el-icon-search" size="large" style="width: 50px; height: 40px; margin-top: 5px"></el-button>
    </div>

    <div v-for="formData in formDataList" :key="formData" style="display: inline-block; margin-left: 30px">
      <el-card style="display: inline-block; margin-right: 30px; margin-left: 0">
        <div slot="header">
          <span>{{ formData.quarters.quartersThird }}</span>
          <el-button style="float: right; padding: 3px 0" type="text" @click="add(formData)">提交简历</el-button>
        </div>


        <div>
          <div> 公司名称：{{ formData.enterpriseName }} </div>

          <div style="margin-top: 5px"> 公司邮箱：{{ formData.enterpriseEmail }} </div>

          <div style="margin-top: 5px"> 工作地址：{{ formData.enWorkPlace }} </div>

          <div style="margin-top: 5px"> 工作范畴：{{ formData.quarters.quartersFirst +'-'+ formData.quarters.quartersSecond +'-'+ formData.quarters.quartersThird }} </div>

          <div style="margin-top: 5px"> 详细描述：{{ formData.enOccupationDescription }} </div>

          <div style="margin-top: 5px" >
            <el-tag type="success" style="font-size: large">{{ formData.enPay }}</el-tag>
          </div>

          <div style="margin-top: 5px" >
            <el-tag type="success" style="font-size: large">{{ formData.enNumber }}</el-tag>
            <el-tag type="success" style="font-size: large; margin-left: 10px">{{ formData.enRecentNumber }}</el-tag>
          </div>

          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ formData.enEndDate }}</el-tag>
          </div>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  mounted() {
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
    })



    /**
     * 读取用人需求信息
     */
    this.$axios.get('http://localhost:8081/en/query_all').then(res=>{
      /**
       * 从数据库中查询所有企业并保存在enterpriseList中
       */
      this.$axios.get('http://localhost:8081/enterprise/query_all').then(res1=>{
        /**
         * 从数据库中读取所有职位
         */
        this.$axios.get('http://localhost:8081/quarters/query_all').then(res2=>{
          for(let i = 0; i < res2.data.length; i++) {
            this.quartersList[i] = {
              quartersId: res2.data[i].quartersId,
              quartersFirst: res2.data[i].quartersFirst,
              quartersSecond: res2.data[i].quartersSecond,
              quartersThird: res2.data[i].quartersThird,
            }
          }

          for(let i = 0; i < res1.data.length; i++) {
            this.enterpriseList[i] = {
              enterpriseId: res1.data[i].enterpriseId,
              enterpriseName: res1.data[i].enterpriseName,
              enterpriseRegistrationPlace: res1.data[i].enterpriseRegistrationPlace,
              enterpriseRegisteredCapital: res1.data[i].enterpriseRegisteredCapital,
              enterpriseLegalRepresentative: res1.data[i].enterpriseLegalRepresentative,
              enterpriseFoundingDate: res1.data[i].enterpriseFoundingDate,
              enterpriseEmail: res1.data[i].enterpriseEmail,
              enterpriseCoreBusiness: res1.data[i].enterpriseCoreBusiness,
              userId: res1.data[i].userId,
              enterpriseQualificationsCheck: res1.data[i].enterpriseQualificationsCheck,
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
          }

          /**
           * 根据上述信息构建formDataList
           */
          for(let i = 0; i < this.employmentNeedList.length; i++) {
            this.formDataList[i] = {
              enId: this.employmentNeedList[i].enId,
              enWorkPlace: this.employmentNeedList[i].enWorkPlace,
              enPay: '薪资： ' + this.employmentNeedList[i].enPay,
              enEndDate: '截止日期： ' + this.employmentNeedList[i].enEndDate,
              enOccupationDescription: this.employmentNeedList[i].enOccupationDescription,
              enNumber: '招聘人数： ' + this.employmentNeedList[i].enNumber,
              enRecentNumber: '剩余招聘人数： ' + this.employmentNeedList[i].enRecentNumber,
              quarters: {
                quartersFirst: '',
                quartersSecond: '',
                quartersThird: '',
              },
              enterpriseName: '',
              enterpriseEmail: '',
            }

            /**
             * 找到quarters并赋值
             */
            this.formDataList[i].quarters.quartersId = this.employmentNeedList[i].quartersId
            for(let j = 0; j < this.quartersList.length; j++) {
              if(this.quartersList[j].quartersId == this.employmentNeedList[i].quartersId) {
                this.formDataList[i].quarters.quartersFirst = this.quartersList[j].quartersFirst
                this.formDataList[i].quarters.quartersSecond = this.quartersList[j].quartersSecond
                this.formDataList[i].quarters.quartersThird = this.quartersList[j].quartersThird
              }
            }

            /**
             * 找到enterprise并赋值
             */
            this.formDataList[i].enterpriseId = this.employmentNeedList[i].enterpriseId
            for(let j = 0; j < this.enterpriseList.length; j++) {
              if(this.enterpriseList[j].enterpriseId == this.employmentNeedList[i].enterpriseId) {
                this.formDataList[i].enterpriseName = this.enterpriseList[j].enterpriseName
                this.formDataList[i].enterpriseEmail = this.enterpriseList[j].enterpriseEmail
              }
            }
          }

          /**
           * 重新渲染
           */
          // 移除组件
          this.getWorkShow = false
          // 在组件移除后，重新渲染组件
          // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
          this.$nextTick(() => {
            this.getWorkShow = true
          })
        })
      })


    })
  },

  data() {
    return{
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
       * 职位表
       */
      quartersList: [{
        quartersId: 0,
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      }],

      /**
       * 招聘过程添加
       */
      recruitmentProcessAdd: {
        graduateId: 0,
        enId: 0,
        rpPhase: '',
      },

      /**
       * 展示信息表
       */
      formDataList: [{
        quarters: {
          quartersId: 0,
          quartersFirst: '',
          quartersSecond: '',
          quartersThird: '',
        },
        enterpriseName: '',
        enterpriseEmail: '',
        enWorkPlace: '',
        enPay: '',
        enEndDate: '',
        enOccupationDescription: '',
        enNumber: '',
        enRecentNumber: '',

        enId: 0,
        enterpriseId: 0,
      }],

      /**
       * 数据渲染控制
       */
      getWorkShow: true,

    }
  },

  methods: {
    add(formData) {
      console.log(formData)
      this.recruitmentProcessAdd.graduateId = this.graduate.graduateId
      this.recruitmentProcessAdd.enId = formData.enId
      this.recruitmentProcessAdd.rpPhase = '简历投递'

      this.$axios.post('http://localhost:8081/rp/add', this.recruitmentProcessAdd).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "添加OK") {
          this.$message({message: '简历投递成功', type: 'success'})
        }
      })
    }
  },
}
</script>

<style scoped>
.box-card {
  width: 360px;
}
.admin-card {
  /*
  加上display:flex可以显示在一行，

  加上flex-wrap: wrap;可以进行换行显示比较好看
  */
  width: 400px;
  display: flex;
  flex-wrap: wrap;
  /* 这个属性可以加大卡片之间的间隔距离 */
  justify-content: space-around;
  margin-top: 10px;
}

</style>
