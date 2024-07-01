<script>
export default {
  data() {
    return {
      /**
       * 用户数据列表
       */
      userList: [{
        userId: 0,
        userName: '',
        userPassword: '',
        userIdentity: '',
      }],
    }
  },

  methods: {
    query_all() {
      /**
       * 从数据库中读取所有用户
       */
      this.$axios.get('http://localhost:8081/user/query_all').then(res=>{
        for(let i = 0; i < res.data.length; i++) {
          this.userList[i] = {
            userId: res.data[i].userId,
            userName: res.data[i].userName,
            userPassword: res.data[i].userPassword,
            userIdentity: res.data[i].userIdentity,
          }
        }
      })
    },
  }
}
</script>