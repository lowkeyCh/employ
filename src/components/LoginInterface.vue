<style>
  .center {
      width: 1490px;
      height: 720px;
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
  }

  h1 {
      font-size: 30px;
      color: #ecd6d6;
  }

  .logon {
      background-color: transparent!important;
      border-radius: 10px;
      box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25), 0 10px 10px rgba(0, 0, 0, 0.22);
      /* position: relative;
      overflow: hidden; */
      width: 768px;
      max-width: 100%;
      min-height: 480px;
      margin-top: 20px;
      display: flex;
  }

  .overlaylong {
      border-radius: 10px 0 0 10px;
      width: 50%;
      height: 100%;
      background-color: #fff;
      display: flex;
      align-items: center;
      justify-content: center;
  }

  .overlaylongleft {
      border-radius: 0px 10px 10px 0px;
      width: 50%;
      height: 100%;
      background-color: #fff;
      transform: translateX(100%);
      transition: transform 0.6s ease-in-out;
      display: flex;
      align-items: center;
      justify-content: center;
  }

  .overlaylongright {
      border-radius: 10px 0 0 10px;
      width: 50%;
      height: 100%;
      background-color: #fff;
      transform: translateX(0%);
      transition: transform 0.6s ease-in-out;
      display: flex;
      align-items: center;
      justify-content: center;
  }

  .overlaytitle {
      border-radius: 0px 10px 10px 0px;
      width: 50%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0);
      display: flex;
      align-items: center;
      justify-content: center;
  }


  .overlaytitleH2 {
      font-size: 30px;
      color: #fff;
      margin-top: 20px;
  }

  .overlaytitleP {
      font-size: 15px;
      color: #fff;
      margin-top: 20px;
  }

  .overlaytitleleft {
      border-radius: 0px 10px 10px 0px;
      width: 50%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0);
      display: flex;
      align-items: center;
      justify-content: center;
      transform: translateX(0%);
      transition: transform 0.6s ease-in-out;
  }

  .overlaytitleright {
      border-radius: 0px 10px 10px 0px;
      width: 50%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0);
      display: flex;
      align-items: center;
      justify-content: center;
      transform: translateX(-100%);
      transition: transform 0.6s ease-in-out;
  }

  .overlaytitle-Signin {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
  }

  .overlaytitle-Signup {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
  }

  .buttongohs {
      width: 180px;
      height: 40px;
      border-radius: 50px;
      border: 1px solid #fff;
      color: #fff;
      font-size: 15px;
      text-align: center;
      line-height: 40px;
      margin-top: 40px;
  }

  .buttongohs:hover {
    cursor: pointer;
    width: 180px;
    height: 40px;
    border-radius: 50px;
    border: 1px solid #000;
    color: #000;
    font-size: 15px;
    text-align: center;
    line-height: 40px;
    margin-top: 40px;
  }

  .overlaylongH2 {
      font-size: 25px;
      color: black;
      /* width: 250px; */
  }

  .overlaylong-Signin {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
  }

  .overlaylong-Signup {
      display: flex;
      align-items: center;
      justify-content: center;
      flex-direction: column;
  }

  input {
      background-color: #eee;
      border: none;
      padding: 12px 15px;
      margin: 10px 0;
      width: 240px;
  }

  h3{
      font-size: 10px;
      margin-top: 10px;
      cursor: pointer;
  }

  .inupbutton{
      background-color: #4f4e4e;
      border: none;
      width: 180px;
      height: 40px;
      border-radius: 50px;
      font-size: 15px;
      color: #f3eded;
      text-align: center;
      line-height: 40px;
      margin-top: 30px;
  }

  .inupbutton:hover{
    cursor: pointer;
    background-color: #4f4e4e;
    border: 2px solid #000;
    width: 180px;
    height: 40px;
    border-radius: 50px;
    font-size: 15px;
    color: #000;
    text-align: center;
    line-height: 40px;
    margin-top: 30px;
  }
</style>

<template>
    <div ref="vantaRef" style="width: 100%;height: 100vh">
    <div class="center">
        <h1>欢迎使用就业服务信息系统</h1>
        <div class="logon">
            <div :class="overlaylong">
                <div class="overlaylong-Signin" v-if="disfiex == 0">
                    <h2 class="overlaylongH2">登录</h2>
                    <input type="text" placeholder="账号" v-model="login.userName">
                    <input type="password" placeholder="密码" v-model="login.userPassword">
                    <el-radio-group v-model="login.userIdentity">
                        <el-radio :label="3">管理员</el-radio>
                        <el-radio :label="6">企业</el-radio>
                        <el-radio :label="9">学生</el-radio>
                    </el-radio-group>
                    <button class="inupbutton" @click="handle">登录</button>
                </div>
                <div class="overlaylong-Signup" v-if="disfiex == 1">
                    <h2 class="overlaylongH2">注册</h2>
                    <input type="text" placeholder="账号" v-model="logup.userName">
                    <input type="text" placeholder="密码" v-model="logup.userPassword">
                    <el-radio-group v-model="logup.userIdentity">
                        <el-radio :label="6">企业</el-radio>
                        <el-radio :label="9">学生</el-radio>
                    </el-radio-group>
                    <button class="inupbutton" @click="register">注册</button>
                </div>

            </div>
            <div :class="overlaytitle">
                <div class="overlaytitle-Signin" v-if="disfiex == 0">
                    <h2 class="overlaytitleH2">欢迎使用本系统</h2>
                    <p class="overlaytitleP">
                        输入账号信息并登入
                    </p>
                    <div class="buttongohs" @click="Signin">转去注册</div>
                </div>
                <div class="overlaytitle-Signup" v-if="disfiex == 1">
                    <h2 class="overlaytitleH2">初次使用</h2>
                    <p class="overlaytitleP">请填入你的账号信息并注册</p>
                    <div class="buttongohs" @click="Signup">转去登陆</div>
                </div>
            </div>
        </div>
    </div>
    </div>
