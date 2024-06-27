<script>
export default {
  data() {
    return {
      /**
       * 企业用人资格信息
       */
      enterpriseQualificationsList: [{
        enterpriseId: 0,
        eqId: 0,
        eqIndex: '',
      }],

      /**
       * 企业id用于查询
       */
      enterpriseId: 0,
    }
  },

  methods: {
    query_by_enterprise_id() {
      /**
       * 根据企业id获取企业用人资料相关信息
       */
      this.$axios.get('http://localhost:8081/eq/query_by_enterprise_id?enterpriseId='+ this.enterpriseId).then(res2=>{
        for(let j = 0; j < res2.data.length; j++) {
          this.enterpriseQualificationsList[j] = {
            enterpriseId: res2.data[j].enterpriseId,
            eqId: res2.data[j].eqId,
            eqIndex: res2.data[j].eqIndex,
          }

          /**
           * 为tableDataList赋值展示数据
           */
          this.tableDataList[i].eqIndexs[j] = "http://localhost:8081/" + this.enterpriseQualifications[i][j].eqIndex
        }
      })
    }
  },
}
</script>