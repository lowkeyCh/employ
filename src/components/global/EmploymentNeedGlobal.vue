<script>
export default {
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

      enterpriseId: '',

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
       * 单个用人需求
       */
      employmentNeed: {
        enId: 0,
        enterpriseId: 0,
        quartersId: 0,
        enPay: '',
        enNumber: '',
        enRecentNumber: '',
        enOccupationDescription: '',
        enWorkPlace: '',
        enEndDate: '',
      },


    }
  },

  methods: {
    query_all() {
      /**
       * 获取所有用人需求集合
       */
      this.$axios.get('http://localhost:8081/en/query_all').then(res=>{
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
      })
    },

    query_by_en_id() {
      /**
       * 根据enId来获取用人需求
       */
      this.$axios.get('http://localhost:8081/en/query_by_en_id?enId=' + this.recruitmentProcessList[0].enId).then(res=> {
        this.employmentNeed = {
          enId: res.data.enId,
          enterpriseId: res.data.enterpriseId,
          quartersId: res.data.quartersId,
          enPay: res.data.enPay,
          enNumber: res.data.enNumber,
          enRecentNumber: res.data.enRecentNumber,
          enOccupationDescription: res.data.enOccupationDescription,
          enWorkPlace: res.data.enWorkPlace,
          enEndDate: res.data.enEndDate,
        }
      })
    },

    query_by_enterprise_id() {
      /**
       * 根据enterpriseId来获取用人需求
       */
      this.$axios.get('http://localhost:8081/en/query_by_enterprise_id?enterpriseId=' + this.enterpriseId).then(res=>{
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
      })
    }

  }
}
</script>