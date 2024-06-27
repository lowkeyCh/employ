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

      /**
       * 通过毕业生id查询
       */
      graduateID: '',
    }
  },

  methods: {
    query_by_user_id() {
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
      })
    },

    query_by_graduate_id() {
      this.$axios.get('http://localhost:8081/graduate/query_by_graduate_id?graduateId='+ this.graduateID).then(res=>{
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
      })
    }
  },
}
</script>