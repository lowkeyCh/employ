<script>
export default {
  data() {
    return {
      /**
       * 职位类型集合
       */
      quartersList:[{
        quartersId: 0,
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      }],
    }
  },

  methods: {
    query_all() {
      /**
       * 从数据库中读取所有职位
       */
      this.$axios.get('http://localhost:8081/quarters/query_all').then(res=>{
        for(let i = 0; i < res.data.length; i++) {
          this.quartersList[i] = {
            quartersId: res.data[i].quartersId,
            quartersFirst: res.data[i].quartersFirst,
            quartersSecond: res.data[i].quartersSecond,
            quartersThird: res.data[i].quartersThird,
          }
        }
      })
    }
  }
}
</script>