</template>

<script>
  import * as THREE from 'three'
  import Waves from 'vanta/src/vanta.waves';
  import { useUserStore } from '@/store/user'

  export default {
    provide() {

    },
    beforeMount() {
      //用户登录信息持久化处理 sessionStorage中如果有登录信息则直接跳转
      let userInfo = JSON.parse(localStorage.getItem("user"))
      if(userInfo != null) {
        //跳转到对应的界面去
        if(userInfo.user.userIdentity != null) {
          this.$router.push('/ManagerIndex')
        } else if(userInfo.user.userIdentity == "企业") {
          this.$router.push('/EnterpriseIndex');
        } else if(userInfo.user.userIdentity == "学生") {
          this.$router.push('/GraduateIndex');
        }
      }
    },
    mounted() {
      this.vantaEffect = Waves({
          el:this.$refs.vantaRef,
          THREE:THREE
      })
      VANTA.WAVES({
          el: this.$refs.vantaRef,
          mouseControls: true,
          touchControls: true,
          gyroControls: false,
          minHeight: 200.00,
          minWidth: 200.00,
          scale: 1.00,
          scaleMobile: 1.00,
          color: 0x282e36
      })
    },
    beforeDestroy() {
      if(this.vantaEffect){
          this.vantaEffect.destroy()
      }
    },
    data() {
      return {
        overlaylong: 'overlaylong',
        overlaytitle: 'overlaytitle',
        disfiex: 0,
        radio: 3,   //身份变量 3表示管理员 6表示企业 9表示学生

        login : {   //用户登录信息
          userName: '',
          userPassword: '',
          userIdentity: '',
        },
        logup : {   //用户注册信息
          userName: '',
          userPassword: '',
          userIdentity: '',
        }
      }
    },
    methods: {
      Signin() {
        this.overlaylong = "overlaylongleft"
        this.overlaytitle = "overlaytitleright"
        setTimeout(() => {
            this.disfiex = 1
        }, 200)
      },
      Signup() {
        this.overlaylong = "overlaylongright"
        this.overlaytitle = "overlaytitleleft"
        setTimeout(() => {
            this.disfiex = 0
        }, 200)
      },

      /**
       * 系统登录函数
       */
      handle() {
        //为userIdentity转换真实身份
        if(this.login.userIdentity == 3) {
          this.login.userIdentity = "管理员"
        } else if(this.login.userIdentity == 6) {
          this.login.userIdentity = "企业"
        } else if(this.login.userIdentity == 9) {
          this.login.userIdentity = "学生"
        }

        this.$axios.post('http://localhost:8081/user/login', this.login).then(res=>{
          //登陆成功与登陆失败
          if(res.data != null) {
            this.$message({ message: '登录成功', type: 'success'})

            //存储用户信息 登录信息 持久化处理
            const store = new useUserStore()
            store.setUser(this.login)

            //跳转到对应的界面去
            if(this.login.userIdentity == "管理员") {
              this.$router.push('/ManagerIndex')
            } else if(this.login.userIdentity == "企业") {
              this.$router.push('/EnterpriseIndex');
            } else if(this.login.userIdentity == "学生") {
              this.$router.push('/GraduateIndex');
            }
          } else {
            this.$message({ message: '账号密码身份错误', type: 'warning'})
          }
        })
      },

      /**
       * 系统注册函数
       */
      register() {
        //为userIdentity转换真实身份
        if(this.logup.userIdentity == 6) {
          this.logup.userIdentity = "企业"
        } else if(this.logup.userIdentity == 9) {
          this.logup.userIdentity = "学生"
        }

        this.$axios.post('http://localhost:8081/user/register', this.logup).then(res=>{
          //判断是否添加成功并返回对应信息
          if(res.data == "添加OK") {
            this.$message({ message: '注册成功', type: 'success'})

            //存储用户信息 登录信息 持久化处理
            const store = new useUserStore()
            store.setUser(this.logup)

            //跳转到对应的界面去
            if(this.logup.userIdentity == "企业") {
              this.$router.push('/EnterpriseIndex');
            } else if(this.logup.userIdentity == "学生") {
              this.$router.push('/GraduateIndex');
            }
          }
        })
      },



    }
  }
</script>
