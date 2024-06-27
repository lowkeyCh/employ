<script>
  import { pcaTextArr } from 'element-china-area-data'
  import {log} from "three";
  export default {
    mounted() {
      /**
       * 获取用户id并根据用户id获取企业id
       */
      let userId = JSON.parse(localStorage.getItem("user")).user.userId
      this.$axios.get('http://localhost:8081/enterprise/query?userId='+ userId).then(res=>{
        this.formData.enterpriseId = res.data.enterpriseId

        if(res.data.enterpriseQualificationsCheck != '审核通过') {
          const loading = this.$loading({
            lock: true,
            background: 'rgba(0, 0, 0, 0.7)'
          })
          setTimeout(() => {
            loading.close();
            this.$router.push('/EnterpriseResume');
            this.$notify({
              title: '提示',
              message: '请先通过企业用人资格审查',
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

        /**
         * 重新渲染el-upload
         */
        // 移除组件
        this.firstShow = false
        // 在组件移除后，重新渲染组件
        // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
        this.$nextTick(() => {
          this.firstShow = true
        })
      })
    },

    methods: {
      createEmploymentNeed() {
        /**
         * 将工作地址数组转化为工作地址字符串
         */
        this.formData.enWorkPlace += this.formData.enWorkPlaceList[0]
        for (let i = 1; i < this.formData.enWorkPlaceList.length ; i++) {
          this.formData.enWorkPlace += '-' + this.formData.enWorkPlaceList[i]
        }

        /**
         * 剩余招聘人数赋值
         */
        this.formData.enRecentNumber = this.formData.enNumber

        /**
         * 匹配职位信息
         */
        for(let i = 0; i < this.quartersList.length; i++) {
          if(this.quartersList[i].quartersFirst == this.quartersFirstSelected
          && this.quartersList[i].quartersSecond == this.quartersSecondSelected
          && this.quartersList[i].quartersThird == this.quartersThirdSelected)
            this.formData.quartersId = this.quartersList[i].quartersId
        }

        this.$axios.post('http://localhost:8081/en/add', this.formData).then(res=>{
          if(res.data == "添加OK")
            this.$message({ message: '发布成功', type: 'success'})

          /**
           * 初始化formData
           */
          this.resetFormData()
        })
      },

      resetFormData() {
        this.formData = {
          quartersId: 0,
          enOccupationDescription: '',
          enPay: '',
          enNumber: '',
          enRecentNumber: '',
          enWorkPlaceList: [],
          enWorkPlace: '',
          enEndDate: '',
          enterpriseId: 0,
        }

        this.quartersSecond = []
        this.quartersThird = []
        this.quartersFirstSelected = ''
        this.quartersSecondSelected = ''
        this.quartersThirdSelected = ''
        this.secondShow = false
        this.thirdShow = false
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


        /**
         * 重新渲染el-upload
         */
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

        /**
         * 重新渲染el-upload
         */
        // 在组件移除后，重新渲染组件
        // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
        this.$nextTick(() => {
          this.thirdShow = true
        })
      }
    },

    data() {
      return {
        pcaTextArr,



        formData: {
          quartersId: 0,
          enOccupationDescription: '',
          enterpriseId: 0,
          enPay: '',
          enNumber: '',
          enRecentNumber: '',
          enWorkPlaceList: [],
          enWorkPlace: '',
          enEndDate: '',
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


        /**
         * 从数据库中读取的职位名称表
         */
        quartersList:[{
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
      }
    },


  }
</script>

<template>
  <div class="AllRequire">

    <div class="myPicture">
      <el-row >
        <el-card :body-style="{ padding: '0px' }">
          <div class="word">
            <span style="font-style: normal;font-size: 34px;font-weight: bolder;height:auto;display: block;text-align: left;white-space: pre-wrap;word-break:break-all;">去发布一个职位吧</span>
            <span style="font-style: normal;font-size: 25px;height:auto;display: block;text-align: left;white-space: pre-wrap;word-break:break-all;">开启高效招聘方式</span>
          </div>
          <div>
            <img src="https://img.bosszhipin.com/static/file/2023/n3fa5j6es61684132314764.png" class="image" style="width: 500px; height: 550px">
          </div>
        </el-card>
      </el-row>
    </div>

    <div class="myRequire">

      <el-form :model="formData" label-width="80px">

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

          <el-select v-model="quartersThirdSelected" placeholder="请选择模块" v-if="thirdShow" style="width: 150px; margin-right: 20px">
            <el-option
                v-for="qt in quartersThird"
                :key="qt.value"
                :label="qt.value"
                :value="qt.value"
            >
            </el-option>
          </el-select>
        </el-form-item>


        <el-form-item label="职位描述">
          <el-input type="textarea" v-model="formData.enOccupationDescription" filterable placeholder="简要描述工作内容" style="width: 500px">

          </el-input>
        </el-form-item>


        <el-form-item label="薪资范围">
          <el-select v-model="formData.enPay" filterable placeholder="最低月薪">
            <el-option
                v-for="item in enPayList"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="招聘人数">
          <el-select v-model="formData.enNumber" filterable placeholder="总共招聘几人">
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
              v-model="formData.enWorkPlaceList"
              clearable
              filterable
          >
          </el-cascader>
        </el-form-item>


        <el-form-item label="截止日期">
          <input type="date" style="background-color: white; border: 1px rgba(0,0,0,0.16) solid" v-model="formData.enEndDate">
        </el-form-item>


        <el-form-item>
          <el-button type="primary" @click="createEmploymentNeed">立即创建</el-button>
          <el-button @click="resetFormData">重置</el-button>
        </el-form-item>


      </el-form>

    </div>

  </div>
</template>

<style>
  .myPicture{
    width: 45%;
    position: relative;
    top: 30px;
    left: 5px;
  }

  .myRequire{
    width: 45%;
    position: absolute;
    right: 0;
    top: 140px;
  }
</style>