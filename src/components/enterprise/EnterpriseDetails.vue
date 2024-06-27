<script>
  export default {
    /**
     * 挂载时获取user信息并以此获取对应user的enterprise信息
     */
    mounted() {
      /**
       * 获取用户id并根据用户id获取企业基本信息
       */
      let userId = JSON.parse(localStorage.getItem("user")).user.userId

      this.$axios.get('http://localhost:8081/enterprise/query?userId='+ userId).then(res=>{
        this.enterprise.enterpriseId = res.data.enterpriseId
        this.enterprise.enterpriseName = res.data.enterpriseName
        this.enterprise.enterpriseRegistrationPlace = res.data.enterpriseRegistrationPlace
        this.enterprise.enterpriseRegisteredCapital = res.data.enterpriseRegisteredCapital
        this.enterprise.enterpriseLegalRepresentative = res.data.enterpriseLegalRepresentative
        this.enterprise.enterpriseFoundingDate = res.data.enterpriseFoundingDate
        this.enterprise.enterpriseEmail = res.data.enterpriseEmail
        this.enterprise.enterpriseCoreBusiness = res.data.enterpriseCoreBusiness
        this.enterprise.userId = res.data.userId
        this.enterprise.enterpriseQualificationsCheck = res.data.enterpriseQualificationsCheck

        this.enterpriseModify.enterpriseId = res.data.enterpriseId
        this.enterpriseModify.enterpriseName = res.data.enterpriseName
        this.enterpriseModify.enterpriseRegistrationPlace = res.data.enterpriseRegistrationPlace
        this.enterpriseModify.enterpriseRegisteredCapital = res.data.enterpriseRegisteredCapital
        this.enterpriseModify.enterpriseLegalRepresentative = res.data.enterpriseLegalRepresentative
        this.enterpriseModify.enterpriseFoundingDate = res.data.enterpriseFoundingDate
        this.enterpriseModify.enterpriseEmail = res.data.enterpriseEmail
        this.enterpriseModify.enterpriseCoreBusiness = res.data.enterpriseCoreBusiness
        this.enterpriseModify.userId = res.data.userId
        this.enterpriseModify.enterpriseQualificationsCheck = res.data.enterpriseQualificationsCheck
      })
    },

    data () {
      return {
        /**
         * 页面展示数据 用于信息界面与修改界面的切换
         */
        show: {
          showCard: true,
          modifyCard: false,
        },

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
         * 修改企业基本信息
         */
        enterpriseModify: {
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
        }
      }
    },

    methods: {
      /**
       * 控制修改卡片的显示与信息卡片的消失
       */
      modify() {
        this.show.showCard = false
        this.show.modifyCard = true
      },

      /**
       * 回退到信息卡片 同时重置enterpriseModify的值
       */
      modifyBack() {
        this.show.showCard = true
        this.show.modifyCard = false

        this.enterpriseModify.enterpriseId                     =  this.enterprise.enterpriseId
        this.enterpriseModify.enterpriseName                   =  this.enterprise.enterpriseName
        this.enterpriseModify.enterpriseRegistrationPlace      =  this.enterprise.enterpriseRegistrationPlace
        this.enterpriseModify.enterpriseRegisteredCapital      =  this.enterprise.enterpriseRegisteredCapital
        this.enterpriseModify.enterpriseLegalRepresentative    =  this.enterprise.enterpriseLegalRepresentative
        this.enterpriseModify.enterpriseFoundingDate           =  this.enterprise.enterpriseFoundingDate
        this.enterpriseModify.enterpriseEmail                  =  this.enterprise.enterpriseEmail
        this.enterpriseModify.enterpriseCoreBusiness           =  this.enterprise.enterpriseCoreBusiness
        this.enterpriseModify.userId                           =  this.enterprise.userId
        this.enterpriseModify.enterpriseQualificationsCheck    =  this.enterprise.enterpriseQualificationsCheck
      },

      /**
       * 回到信息卡片
       * 保存修改的信息 同时更新enterprise
       */
      modifySave() {
        this.show.showCard = true
        this.show.modifyCard = false

        this.$axios.post('http://localhost:8081/enterprise/modify', this.enterpriseModify).then(res=>{
          this.$message({ message: '修改成功', type: 'success'})

          this.enterprise.enterpriseId                     =  this.enterpriseModify.enterpriseId
          this.enterprise.enterpriseName                   =  this.enterpriseModify.enterpriseName
          this.enterprise.enterpriseRegistrationPlace      =  this.enterpriseModify.enterpriseRegistrationPlace
          this.enterprise.enterpriseRegisteredCapital      =  this.enterpriseModify.enterpriseRegisteredCapital
          this.enterprise.enterpriseLegalRepresentative    =  this.enterpriseModify.enterpriseLegalRepresentative
          this.enterprise.enterpriseFoundingDate           =  this.enterpriseModify.enterpriseFoundingDate
          this.enterprise.enterpriseEmail                  =  this.enterpriseModify.enterpriseEmail
          this.enterprise.enterpriseCoreBusiness           =  this.enterpriseModify.enterpriseCoreBusiness
          this.enterprise.userId                           =  this.enterpriseModify.userId
          this.enterprise.enterpriseQualificationsCheck    =  this.enterpriseModify.enterpriseQualificationsCheck
        })
      }
    }
  }
