<script>
export default {
  data() {
    return {
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
       * 根据enterpriseId查询企业信息
       */
      enterpriseId: '',
    }
  },

  methods: {
    query_all() {
      /**
       * 从数据库中查询所有企业并保存在enterpriseList中
       */
      this.$axios.get('http://localhost:8081/enterprise/query_all').then(res=>{
        for(let i = 0; i < res.data.length; i++) {
          this.enterpriseList[i] = {
            enterpriseId: res.data[i].enterpriseId,
            enterpriseName: res.data[i].enterpriseName,
            enterpriseRegistrationPlace: res.data[i].enterpriseRegistrationPlace,
            enterpriseRegisteredCapital: res.data[i].enterpriseRegisteredCapital,
            enterpriseLegalRepresentative: res.data[i].enterpriseLegalRepresentative,
            enterpriseFoundingDate: res.data[i].enterpriseFoundingDate,
            enterpriseEmail: res.data[i].enterpriseEmail,
            enterpriseCoreBusiness: res.data[i].enterpriseCoreBusiness,
            userId: res.data[i].userId,
            enterpriseQualificationsCheck: res.data[i].enterpriseQualificationsCheck,
          }
        }
      })
    },

    query_by_enterprise_id() {
      /**
       * 从数据库中根据enterpriseId查询企业并保存在enterprise中
       */
      this.$axios.get('http://localhost:8081/enterprise/query_by_enterprise_id?enterpriseId=' + this.enterpriseId).then(res=>{
        this.enterprise = {
          enterpriseId: res.data.enterpriseId,
          enterpriseName: res.data.enterpriseName,
          enterpriseRegistrationPlace: res.data.enterpriseRegistrationPlace,
          enterpriseRegisteredCapital: res.data.enterpriseRegisteredCapital,
          enterpriseLegalRepresentative: res.data.enterpriseLegalRepresentative,
          enterpriseFoundingDate: res.data.enterpriseFoundingDate,
          enterpriseEmail: res.data.enterpriseEmail,
          enterpriseCoreBusiness: res.data.enterpriseCoreBusiness,
          userId: res.data.userId,
          enterpriseQualificationsCheck: res.data.enterpriseQualificationsCheck,
        }
      })
    },


  }
}
</script>
