<template>
  <div v-if="getWorkShow">
    <div style="display:flex;justify-content:center">
      <el-input prefix-icon="el-icon-search" style="width:600px;margin-right:10px" placeholder="输入公司名称" size="small">     </el-input>
      <el-button type="primary" icon="el-icon-search" style="width: 50px; height: 40px; margin-top: 5px"></el-button>
      <el-button @click="screenDialogShow" type="warning" icon="el-icon-s-operation" style="margin-left: 300px"></el-button>
    </div>

    <div v-for="formData in formDataList" :key="formData" style="display: inline-block; margin-left: 30px">
      <el-card style="display: inline-block; margin-right: 30px; margin-left: 0" v-if="formData.show == true">
        <div slot="header">
          <span>{{ formData.quarters.quartersThird }}</span>
          <el-button class="sub" style="float: right; padding: 3px 0" type="text" @click="add(formData)">提交简历</el-button>
        </div>


        <div>
          <div class="enterprise" @click="enterpriseDetails(formData)"> 公司名称：{{ formData.enterpriseName }} </div>

          <div style="margin-top: 5px"> 公司邮箱：{{ formData.enterpriseEmail }} </div>

          <div style="margin-top: 5px"> 工作地址：{{ formData.enWorkPlace }} </div>

          <div style="margin-top: 5px"> 工作范畴：{{ formData.quarters.quartersFirst +'-'+ formData.quarters.quartersSecond +'-'+ formData.quarters.quartersThird }} </div>

          <div style="margin-top: 5px"> 详细描述：{{ formData.enOccupationDescription }} </div>

          <div style="margin-top: 5px" >
            <el-tag type="success" style="font-size: large">{{ formData.enPay }}</el-tag>
          </div>

          <div style="margin-top: 5px" >
            <el-tag type="success" style="font-size: large">{{ formData.enNumber }}</el-tag>
            <el-tag type="success" style="font-size: large; margin-left: 10px">{{ formData.enRecentNumber }}</el-tag>
          </div>

          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ formData.enEndDate }}</el-tag>
          </div>
        </div>
      </el-card>
    </div>

    <el-dialog
        :visible.sync="enterpriseDialog.enterpriseShow"
    >
      <el-card>
        <el-descriptions class="margin-top" title="企业基本信息" :column="2" border>
          <el-descriptions-item>
            <template slot="label">
              <svg t="1718803314989" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4275" width="32" height="32"><path d="M912 912H112v-55h68V132a20 20 0 0 1 20-20h389a20 20 0 0 1 20 20v290h215a20 20 0 0 1 20 20v415h68v55zM507 213a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 179a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m285-264a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 130a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 147a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z" fill="#49D2FE" p-id="4276"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 企业名称</label>
            </template>
            <label class="show">{{ enterpriseDialog.enterprise.enterpriseName }}</label>
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718803441496" class="icon" viewBox="0 0 1170 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="5526" width="32" height="32"><path d="M0.804571 1001.033143l104.594286-182.418286 269.165714-34.889143-49.883428 217.307429H0.804571zM785.554286 662.966857l-24.868572-93.842286h122.002286l42.422857 77.750858-139.556571 16.091428z m176.859428 59.026286l159.451429 279.04h-490.788572l-7.460571-236.105143 338.797714-42.934857z m-259.072-144.822857l-19.968 26.843428c-52.297143 61.659429-92.16 120.685714-117.028571 177.005715-24.868571 56.32-47.323429 128.731429-67.291429 222.72-19.894857-93.915429-42.349714-166.326857-67.291428-222.72-12.434286-29.476571-29.842286-53.613714-44.836572-80.457143l-94.646857-120.685715-2.486857-2.706285c-67.291429-83.163429-102.107429-163.693714-102.107429-246.857143 0-91.209143 27.355429-166.326857 89.673143-233.325714C339.602286 32.475429 411.794286 0.292571 496.566857 0.292571s156.964571 29.476571 219.209143 96.548572c59.830857 64.365714 89.673143 142.189714 89.673143 233.398857 0 83.163429-34.889143 163.693714-102.107429 246.857143zM494.08 499.346286c89.673143 0 164.425143-80.457143 164.425143-177.005715 0-96.621714-74.752-177.152-164.425143-177.152-89.673143 0-164.425143 80.457143-164.425143 177.078858 0 96.548571 74.752 177.078857 164.425143 177.078857z m-356.205714 236.105143l84.699428-144.822858L317.220571 713.874286l-179.346285 21.504z" fill="#C0C4CC" p-id="5527"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 企业注册地</label>
            </template>
            {{ enterpriseDialog.enterprise.enterpriseRegistrationPlace }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718803513777" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6613" width="32" height="32"><path d="M670.1056 498.0224l68.8128-68.7616 103.2192-103.2192L910.848 394.752l-103.2192 103.2192 103.2192 103.2192-68.7616 68.864-103.2704-103.2192-68.7616-68.864z m172.032-196.608h-98.304v-49.152h-491.52v491.52h491.52v-49.152h98.304v147.456H154.0096V154.0096h688.128v147.456z m-294.912 196.608h98.304v98.304h-98.304v98.304h-98.304v-98.304h-98.304v-98.304h98.304v-29.44l-98.304-98.304L419.328 301.4144l78.6432 78.6944 73.728-78.6944 68.864 68.864-93.44 98.304v29.44z" fill="#3163F6" p-id="6614"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 注册资本</label>
            </template>
            {{ enterpriseDialog.enterprise.enterpriseRegisteredCapital }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718803656258" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7640" width="32" height="32"><path d="M511.726 0A511.726 511.726 0 1 1 0 511.726 511.726 511.726 0 0 1 511.726 0z" fill="#FCAE40" p-id="7641"></path><path d="M712.253 801.558H311.747a89.306 89.306 0 0 1-89.305-89.305V356.126a89.306 89.306 0 0 1 89.305-89.305h400.506a89.306 89.306 0 0 1 89.305 89.305v356.127a89.306 89.306 0 0 1-89.305 89.305zM422.968 356.126a68.486 68.486 0 1 0 70.13 68.486 69.034 69.034 0 0 0-70.13-68.486z m59.72 164.366h-119.44a95.88 95.88 0 1 0 0 192.308h119.44a95.88 95.88 0 0 0 0-192.308z m273.943-75.06H623.495v44.379h133.684v-44.927z m0 89.305H623.495v44.38h133.684v-44.928z m0 88.758H623.495v44.379h133.684v-44.38z" fill="#FFFFFF" p-id="7642"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 法定代表人</label>
            </template>
            {{ enterpriseDialog.enterprise.enterpriseLegalRepresentative }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718803724145" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8694" width="32" height="32"><path d="M826.3 805.5H200.1c-35.1 0-63.6-28.5-63.6-63.6V287.3c0-35.1 28.5-63.6 63.6-63.6h626.2c35.1 0 63.6 28.5 63.6 63.6V742c-0.1 35-28.6 63.5-63.6 63.5zM200.1 258.7c-15.8 0-28.6 12.8-28.6 28.6V742c0 15.8 12.8 28.6 28.6 28.6h626.2c15.8 0 28.6-12.8 28.6-28.6V287.3c0-15.8-12.8-28.6-28.6-28.6H200.1z" p-id="8695"></path><path d="M701.3 293.1h-16.5c-6.2 0-11.3-5.1-11.3-11.3v-85.9c0-6.2 5.1-11.3 11.3-11.3h16.5c6.2 0 11.3 5.1 11.3 11.3v85.9c0 6.2-5.1 11.3-11.3 11.3zM340.2 293.1h-16.5c-6.2 0-11.3-5.1-11.3-11.3v-85.9c0-6.2 5.1-11.3 11.3-11.3h16.5c6.2 0 11.3 5.1 11.3 11.3v85.9c0 6.2-5.1 11.3-11.3 11.3zM152.1 363.4h718.7v30H152.1zM247.2 442.7h133.3v53.4H247.2zM446.5 442.7h133.3v53.4H446.5zM645.9 442.7h133.3v53.4H645.9z" p-id="8696"></path><path d="M247.2 545.1h133.3v53.4H247.2zM446.5 545.1h133.3v53.4H446.5zM645.9 545.1h133.3v53.4H645.9z" p-id="8697"></path><path d="M247.2 647.5h133.3v53.4H247.2zM446.5 647.5h133.3v53.4H446.5zM645.9 647.5h133.3v53.4H645.9z" p-id="8698"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 注册日期</label>
            </template>
            {{ enterpriseDialog.enterprise.enterpriseFoundingDate }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477453809" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="12332" width="32" height="32"><path d="M838.954667 234.666667H170.666667c-3.626667 0-7.168 0.448-10.56 1.322666l323.690666 323.669334a21.333333 21.333333 0 0 0 30.165334 0L838.954667 234.666667z m46.144 14.186666l-260.693334 260.693334 262.933334 262.912c5.44-7.168 8.661333-16.106667 8.661333-25.792V277.333333c0-10.944-4.117333-20.906667-10.88-28.48zM843.861333 789.333333l-249.6-249.621333-50.133333 50.133333a64 64 0 0 1-90.517333 0l-50.112-50.133333L156.373333 786.88c4.48 1.578667 9.28 2.453333 14.314667 2.453333h673.194667zM128.661333 754.218667L373.333333 509.525333 129.578667 265.813333A42.709333 42.709333 0 0 0 128 277.333333v469.333334c0 2.56 0.213333 5.098667 0.661333 7.552zM170.666667 192h682.666666a85.333333 85.333333 0 0 1 85.333334 85.333333v469.333334a85.333333 85.333333 0 0 1-85.333334 85.333333H170.666667a85.333333 85.333333 0 0 1-85.333334-85.333333V277.333333a85.333333 85.333333 0 0 1 85.333334-85.333333z" fill="#333333" p-id="12333"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 企业邮箱地址</label>
            </template>
            {{ enterpriseDialog.enterprise.enterpriseEmail }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718803851173" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10632" width="32" height="32"><path d="M863.616 32a32 32 0 0 1 32 32v509.056l-12.8-28.16a83.84 83.84 0 0 0-73.216-49.088h-3.648l-3.648 0.064a83.84 83.84 0 0 0-72.64 50.048l-38.272 87.04-91.328 12.8c-23.168 3.2-43.52 15.872-56.64 34.368a64 64 0 1 0 7.424 106.24c0.64 0.896 1.536 1.792 2.432 2.624l70.144 68.096-17.28 98.112c-2.112 12.288-1.472 24.768 1.664 36.416L160 991.552a32 32 0 0 1-32-32V64a32 32 0 0 1 32-32h703.616zM806.4 559.744c7.808 0 14.976 4.48 18.24 11.648l54.208 118.976 16.768 2.112v267.072a32 32 0 0 1-1.92 10.88l-84.864-48.192-109.888 64.64a19.84 19.84 0 0 1-29.696-20.672l23.04-131.456L597.76 743.04a19.84 19.84 0 0 1 11.136-33.984l126.72-17.664 52.672-119.808a19.84 19.84 0 0 1 18.112-11.904z m-54.72-143.936H272a16 16 0 0 0-15.552 12.352l-0.448 3.648v64c0 7.36 5.12 13.824 12.352 15.488l3.648 0.448h479.744a16 16 0 0 0 15.552-12.352l0.448-3.648v-64a16 16 0 0 0-16-15.936z m0-223.872H272a16 16 0 0 0-15.552 12.352l-0.448 3.648v64c0 7.36 5.12 13.824 12.352 15.488l3.648 0.448h479.744a16 16 0 0 0 15.552-12.352l0.448-3.648v-64a16 16 0 0 0-16-16z" fill="#707A89" p-id="10633"></path><path d="M919.616 985.152l-110.784-62.912-109.888 64.64a19.84 19.84 0 0 1-29.696-20.672l23.04-131.456L597.76 743.04a19.84 19.84 0 0 1 11.136-33.984l126.72-17.664 52.672-119.808a19.84 19.84 0 0 1 36.352-0.256l54.208 118.976 126.848 15.872a19.84 19.84 0 0 1 11.648 33.792l-93.248 93.056 24.96 131.072a19.84 19.84 0 0 1-29.44 20.992z" fill="#FF9800" p-id="10634"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 企业核心业务</label>
            </template>
            {{ enterpriseDialog.enterprise.enterpriseCoreBusiness }}
          </el-descriptions-item>

        </el-descriptions>
      </el-card>
    </el-dialog>

    <el-dialog
        title="用人需求筛选"
        :visible.sync="screenDialog.screenDialogShow"
        center
    >
      <el-form label-width="80px">

        <el-form-item label="职业范畴">
          <el-select v-model="quartersFirstSelected" placeholder="请选择领域" v-if="firstShow" @change="firstSelected($event)" style="width: 150px; margin-right: 20px">
            <el-option
                v-for="qf in quartersFirst"
                :key="qf.value"
                :label="qf.value"
                :value="qf.value"

            >
            </el-option>
          </el-select>

          <el-select v-model="quartersSecondSelected" placeholder="请选择模块" v-if="secondShow" @change="secondSelected($event)" style="width: 150px; margin-right: 20px">
            <el-option
                v-for="qs in quartersSecond"
                :key="qs.value"
                :label="qs.value"
                :value="qs.value"
            >
            </el-option>
          </el-select>

          <el-select v-model="quartersThirdSelected" placeholder="请选择职位" v-if="thirdShow" style="width: 150px; margin-right: 20px">
            <el-option
                v-for="qt in quartersThird"
                :key="qt.value"
                :label="qt.value"
                :value="qt.value"
            >
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="薪资范围">
          <el-select v-model="screenDialog.enPay" filterable placeholder="最低月薪">
            <el-option
                v-for="item in enPayList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="招聘人数">
          <el-select v-model="screenDialog.enNumber" filterable placeholder="总共招聘几人">
            <el-option
                v-for="item in enNumberList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>


        <el-form-item label="工作地点">
          <el-cascader
              size="large"
              :options="pcaTextArr"
              v-model="screenDialog.enWorkPlaceList"
              clearable
              filterable
              ref="cascade"
          >
          </el-cascader>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="saveAndScreen">保存并筛选</el-button>
          <el-button @click="reset">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>

  </div>
</template>

<script>
import { pcaTextArr } from 'element-china-area-data';

export default {
  mounted() {
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

      if(this.graduate.graduateQualificationCheck != '审核通过') {
        const loading = this.$loading({
          lock: true,
          background: 'rgba(0, 0, 0, 0.7)'
        })
        setTimeout(() => {
          loading.close();
          this.$router.push('/GraduateResumeDetails');
          this.$notify({
            title: '提示',
            message: '请先通过毕业资格审查',
            iconClass: 'el-icon-tickets'
          })
        }, 1000);
      }
    })

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

      /**
       * 为quartersFirst赋值
       */
      for(let i = 0; i < this.quartersList.length; i++) {
        /**
         * 判断当前条目是否存在 不存在则添加
         * @type {boolean}
         */
        let flag = false
        for(let j = 0; j < this.quartersFirst.length; j++) {
          if(this.quartersList[i].quartersFirst == this.quartersFirst[j].value)
            flag = true
        }
        if(!flag)
          this.quartersFirst[this.quartersFirst.length] = {
            value: this.quartersList[i].quartersFirst,
          }
      }

      // 移除组件
      this.firstShow = false
      // 在组件移除后，重新渲染组件
      // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
      this.$nextTick(() => {
        this.firstShow = true
      })
    })

    /**
     * 读取用人需求信息
     */
    this.$axios.get('http://localhost:8081/en/query_all').then(res=>{
      /**
       * 从数据库中查询所有企业并保存在enterpriseList中
       */
      this.$axios.get('http://localhost:8081/enterprise/query_all').then(res1=>{
        /**
         * 从数据库中读取所有职位
         */
        this.$axios.get('http://localhost:8081/quarters/query_all').then(res2=>{
          for(let i = 0; i < res2.data.length; i++) {
            this.quartersList[i] = {
              quartersId: res2.data[i].quartersId,
              quartersFirst: res2.data[i].quartersFirst,
              quartersSecond: res2.data[i].quartersSecond,
              quartersThird: res2.data[i].quartersThird,
            }
          }

          for(let i = 0; i < res1.data.length; i++) {
            this.enterpriseList[i] = {
              enterpriseId: res1.data[i].enterpriseId,
              enterpriseName: res1.data[i].enterpriseName,
              enterpriseRegistrationPlace: res1.data[i].enterpriseRegistrationPlace,
              enterpriseRegisteredCapital: res1.data[i].enterpriseRegisteredCapital,
              enterpriseLegalRepresentative: res1.data[i].enterpriseLegalRepresentative,
              enterpriseFoundingDate: res1.data[i].enterpriseFoundingDate,
              enterpriseEmail: res1.data[i].enterpriseEmail,
              enterpriseCoreBusiness: res1.data[i].enterpriseCoreBusiness,
              userId: res1.data[i].userId,
              enterpriseQualificationsCheck: res1.data[i].enterpriseQualificationsCheck,
            }
          }

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

          /**
           * 根据上述信息构建formDataList
           */
          for(let i = 0; i < this.employmentNeedList.length; i++) {
            this.formDataList[i] = {
              enId: this.employmentNeedList[i].enId,
              enWorkPlace: this.employmentNeedList[i].enWorkPlace,
              enPay: '薪资： ' + this.employmentNeedList[i].enPay,
              enEndDate: '截止日期： ' + this.employmentNeedList[i].enEndDate,
              enOccupationDescription: this.employmentNeedList[i].enOccupationDescription,
              enNumber: '招聘人数： ' + this.employmentNeedList[i].enNumber,
              enRecentNumber: '剩余招聘人数： ' + this.employmentNeedList[i].enRecentNumber,
              quarters: {
                quartersFirst: '',
                quartersSecond: '',
                quartersThird: '',
              },
              enterpriseName: '',
              enterpriseEmail: '',
              show: true
            }

            /**
             * 找到quarters并赋值
             */
            this.formDataList[i].quarters.quartersId = this.employmentNeedList[i].quartersId
            for(let j = 0; j < this.quartersList.length; j++) {
              if(this.quartersList[j].quartersId == this.employmentNeedList[i].quartersId) {
                this.formDataList[i].quarters.quartersFirst = this.quartersList[j].quartersFirst
                this.formDataList[i].quarters.quartersSecond = this.quartersList[j].quartersSecond
                this.formDataList[i].quarters.quartersThird = this.quartersList[j].quartersThird
              }
            }

            /**
             * 找到enterprise并赋值
             */
            this.formDataList[i].enterpriseId = this.employmentNeedList[i].enterpriseId
            for(let j = 0; j < this.enterpriseList.length; j++) {
              if(this.enterpriseList[j].enterpriseId == this.employmentNeedList[i].enterpriseId) {
                this.formDataList[i].enterpriseName = this.enterpriseList[j].enterpriseName
                this.formDataList[i].enterpriseEmail = this.enterpriseList[j].enterpriseEmail
              }
            }
          }

          console.log(this.formDataList)
          /**
           * 重新渲染
           */
          // 移除组件
          this.getWorkShow = false
          // 在组件移除后，重新渲染组件
          // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
          this.$nextTick(() => {
            this.getWorkShow = true
          })
        })
      })


    })
  },

  data() {
    return{
      pcaTextArr,

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
       * 企业基本信息
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
       * 对话企业卡片信息
       */
      enterpriseDialog: {
        enterpriseShow: false,
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
      },

      /**
       * 职位表
       */
      quartersList: [{
        quartersId: 0,
        quartersFirst: '',
        quartersSecond: '',
        quartersThird: '',
      }],

      /**
       * 用于显示领域
       */
      quartersFirst: [],
      quartersFirstSelected: '',
      firstShow: false,

      /**
       * 用于显示模块
       */
      quartersSecond: [],
      quartersSecondSelected: '',
      secondShow: false,

      /**
       * 用于显示工种
       */
      quartersThird: [],
      quartersThirdSelected: '',
      thirdShow: false,

      /**
       * 招聘过程添加
       */
      recruitmentProcessAdd: {
        graduateId: 0,
        enId: 0,
        rpPhase: '',
      },

      /**
       * 展示信息表
       */
      formDataList: [{
        quarters: {
          quartersId: 0,
          quartersFirst: '',
          quartersSecond: '',
          quartersThird: '',
        },
        enterpriseName: '',
        enterpriseEmail: '',
        enWorkPlaceList: [],
        enWorkPlace: '',
        enPay: '',
        enEndDate: '',
        enOccupationDescription: '',
        enNumber: '',
        enRecentNumber: '',

        enId: 0,
        enterpriseId: 0,
        show: true
      }],

      /**
       * 数据渲染控制
       */
      getWorkShow: true,

      /**
       * 筛选界面展示
       */
      screenDialog: {
        screenDialogShow: false,
        quarters: {
          quartersFirst: '',
          quartersSecond: '',
          quartersThird: '',
        },
        enPay: '',
        enNumber: '',
        enWorkPlace: '',
      },

      /**
       * 招聘人数
       */
      enNumberList: [
        {
          value: '1',
          label: '1'
        },
        {
          value: '2',
          label: '2'
        },
        {
          value: '3',
          label: '3'
        },
        {
          value: '4',
          label: '4'
        },
        {
          value: '5',
          label: '5'
        }],

      /**
       * 招聘薪资
       */
      enPayList: [
        {
          value: '3k',
          label: '3k'
        },
        {
          value: '4k',
          label: '4k'
        },
        {
          value: '6k',
          label: '6k'
        },
        {
          value: '8k',
          label: '8k'
        },
        {
          value: '10k',
          label: '10k'
        },
        {
          value: '12k',
          label: '12k'
        },
        {
          value: '15k',
          label: '15k'
        }],

    }
  },

  methods: {
    enterpriseDetails(formData) {
      this.enterpriseDialog.enterprise = {
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

      this.enterpriseDialog.enterpriseShow = true

      /**
       * 根据当前的enterpriseId来匹配
       */
      for(let i = 0; i < this.enterpriseList.length; ++i) {
        if(this.enterpriseList[i].enterpriseId == formData.enterpriseId) {
          this.enterpriseDialog.enterprise = {
            enterpriseId: this.enterpriseList[i].enterpriseId,
            enterpriseName: this.enterpriseList[i].enterpriseName,
            enterpriseRegistrationPlace: this.enterpriseList[i].enterpriseRegistrationPlace,
            enterpriseRegisteredCapital: this.enterpriseList[i].enterpriseRegisteredCapital,
            enterpriseLegalRepresentative: this.enterpriseList[i].enterpriseLegalRepresentative,
            enterpriseFoundingDate: this.enterpriseList[i].enterpriseFoundingDate,
            enterpriseEmail: this.enterpriseList[i].enterpriseEmail,
            enterpriseCoreBusiness: this.enterpriseList[i].enterpriseCoreBusiness,
            userId: this.enterpriseList[i].userId,
            enterpriseQualificationsCheck: this.enterpriseList[i].enterpriseQualificationsCheck,
          }
        }
      }
    },

    add(formData) {
      this.recruitmentProcessAdd.graduateId = this.graduate.graduateId
      this.recruitmentProcessAdd.enId = formData.enId
      this.recruitmentProcessAdd.rpPhase = '简历投递'

      this.$axios.post('http://localhost:8081/rp/add', this.recruitmentProcessAdd).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "添加OK") {
          this.$message({message: '简历投递成功', type: 'success'})
        }
      })
    },

    screenDialogShow() {
      this.screenDialog.screenDialogShow = true
    },

    firstSelected() {
      /**
       * 第一项值更改 清空二三项值 同时消失二三项
       */
      this.quartersSecond = []
      this.quartersThird = []
      this.quartersSecondSelected = ''
      this.quartersThirdSelected = ''
      this.secondShow = false
      this.thirdShow = false


      /**
       * 根据第一项为第二项赋值
       */
      for(let i = 0; i < this.quartersList.length; i++) {
        /**
         * 判断当前条目是否存在 不存在则添加
         * @type {boolean}
         */
        let flag = false
        for(let j = 0; j < this.quartersSecond.length; j++) {
          if(this.quartersList[i].quartersSecond == this.quartersSecond[j].value)
            flag = true
        }
        if(!flag && this.quartersList[i].quartersFirst == this.quartersFirstSelected)
          this.quartersSecond[this.quartersSecond.length] = {
            value: this.quartersList[i].quartersSecond,
          }
      }

      // 在组件移除后，重新渲染组件
      // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
      this.$nextTick(() => {
        this.secondShow = true
      })
    },

    secondSelected() {
      /**
       * 第二项值更改 清空三项值 同时消失三项
       */
      this.quartersThird = []
      this.quartersThirdSelected = ''
      this.thirdShow = false

      /**
       * 根据第二项为第三项赋值
       */
      for(let i = 0; i < this.quartersList.length; i++) {
        /**
         * 判断当前条目是否存在 不存在则添加
         * @type {boolean}
         */
        let flag = false
        for(let j = 0; j < this.quartersThird.length; j++) {
          if(this.quartersList[i].quartersThird == this.quartersThird[j].value)
            flag = true
        }
        if(!flag && this.quartersList[i].quartersFirst == this.quartersFirstSelected && this.quartersList[i].quartersSecond == this.quartersSecondSelected)
          this.quartersThird[this.quartersThird.length] = {
            value: this.quartersList[i].quartersThird,
          }
      }

      // 在组件移除后，重新渲染组件
      // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
      this.$nextTick(() => {
        this.thirdShow = true
      })
    },

    reset() {
      this.quartersSecond = []
      this.quartersThird = []
      this.quartersFirstSelected = ''
      this.quartersSecondSelected = ''
      this.quartersThirdSelected = ''
      this.secondShow = false
      this.thirdShow = false


      this.screenDialog.enNumber = ''
      this.screenDialog.enPay = ''
      this.screenDialog.enWorkPlaceList = []
      this.screenDialog.enWorkPlace = ''
      // 清空选中的节点
      this.$refs.cascade.$refs.panel.clearCheckedNodes();
    },

    saveAndScreen() {
      console.log(this.quartersFirstSelected)
      console.log(this.quartersSecondSelected)
      console.log(this.quartersThirdSelected)
      console.log(this.screenDialog.enWorkPlaceList)
      console.log(this.screenDialog.enPay)
      console.log(this.screenDialog.enNumber)

      this.$message({ message: '筛选完成', type: 'success'})

      if(this.screenDialog.enWorkPlaceList.length != 0)
        this.screenDialog.enWorkPlace = this.screenDialog.enWorkPlaceList[0]+'-'+this.screenDialog.enWorkPlaceList[1]+'-'+this.screenDialog.enWorkPlaceList[2]
      if(this.screenDialog.enPay != '')
        this.screenDialog.enPay = '薪资： ' + this.screenDialog.enPay
      if(this.screenDialog.enNumber != '')
        this.screenDialog.enNumber = '招聘人数： ' + this.screenDialog.enNumber

      console.log(this.screenDialog.enWorkPlace)

      /**
       * 全未选则重置显示
       */
      if(this.quartersFirstSelected == '' && this.quartersSecondSelected == '' && this.quartersThirdSelected == '') {
        if(this.screenDialog.enWorkPlace == '' && this.screenDialog.enPay  == '' && this.screenDialog.enNumber == '') {
          for(let i = 0; i < this.formDataList.length; ++i) {
            this.formDataList[i].show = true
          }
        }
      }

      if(this.quartersFirstSelected != '') {
        for(let i = 0; i < this.formDataList.length; ++i) {
          if(this.formDataList[i].quarters.quartersFirst != this.quartersFirstSelected)
            this.formDataList[i].show = false
        }
      }

      if(this.quartersSecondSelected != '') {
        for(let i = 0; i < this.formDataList.length; ++i) {
          if(this.formDataList[i].quarters.quartersSecond != this.quartersSecondSelected)
            this.formDataList[i].show = false
        }
      }

      if(this.quartersThirdSelected != '') {
        for(let i = 0; i < this.formDataList.length; ++i) {
          if(this.formDataList[i].quarters.quartersThird != this.quartersThirdSelected)
            this.formDataList[i].show = false
        }
      }

      if(this.screenDialog.enWorkPlace != '') {
        for(let i = 0; i < this.formDataList.length; ++i) {
          if(this.formDataList[i].enWorkPlace != this.screenDialog.enWorkPlace)
            this.formDataList[i].show = false
        }
      }

      if(this.screenDialog.enPay  != '') {
        for(let i = 0; i < this.formDataList.length; ++i) {
          if(this.formDataList[i].enPay != this.screenDialog.enPay)
            this.formDataList[i].show = false
        }
      }

      if(this.screenDialog.enNumber != '') {
        for(let i = 0; i < this.formDataList.length; ++i) {
          if(this.formDataList[i].enNumber != this.screenDialog.enNumber)
            this.formDataList[i].show = false
        }
      }

      /**
       * 重新渲染
       */
      // 移除组件
      this.getWorkShow = false
      // 在组件移除后，重新渲染组件
      // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
      this.$nextTick(() => {
        this.getWorkShow = true
      })

      this.screenDialog.screenDialogShow = false
    }
  },
}

</script>

<style>
  .enterprise {

  }

  .enterprise:hover {
    cursor: pointer;
    color: red;
    text-decoration-line: underline;
  }

  .sub:hover {
    color: red;
    cursor: pointer;
    text-decoration-line: underline;
  }
</style>
