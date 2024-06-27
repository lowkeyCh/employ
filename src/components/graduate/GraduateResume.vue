<script>
  export default {
    mounted() {
      if( this.$route.path != '/GraduateResumeDetails')
        this.$route.path = '/GraduateResumeDetails'

      /**
       * 获取用户id
       */
      let userId = JSON.parse(localStorage.getItem("user")).user.userId

      /**
       * 根据用户id获取毕业生个人基本信息
       */
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

        /**
         * 分析用户审核状态 同时更新显示按钮状态 同时更新是否能够上传
         */
        if(this.graduate.graduateQualificationCheck == "未审核") {
          this.buttonShow.processShow = true
          this.buttonShow.successShow = false
          this.buttonShow.failShow = false
        } else if(this.graduate.graduateQualificationCheck == "审核通过") {
          this.buttonShow.processShow = false
          this.buttonShow.successShow = true
          this.buttonShow.failShow = false
        } else {
          this.buttonShow.processShow = false
          this.buttonShow.successShow = false
          this.buttonShow.failShow = true
        }

        /**
         * 根据毕业生id获取毕业生毕业资料相关信息
         */
        this.$axios.get('http://localhost:8081/gq/query_by_graduate_id?graduateId='+ this.graduate.graduateId).then(res=>{
          for(let i = 0; i < res.data.length; i++) {
            this.graduateQualifications[i] = {
              graduateId: res.data[i].graduateId,
              gqId: res.data[i].gqId,
              gqIndex: res.data[i].gqIndex,
            }
          }

          /**
           * 将获取的毕业资料地址赋值fileList
           */
          for(let i = 0; i < res.data.length; i++) {
            this.fileList[i] = {
              name: "" + this.graduateQualifications[i].gqId,
              url: "http://localhost:8081/" + this.graduateQualifications[i].gqIndex,
            }
          }

          /**
           * 重新渲染el-upload
           */
          // 移除组件
          this.qualificationsShow = false
          // 在组件移除后，重新渲染组件
          // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
          this.$nextTick(() => {
            this.qualificationsShow = true
          })
        })
      })


    },


    methods: {
      /**
       * 文件上传自定义接口
       * @param param
       */
      upload(param) {
        /**
         * 将审核状态改为未审核 同时改变显示情况
         */
        this.buttonShow.processShow = true
        this.buttonShow.successShow = false
        this.buttonShow.failShow = false

        /**
         * 发送请求更新审核状态
         */
        this.graduate.graduateQualificationCheck = '未审核'
        this.$axios.post('http://localhost:8081/graduate/modify', this.graduate)

        /**
         * 将文件转换为表单格式
         */
        let formDataFile = new FormData();
        formDataFile.append('file', param.file);

        /**
         * 上传文件并返回文件后端地址
         */
        this.$axios.post('http://localhost:8081/file/upload_resume', formDataFile).then(res=>{
          /**
           * 将新上传的文件存放金fileList中
           */
          this.fileList[this.fileList.length] = {name: res.data, url: "http://localhost:8081/" + res.data}
          this.graduateQualifications[this.graduateQualifications.length] = {gqIndex: res.data}

          /**
           * 重新渲染el-upload
           */
          // 移除组件
          this.qualificationsShow = false
          // 在组件移除后，重新渲染组件
          // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
          this.$nextTick(() => {
            this.qualificationsShow = true
          })

          /**
           * 将新上传的毕业资料相关信息添加至数据库中
           */
          this.$axios.post('http://localhost:8081/gq/add', {
            graduateId: this.graduate.graduateId,
            gqIndex: res.data,
          }).then(res=>{
            if(res.data == "上传成功")
              this.$message({ message: '上传成功', type: 'success'})
          })
        })


      },

      /**
       * 移除文件
       * @param file
       */
      handleRemove(file) {
        /**
         * 遍历fileList找到当前元素
         */
        for(let i = 0; i != this.fileList.length; ++i) {
          /**
           * 根据url进行匹配 匹配成功后从fileList中移除file
           */
          if(file.url == this.fileList[i].url) {
            /**
             * 删除后端数据库中的元素
             */
            this.$axios.get('http://localhost:8081/gq/delete_by_gq_index?gqIndex='+ this.graduateQualifications[i].gqIndex).then(res=>{
              if(res.data == "删除成功")
                this.$message({ message: '删除成功', type: 'success'})
            })

            /**
             * 删除fileList与graduateQualifications中的数据
             */
            this.fileList.splice(i, 1)
            this.graduateQualifications.splice(i, 1)
          }
        }

      },

      /**
       * 预览文件
       * @param file
       */
      handlePictureCardPreview(file) {
        this.preview.previewDialog = true;
        this.preview.previewImageUrl = file.url;
      },

    },

    data() {
      return {
        fileList: [],

        qualificationsShow: 'true',

        isUpload: true,

        /**
         *  审核状态显示按钮
         */
        buttonShow: {
          processShow: false,
          successShow: false,
          failShow: false,
        },

        /**
         * 毕业生基本信息对象
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
         * 毕业生毕业资格信息
         */
        graduateQualifications: [{
          graduateId: 0,
          gqId: 0,
          gqIndex: '',
        }],

        /**
         * 界面预览弹窗显示对象
         */
        preview: {
          previewDialog: false,
          previewImageUrl: '',
        }
      }
    },
  }
</script>

<template>
  <el-card>
    <el-descriptions class="margin-top" title="就业资格上传" :column="2" border>
      <template slot="extra">
        <el-button v-show="buttonShow.processShow" class="button" type="warning" size="medium">
          <i class="el-icon-loading"></i>
          就业资格审查中
        </el-button>

        <el-button v-show="buttonShow.successShow" class="button" type="success" size="medium">
          <i class="el-icon-check"></i>
          就业资格审查成功
        </el-button>

        <el-button v-show="buttonShow.failShow" class="button" type="danger" size="medium">
          <i class="el-icon-close"></i>
          就业资格审查未通过
        </el-button>
      </template>
    </el-descriptions>

    <el-upload
        action=""
        :http-request="upload"
        list-type="picture-card"
        :file-list="fileList"
        :auto-upload="true"
        v-if="qualificationsShow"
    >
        <i slot="default" class="el-icon-plus"></i>

        <div slot="file" slot-scope="{file}">
          <img
              class="el-upload-list__item-thumbnail"
              :src="file.url" alt=""
          >
          <span class="el-upload-list__item-actions">

            <span
                class="el-upload-list__item-preview"
                @click="handlePictureCardPreview(file)"
            >
              <i class="el-icon-zoom-in"></i>
            </span>

            <span
                class="el-upload-list__item-delete"
                @click="handleRemove(file)"
            >
              <i class="el-icon-delete"></i>
            </span>

          </span>
        </div>
    </el-upload>

    <!--界面预览弹窗-->
    <el-dialog :visible.sync="preview.previewDialog">
      <img width="100%" :src="preview.previewImageUrl" alt="">
    </el-dialog>
  </el-card>
</template>

<style scoped>
  .button {
    color: black;
    cursor: auto;
  }

  .button:hover {
    border: 1px solid #000;
  }

</style>