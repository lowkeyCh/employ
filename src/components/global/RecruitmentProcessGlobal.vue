<script>
export default {
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

      recruitmentProcessAdd: {
        graduateId: 0,
        enId: 0,
        rpPhase: '',
      },

      recruitmentProcessUpdate: {
        graduateId: 0,
        rpPhase: '',
      },

      /**
       * 招聘过程
       */
      recruitmentProcess: {
        rpId: 0,
        graduateId: 0,
        enId: 0,
        rpPhase: '',
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
       * 根据rpId查询
       */
      rpId: 0,

      /**
       * 根据用人需求查询
       */
      enId: 0,
    }
  },

  methods: {
    query_all() {
      this.$axios.get('http://localhost:8081/rp/query_all').then(res=>{
        for(let i = 0; i < res.data.length; i++) {
          this.recruitmentProcessList[i] = {
            rpId: res.data[i].rpId,
            graduateId: res.data[i].graduateId,
            enId: res.data[i].enId,
            rpPhase: res.data[i].rpPhase,
          }
        }
      })
    },

    add() {
      this.$axios.post('http://localhost:8081/rp/add', this.recruitmentProcessAdd).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "添加OK") {
          this.$message({message: '简历投递成功', type: 'success'})
        }
      })
    },

    query_by_graduate_id() {
      this.$axios.get('http://localhost:8081/rp/query_by_graduate_id?graduateId=' + this.graduate.graduateId).then(res=> {
        for(let i = 0; i < res.data.length; i++) {
          this.recruitmentProcessList[i] = {
            rpId: res.data[i].rpId,
            graduateId: res.data[i].graduateId,
            enId: res.data[i].enId,
            rpPhase: res.data[i].rpPhase,
          }
        }
      })
    },

    query_by_rp_id() {
      this.$axios.get('http://localhost:8081/rp/query_by_rp_id?rpId=' + this.rpId).then(res=> {
        this.recruitmentProcess = {
          rpId: res.data.rpId,
          graduateId: res.data.graduateId,
          enId: res.data.enId,
          rpPhase: res.data.rpPhase,
        }
      })
    },

    query_by_en_id() {
      this.$axios.get('http://localhost:8081/rp/query_by_en_id?enId=' + this.enId).then(res=> {
        for(let i = 0; i < res.data.length; i++) {
          this.recruitmentProcessList[i] = {
            rpId: res.data[i].rpId,
            graduateId: res.data[i].graduateId,
            enId: res.data[i].enId,
            rpPhase: res.data[i].rpPhase,
          }
        }
      })
    },

    update() {
      this.$axios.post('http://localhost:8081/rp/update', this.recruitmentProcessUpdate).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "修改OK") {
          this.$message({message: '审核成功', type: 'success'})
        }
      })
    }
  }
}
</script>