</script>

<template>
  <div>
    <el-card v-show="show.showCard">
      <el-descriptions class="margin-top" title="企业基本信息" :column="2" border>
        <template slot="extra">
          <el-button class="button" type="primary"  size="medium" @click="modify">修改资料</el-button>
        </template>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803314989" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4275" width="32" height="32"><path d="M912 912H112v-55h68V132a20 20 0 0 1 20-20h389a20 20 0 0 1 20 20v290h215a20 20 0 0 1 20 20v415h68v55zM507 213a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 179a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m285-264a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 130a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 147a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z" fill="#49D2FE" p-id="4276"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业名称</label>
          </template>
          <label class="show">{{ enterprise.enterpriseName }}</label>
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803441496" class="icon" viewBox="0 0 1170 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5526" width="32" height="32"><path d="M0.804571 1001.033143l104.594286-182.418286 269.165714-34.889143-49.883428 217.307429H0.804571zM785.554286 662.966857l-24.868572-93.842286h122.002286l42.422857 77.750858-139.556571 16.091428z m176.859428 59.026286l159.451429 279.04h-490.788572l-7.460571-236.105143 338.797714-42.934857z m-259.072-144.822857l-19.968 26.843428c-52.297143 61.659429-92.16 120.685714-117.028571 177.005715-24.868571 56.32-47.323429 128.731429-67.291429 222.72-19.894857-93.915429-42.349714-166.326857-67.291428-222.72-12.434286-29.476571-29.842286-53.613714-44.836572-80.457143l-94.646857-120.685715-2.486857-2.706285c-67.291429-83.163429-102.107429-163.693714-102.107429-246.857143 0-91.209143 27.355429-166.326857 89.673143-233.325714C339.602286 32.475429 411.794286 0.292571 496.566857 0.292571s156.964571 29.476571 219.209143 96.548572c59.830857 64.365714 89.673143 142.189714 89.673143 233.398857 0 83.163429-34.889143 163.693714-102.107429 246.857143zM494.08 499.346286c89.673143 0 164.425143-80.457143 164.425143-177.005715 0-96.621714-74.752-177.152-164.425143-177.152-89.673143 0-164.425143 80.457143-164.425143 177.078858 0 96.548571 74.752 177.078857 164.425143 177.078857z m-356.205714 236.105143l84.699428-144.822858L317.220571 713.874286l-179.346285 21.504z" fill="#C0C4CC" p-id="5527"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业注册地</label>
          </template>
          {{ enterprise.enterpriseRegistrationPlace }}
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803513777" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6613" width="32" height="32"><path d="M670.1056 498.0224l68.8128-68.7616 103.2192-103.2192L910.848 394.752l-103.2192 103.2192 103.2192 103.2192-68.7616 68.864-103.2704-103.2192-68.7616-68.864z m172.032-196.608h-98.304v-49.152h-491.52v491.52h491.52v-49.152h98.304v147.456H154.0096V154.0096h688.128v147.456z m-294.912 196.608h98.304v98.304h-98.304v98.304h-98.304v-98.304h-98.304v-98.304h98.304v-29.44l-98.304-98.304L419.328 301.4144l78.6432 78.6944 73.728-78.6944 68.864 68.864-93.44 98.304v29.44z" fill="#3163F6" p-id="6614"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 注册资本</label>
          </template>
          {{ enterprise.enterpriseRegisteredCapital }}
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803656258" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7640" width="32" height="32"><path d="M511.726 0A511.726 511.726 0 1 1 0 511.726 511.726 511.726 0 0 1 511.726 0z" fill="#FCAE40" p-id="7641"></path><path d="M712.253 801.558H311.747a89.306 89.306 0 0 1-89.305-89.305V356.126a89.306 89.306 0 0 1 89.305-89.305h400.506a89.306 89.306 0 0 1 89.305 89.305v356.127a89.306 89.306 0 0 1-89.305 89.305zM422.968 356.126a68.486 68.486 0 1 0 70.13 68.486 69.034 69.034 0 0 0-70.13-68.486z m59.72 164.366h-119.44a95.88 95.88 0 1 0 0 192.308h119.44a95.88 95.88 0 0 0 0-192.308z m273.943-75.06H623.495v44.379h133.684v-44.927z m0 89.305H623.495v44.38h133.684v-44.928z m0 88.758H623.495v44.379h133.684v-44.38z" fill="#FFFFFF" p-id="7642"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 法定代表人</label>
          </template>
          {{ enterprise.enterpriseLegalRepresentative }}
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803724145" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8694" width="32" height="32"><path d="M826.3 805.5H200.1c-35.1 0-63.6-28.5-63.6-63.6V287.3c0-35.1 28.5-63.6 63.6-63.6h626.2c35.1 0 63.6 28.5 63.6 63.6V742c-0.1 35-28.6 63.5-63.6 63.5zM200.1 258.7c-15.8 0-28.6 12.8-28.6 28.6V742c0 15.8 12.8 28.6 28.6 28.6h626.2c15.8 0 28.6-12.8 28.6-28.6V287.3c0-15.8-12.8-28.6-28.6-28.6H200.1z" p-id="8695"></path><path d="M701.3 293.1h-16.5c-6.2 0-11.3-5.1-11.3-11.3v-85.9c0-6.2 5.1-11.3 11.3-11.3h16.5c6.2 0 11.3 5.1 11.3 11.3v85.9c0 6.2-5.1 11.3-11.3 11.3zM340.2 293.1h-16.5c-6.2 0-11.3-5.1-11.3-11.3v-85.9c0-6.2 5.1-11.3 11.3-11.3h16.5c6.2 0 11.3 5.1 11.3 11.3v85.9c0 6.2-5.1 11.3-11.3 11.3zM152.1 363.4h718.7v30H152.1zM247.2 442.7h133.3v53.4H247.2zM446.5 442.7h133.3v53.4H446.5zM645.9 442.7h133.3v53.4H645.9z" p-id="8696"></path><path d="M247.2 545.1h133.3v53.4H247.2zM446.5 545.1h133.3v53.4H446.5zM645.9 545.1h133.3v53.4H645.9z" p-id="8697"></path><path d="M247.2 647.5h133.3v53.4H247.2zM446.5 647.5h133.3v53.4H446.5zM645.9 647.5h133.3v53.4H645.9z" p-id="8698"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 注册日期</label>
          </template>
          {{ enterprise.enterpriseFoundingDate }}
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718477453809" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="12332" width="32" height="32"><path d="M838.954667 234.666667H170.666667c-3.626667 0-7.168 0.448-10.56 1.322666l323.690666 323.669334a21.333333 21.333333 0 0 0 30.165334 0L838.954667 234.666667z m46.144 14.186666l-260.693334 260.693334 262.933334 262.912c5.44-7.168 8.661333-16.106667 8.661333-25.792V277.333333c0-10.944-4.117333-20.906667-10.88-28.48zM843.861333 789.333333l-249.6-249.621333-50.133333 50.133333a64 64 0 0 1-90.517333 0l-50.112-50.133333L156.373333 786.88c4.48 1.578667 9.28 2.453333 14.314667 2.453333h673.194667zM128.661333 754.218667L373.333333 509.525333 129.578667 265.813333A42.709333 42.709333 0 0 0 128 277.333333v469.333334c0 2.56 0.213333 5.098667 0.661333 7.552zM170.666667 192h682.666666a85.333333 85.333333 0 0 1 85.333334 85.333333v469.333334a85.333333 85.333333 0 0 1-85.333334 85.333333H170.666667a85.333333 85.333333 0 0 1-85.333334-85.333333V277.333333a85.333333 85.333333 0 0 1 85.333334-85.333333z" fill="#333333" p-id="12333"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业邮箱地址</label>
          </template>
          {{ enterprise.enterpriseEmail }}
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803851173" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10632" width="32" height="32"><path d="M863.616 32a32 32 0 0 1 32 32v509.056l-12.8-28.16a83.84 83.84 0 0 0-73.216-49.088h-3.648l-3.648 0.064a83.84 83.84 0 0 0-72.64 50.048l-38.272 87.04-91.328 12.8c-23.168 3.2-43.52 15.872-56.64 34.368a64 64 0 1 0 7.424 106.24c0.64 0.896 1.536 1.792 2.432 2.624l70.144 68.096-17.28 98.112c-2.112 12.288-1.472 24.768 1.664 36.416L160 991.552a32 32 0 0 1-32-32V64a32 32 0 0 1 32-32h703.616zM806.4 559.744c7.808 0 14.976 4.48 18.24 11.648l54.208 118.976 16.768 2.112v267.072a32 32 0 0 1-1.92 10.88l-84.864-48.192-109.888 64.64a19.84 19.84 0 0 1-29.696-20.672l23.04-131.456L597.76 743.04a19.84 19.84 0 0 1 11.136-33.984l126.72-17.664 52.672-119.808a19.84 19.84 0 0 1 18.112-11.904z m-54.72-143.936H272a16 16 0 0 0-15.552 12.352l-0.448 3.648v64c0 7.36 5.12 13.824 12.352 15.488l3.648 0.448h479.744a16 16 0 0 0 15.552-12.352l0.448-3.648v-64a16 16 0 0 0-16-15.936z m0-223.872H272a16 16 0 0 0-15.552 12.352l-0.448 3.648v64c0 7.36 5.12 13.824 12.352 15.488l3.648 0.448h479.744a16 16 0 0 0 15.552-12.352l0.448-3.648v-64a16 16 0 0 0-16-16z" fill="#707A89" p-id="10633"></path><path d="M919.616 985.152l-110.784-62.912-109.888 64.64a19.84 19.84 0 0 1-29.696-20.672l23.04-131.456L597.76 743.04a19.84 19.84 0 0 1 11.136-33.984l126.72-17.664 52.672-119.808a19.84 19.84 0 0 1 36.352-0.256l54.208 118.976 126.848 15.872a19.84 19.84 0 0 1 11.648 33.792l-93.248 93.056 24.96 131.072a19.84 19.84 0 0 1-29.44 20.992z" fill="#FF9800" p-id="10634"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业核心业务</label>
          </template>
          {{ enterprise.enterpriseCoreBusiness }}
        </el-descriptions-item>

      </el-descriptions>
    </el-card>

    <el-card v-show="show.modifyCard">
      <el-descriptions class="margin-top" title="毕业生基本资料" :column="2" border>
        <template slot="extra">
          <el-button class="button" type="danger"  size="medium" @click="modifyBack">取消更改</el-button>
        </template>
        <template slot="extra">
          <el-button class="button" type="success"  size="medium" @click="modifySave">保存更改</el-button>
        </template>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803314989" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4275" width="32" height="32"><path d="M912 912H112v-55h68V132a20 20 0 0 1 20-20h389a20 20 0 0 1 20 20v290h215a20 20 0 0 1 20 20v415h68v55zM507 213a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 179a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m285-264a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 130a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 147a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z" fill="#49D2FE" p-id="4276"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业名称</label>
          </template>
          <input class="input" type="text" v-model="enterpriseModify.enterpriseName">
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803441496" class="icon" viewBox="0 0 1170 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5526" width="32" height="32"><path d="M0.804571 1001.033143l104.594286-182.418286 269.165714-34.889143-49.883428 217.307429H0.804571zM785.554286 662.966857l-24.868572-93.842286h122.002286l42.422857 77.750858-139.556571 16.091428z m176.859428 59.026286l159.451429 279.04h-490.788572l-7.460571-236.105143 338.797714-42.934857z m-259.072-144.822857l-19.968 26.843428c-52.297143 61.659429-92.16 120.685714-117.028571 177.005715-24.868571 56.32-47.323429 128.731429-67.291429 222.72-19.894857-93.915429-42.349714-166.326857-67.291428-222.72-12.434286-29.476571-29.842286-53.613714-44.836572-80.457143l-94.646857-120.685715-2.486857-2.706285c-67.291429-83.163429-102.107429-163.693714-102.107429-246.857143 0-91.209143 27.355429-166.326857 89.673143-233.325714C339.602286 32.475429 411.794286 0.292571 496.566857 0.292571s156.964571 29.476571 219.209143 96.548572c59.830857 64.365714 89.673143 142.189714 89.673143 233.398857 0 83.163429-34.889143 163.693714-102.107429 246.857143zM494.08 499.346286c89.673143 0 164.425143-80.457143 164.425143-177.005715 0-96.621714-74.752-177.152-164.425143-177.152-89.673143 0-164.425143 80.457143-164.425143 177.078858 0 96.548571 74.752 177.078857 164.425143 177.078857z m-356.205714 236.105143l84.699428-144.822858L317.220571 713.874286l-179.346285 21.504z" fill="#C0C4CC" p-id="5527"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业注册地</label>
          </template>
          <input class="input" type="text" v-model="enterpriseModify.enterpriseRegistrationPlace">
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803513777" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6613" width="32" height="32"><path d="M670.1056 498.0224l68.8128-68.7616 103.2192-103.2192L910.848 394.752l-103.2192 103.2192 103.2192 103.2192-68.7616 68.864-103.2704-103.2192-68.7616-68.864z m172.032-196.608h-98.304v-49.152h-491.52v491.52h491.52v-49.152h98.304v147.456H154.0096V154.0096h688.128v147.456z m-294.912 196.608h98.304v98.304h-98.304v98.304h-98.304v-98.304h-98.304v-98.304h98.304v-29.44l-98.304-98.304L419.328 301.4144l78.6432 78.6944 73.728-78.6944 68.864 68.864-93.44 98.304v29.44z" fill="#3163F6" p-id="6614"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 注册资本</label>
          </template>
          <input class="input" type="text" v-model="enterpriseModify.enterpriseRegisteredCapital">
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803656258" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7640" width="32" height="32"><path d="M511.726 0A511.726 511.726 0 1 1 0 511.726 511.726 511.726 0 0 1 511.726 0z" fill="#FCAE40" p-id="7641"></path><path d="M712.253 801.558H311.747a89.306 89.306 0 0 1-89.305-89.305V356.126a89.306 89.306 0 0 1 89.305-89.305h400.506a89.306 89.306 0 0 1 89.305 89.305v356.127a89.306 89.306 0 0 1-89.305 89.305zM422.968 356.126a68.486 68.486 0 1 0 70.13 68.486 69.034 69.034 0 0 0-70.13-68.486z m59.72 164.366h-119.44a95.88 95.88 0 1 0 0 192.308h119.44a95.88 95.88 0 0 0 0-192.308z m273.943-75.06H623.495v44.379h133.684v-44.927z m0 89.305H623.495v44.38h133.684v-44.928z m0 88.758H623.495v44.379h133.684v-44.38z" fill="#FFFFFF" p-id="7642"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 法定代表人</label>
          </template>
          <input class="input" type="text" v-model="enterpriseModify.enterpriseLegalRepresentative">
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803724145" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8694" width="32" height="32"><path d="M826.3 805.5H200.1c-35.1 0-63.6-28.5-63.6-63.6V287.3c0-35.1 28.5-63.6 63.6-63.6h626.2c35.1 0 63.6 28.5 63.6 63.6V742c-0.1 35-28.6 63.5-63.6 63.5zM200.1 258.7c-15.8 0-28.6 12.8-28.6 28.6V742c0 15.8 12.8 28.6 28.6 28.6h626.2c15.8 0 28.6-12.8 28.6-28.6V287.3c0-15.8-12.8-28.6-28.6-28.6H200.1z" p-id="8695"></path><path d="M701.3 293.1h-16.5c-6.2 0-11.3-5.1-11.3-11.3v-85.9c0-6.2 5.1-11.3 11.3-11.3h16.5c6.2 0 11.3 5.1 11.3 11.3v85.9c0 6.2-5.1 11.3-11.3 11.3zM340.2 293.1h-16.5c-6.2 0-11.3-5.1-11.3-11.3v-85.9c0-6.2 5.1-11.3 11.3-11.3h16.5c6.2 0 11.3 5.1 11.3 11.3v85.9c0 6.2-5.1 11.3-11.3 11.3zM152.1 363.4h718.7v30H152.1zM247.2 442.7h133.3v53.4H247.2zM446.5 442.7h133.3v53.4H446.5zM645.9 442.7h133.3v53.4H645.9z" p-id="8696"></path><path d="M247.2 545.1h133.3v53.4H247.2zM446.5 545.1h133.3v53.4H446.5zM645.9 545.1h133.3v53.4H645.9z" p-id="8697"></path><path d="M247.2 647.5h133.3v53.4H247.2zM446.5 647.5h133.3v53.4H446.5zM645.9 647.5h133.3v53.4H645.9z" p-id="8698"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 注册日期</label>
          </template>
          <input class="input" type="date" v-model="enterpriseModify.enterpriseFoundingDate">
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718477453809" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="12332" width="32" height="32"><path d="M838.954667 234.666667H170.666667c-3.626667 0-7.168 0.448-10.56 1.322666l323.690666 323.669334a21.333333 21.333333 0 0 0 30.165334 0L838.954667 234.666667z m46.144 14.186666l-260.693334 260.693334 262.933334 262.912c5.44-7.168 8.661333-16.106667 8.661333-25.792V277.333333c0-10.944-4.117333-20.906667-10.88-28.48zM843.861333 789.333333l-249.6-249.621333-50.133333 50.133333a64 64 0 0 1-90.517333 0l-50.112-50.133333L156.373333 786.88c4.48 1.578667 9.28 2.453333 14.314667 2.453333h673.194667zM128.661333 754.218667L373.333333 509.525333 129.578667 265.813333A42.709333 42.709333 0 0 0 128 277.333333v469.333334c0 2.56 0.213333 5.098667 0.661333 7.552zM170.666667 192h682.666666a85.333333 85.333333 0 0 1 85.333334 85.333333v469.333334a85.333333 85.333333 0 0 1-85.333334 85.333333H170.666667a85.333333 85.333333 0 0 1-85.333334-85.333333V277.333333a85.333333 85.333333 0 0 1 85.333334-85.333333z" fill="#333333" p-id="12333"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业邮箱地址</label>
          </template>
          <input class="input" type="text" v-model="enterpriseModify.enterpriseEmail">
        </el-descriptions-item>


        <el-descriptions-item>
          <template slot="label">
            <svg t="1718803851173" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10632" width="32" height="32"><path d="M863.616 32a32 32 0 0 1 32 32v509.056l-12.8-28.16a83.84 83.84 0 0 0-73.216-49.088h-3.648l-3.648 0.064a83.84 83.84 0 0 0-72.64 50.048l-38.272 87.04-91.328 12.8c-23.168 3.2-43.52 15.872-56.64 34.368a64 64 0 1 0 7.424 106.24c0.64 0.896 1.536 1.792 2.432 2.624l70.144 68.096-17.28 98.112c-2.112 12.288-1.472 24.768 1.664 36.416L160 991.552a32 32 0 0 1-32-32V64a32 32 0 0 1 32-32h703.616zM806.4 559.744c7.808 0 14.976 4.48 18.24 11.648l54.208 118.976 16.768 2.112v267.072a32 32 0 0 1-1.92 10.88l-84.864-48.192-109.888 64.64a19.84 19.84 0 0 1-29.696-20.672l23.04-131.456L597.76 743.04a19.84 19.84 0 0 1 11.136-33.984l126.72-17.664 52.672-119.808a19.84 19.84 0 0 1 18.112-11.904z m-54.72-143.936H272a16 16 0 0 0-15.552 12.352l-0.448 3.648v64c0 7.36 5.12 13.824 12.352 15.488l3.648 0.448h479.744a16 16 0 0 0 15.552-12.352l0.448-3.648v-64a16 16 0 0 0-16-15.936z m0-223.872H272a16 16 0 0 0-15.552 12.352l-0.448 3.648v64c0 7.36 5.12 13.824 12.352 15.488l3.648 0.448h479.744a16 16 0 0 0 15.552-12.352l0.448-3.648v-64a16 16 0 0 0-16-16z" fill="#707A89" p-id="10633"></path><path d="M919.616 985.152l-110.784-62.912-109.888 64.64a19.84 19.84 0 0 1-29.696-20.672l23.04-131.456L597.76 743.04a19.84 19.84 0 0 1 11.136-33.984l126.72-17.664 52.672-119.808a19.84 19.84 0 0 1 36.352-0.256l54.208 118.976 126.848 15.872a19.84 19.84 0 0 1 11.648 33.792l-93.248 93.056 24.96 131.072a19.84 19.84 0 0 1-29.44 20.992z" fill="#FF9800" p-id="10634"></path></svg>
            <label style="font-weight: bolder; font-size: large"> 企业核心业务</label>
          </template>
          <input class="input" type="text" v-model="enterpriseModify.enterpriseCoreBusiness">
        </el-descriptions-item>


      </el-descriptions>
    </el-card>
  </div>
</template>

<style>
  .input {
    background-color: white
  }

  .input:hover {
    background-color: #B3C0D1;
  }

  .button {

  }

  .button:hover {
    color: black;
    border: 1px solid #000;
  }
</style>