<style>
  .person {
    margin-bottom: 0;
    margin-right: 18px;
    font-size: 20px;
    color: black;
  }

  .person:hover {
    margin-bottom: 0;
    margin-right: 18px;
    cursor: pointer;
    color: white;
  }
</style>

<template>
    <div style="display: flex;line-height: 60px">
        <div style="margin-top: 8px;">
            <i class="el-icon-s-fold" style="font-size: 20px"></i>
        </div>
        <div style="flex: 1;text-align: center;font-size: 34px;">
            <span>欢迎使用就业服务系统</span>
        </div>

      <el-dropdown trigger="click">
        <p class="person" v-text="userName"></p>
        <el-dropdown-menu>
          <el-dropdown-item icon="el-icon-user-solid" @click.native="toPersonal">个人中心</el-dropdown-item>
          <el-dropdown-item icon="el-icon-s-home" @click.native="toHome">退出登录</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
</template>

<script>
export default {
  beforeMount() {
    this.userName = JSON.parse(localStorage.getItem("user")).user.userName
  },
  mounted() {
    if(this.userName == 'Loading'){
      location.reload()
    }
  },
    data() {
        return {
          input: '',
          userName: 'Loading'
        }
    },
    methods:{
      /**
       * 退出登录
       */
      toHome(){
        this.$router.push('/')

        //移除用户登录持久化信息
        localStorage.removeItem("user");
      },

      /**
       * 个人中心
       */
      toPersonal() {
        this.$router.push('/personal_xs')
      }
    }
}
</script>