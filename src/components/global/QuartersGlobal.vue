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

      /**
       * 职位类型集合
       */
      quarters: {
        quartersId: 0,
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      },

      /**
       * 职位id用于查询
       */
      quartersId: '',
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
    },

    query_by_quarters_id() {
      /**
       * 根据quartersId从数据库中读取职位信息
       */
      this.$axios.get('http://localhost:8081/quarters/query_by_quarters_id?quartersId=' + this.quartersId).then(res=>{
        this.quarters = {
          quartersId: res.data.quartersId,
          quartersFirst: res.data.quartersFirst,
          quartersSecond: res.data.quartersSecond,
          quartersThird: res.data.quartersThird,
        }
      })
    },

    add() {
      this.$axios.post('http://localhost:8081/quarters/add', this.quarters).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "添加OK") {
          this.$message({message: '添加成功', type: 'success'})
        } else {
          this.$message({message: '添加失败', type: 'warning'})
        }
      })
    }

  }
}
</script>
