<script>
  export default {

    mounted() {
      /**
       * 获取所有毕业生基本信息
       */
      this.$axios.get('http://localhost:8081/graduate/query_all').then(res=>{
        for(let i = 0; i < res.data.length; i++) {
          this.graduateList[i] = {
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
          this.graduateList[i].graduateId = res.data[i].graduateId
          this.graduateList[i].graduateName = res.data[i].graduateName
          this.graduateList[i].graduateAge = res.data[i].graduateAge
          this.graduateList[i].graduateSex = res.data[i].graduateSex
          this.graduateList[i].graduateBirthday = res.data[i].graduateBirthday
          this.graduateList[i].graduateCollege = res.data[i].graduateCollege
          this.graduateList[i].graduateGraduateDate = res.data[i].graduateGraduateDate
          this.graduateList[i].graduateMajor = res.data[i].graduateMajor
          this.graduateList[i].userId = res.data[i].userId
          this.graduateList[i].graduatePhone = res.data[i].graduatePhone
          this.graduateList[i].graduateEmail = res.data[i].graduateEmail
          this.graduateList[i].graduateQualificationCheck = res.data[i].graduateQualificationCheck

          /**
           * 为tableDataList赋值展示数据
           */
          this.tableDataList[i] = {
            graduateId: 0,
            graduateName: '',
            graduateQualificationCheck: '',
            gqIndexs:[],
          },
          this.tableDataList[i].graduateId = this.graduateList[i].graduateId
          this.tableDataList[i].graduateName = this.graduateList[i].graduateName
          this.tableDataList[i].graduateQualificationCheck = this.graduateList[i].graduateQualificationCheck

          /**
           * 根据企业id获取企业用人资料相关信息
           */
          this.$axios.get('http://localhost:8081/gq/query_by_graduate_id?graduateId='+ this.graduateList[i].graduateId).then(res2=>{
            console.log(res2)
            this.graduateQualifications[i] = []
            for(let j = 0; j < res2.data.length; j++) {
              this.graduateQualifications[i][j] = {
                graduateId: res2.data[j].graduateId,
                gqId: res2.data[j].gqId,
                gqIndex: res2.data[j].gqIndex,
              }

              /**
               * 为tableDataList赋值展示数据
               */
              this.tableDataList[i].gqIndexs[j] = "http://localhost:8081/" + this.graduateQualifications[i][j].gqIndex
            }
          })
        }

        // 移除组件
        this.tableDataListShow = false
        // 在组件移除后，重新渲染组件
        // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
        this.$nextTick(() => {
          this.tableDataListShow = true
        })
      })
    },

    data() {
      return {
        /**
         * tableDataList表示将要展示的数据集合
         */
        tableDataList: [{
          graduateId: 0,
          graduateName: '',
          graduateQualificationCheck: '',
          gqIndexs:[],
        }],

        /**
         * 渲染tableDataList
         */
        tableDataListShow: false,

        /**
         * 界面预览弹窗显示对象
         */
        preview: {
          previewDialog: false,
          previewImageUrls: [''],
        },

        /**
         * 毕业生个人基本信息集合
         */
        graduateList: [{
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
        }],

        /**
         * 毕业生就业资格信息
         */
        graduateQualifications: [[{
          graduateId: 0,
          gqId: 0,
          gqIndex: '',
        }]],

      }
    },

    methods: {
      /**
       * 界面展示 同时设置图片路径
       */
      graduateQualificationsShow(tableData) {
        this.preview.previewDialog = true
        for(let i = 0; i < tableData.gqIndexs.length; ++i) {
          this.preview.previewImageUrls[i] = tableData.gqIndexs[i]
        }
      },

      /**
       * 毕业生就业资格检测通过
       */
      checkPass(tableData) {
        for(let i = 0; i < this.tableDataList.length; ++i) {
          if(tableData.graduateId == this.tableDataList[i].graduateId) {
            this.tableDataList[i].graduateQualificationCheck = "审核通过"
            this.graduateList[i].graduateQualificationCheck = "审核通过"

            // 移除组件
            this.tableDataListShow = false
            // 在组件移除后，重新渲染组件
            // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
            this.$nextTick(() => {
              this.tableDataListShow = true
            })
            /**
             * 发送请求更新审核状态
             */
            this.$axios.post('http://localhost:8081/graduate/modify', this.graduateList[i]).then(res=>{
              this.$message({ message: '审核完成', type: 'success'})
            })
            break
          }
        }
      },

      /**
       * 毕业生就业资格检测未通过
       */
      checkOut(tableData) {
        for(let i = 0; i < this.tableDataList.length; ++i) {
          if(tableData.graduateId == this.tableDataList[i].graduateId) {
            this.tableDataList[i].graduateQualificationCheck = "审核未通过"
            this.graduateList[i].graduateQualificationCheck = "审核未通过"

            // 移除组件
            this.tableDataListShow = false
            // 在组件移除后，重新渲染组件
            // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
            this.$nextTick(() => {
              this.tableDataListShow = true
            })
            /**
             * 发送请求更新审核状态
             */
            this.$axios.post('http://localhost:8081/graduate/modify', this.graduateList[i]).then(res=>{
              this.$message({ message: '审核完成', type: 'success'})
            })
            break
          }
        }
      },

      /**
       * 毕业生就业资格资质检测重置
       */
      checkReset(tableData) {
        for(let i = 0; i < this.tableDataList.length; ++i) {
          if(tableData.graduateId == this.tableDataList[i].graduateId) {
            this.tableDataList[i].graduateQualificationCheck = "未审核"
            this.graduateList[i].graduateQualificationCheck = "未审核"

            // 移除组件
            this.tableDataListShow = false
            // 在组件移除后，重新渲染组件
            // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
            this.$nextTick(() => {
              this.tableDataListShow = true
            })
            /**
             * 发送请求更新审核状态
             */
            this.$axios.post('http://localhost:8081/graduate/modify', this.graduateList[i]).then(res=>{
              this.$message({ message: '重置审核状态完成', type: 'success'})
            })
            break
          }
        }
      }


    },

  }
</script>

<template>
  <div>
    <div style="padding: 5px 20px 10px 0px">
      <el-input placeholder="毕业生名称" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
      <el-button type="primary" icon="el-icon-search" style="margin-left: 10px">查询</el-button>
    </div>

    <el-table :data="tableDataList"
              :header-cell-style="{background:'rgba(152,157,159,0.5)',color:'#555555'}"
              border
              v-if="tableDataListShow"
    >
      <el-table-column align="center" label="ID" width="100" type="index">
      </el-table-column>

      <el-table-column width="300" prop="graduateName">
        <template slot="header">
          <svg t="1718803314989" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4275" width="32" height="32"><path d="M912 912H112v-55h68V132a20 20 0 0 1 20-20h389a20 20 0 0 1 20 20v290h215a20 20 0 0 1 20 20v415h68v55zM507 213a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 188a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m0 179a20 20 0 0 0-20-20H302a20 20 0 0 0-20 20v42a20 20 0 0 0 20 20h185a20 20 0 0 0 20-20v-42z m285-264a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 130a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z m0 147a20 20 0 0 0-20-20H633a20 20 0 0 0-20 20v16a20 20 0 0 0 20 20h139a20 20 0 0 0 20-20v-16z" fill="#49D2FE" p-id="4276"></path></svg>
          <label style="margin-left: 5px;">毕业生姓名</label>
        </template>
      </el-table-column>

      <el-table-column width="300" prop="graduateQualificationCheck">
        <template slot="header">
          <svg t="1718803656258" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7640" width="32" height="32"><path d="M511.726 0A511.726 511.726 0 1 1 0 511.726 511.726 511.726 0 0 1 511.726 0z" fill="#FCAE40" p-id="7641"></path><path d="M712.253 801.558H311.747a89.306 89.306 0 0 1-89.305-89.305V356.126a89.306 89.306 0 0 1 89.305-89.305h400.506a89.306 89.306 0 0 1 89.305 89.305v356.127a89.306 89.306 0 0 1-89.305 89.305zM422.968 356.126a68.486 68.486 0 1 0 70.13 68.486 69.034 69.034 0 0 0-70.13-68.486z m59.72 164.366h-119.44a95.88 95.88 0 1 0 0 192.308h119.44a95.88 95.88 0 0 0 0-192.308z m273.943-75.06H623.495v44.379h133.684v-44.927z m0 89.305H623.495v44.38h133.684v-44.928z m0 88.758H623.495v44.379h133.684v-44.38z" fill="#FFFFFF" p-id="7642"></path></svg>
          <label style="margin-left: 5px;">毕业生就业资格审查状态</label>
        </template>
      </el-table-column>

      <el-table-column width="150" prop="gqIndexs">
        <template slot="header">
          <svg t="1718854549892" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="3330" width="32" height="32"><path d="M447.829333 754.176 447.829333 695.978667 224.938667 695.978667 224.938667 754.176Z" p-id="3331"></path><path d="M447.829333 593.237333 447.829333 535.210667 224.938667 535.210667 224.938667 593.237333Z" p-id="3332"></path><path d="M961.194667 900.266667c3.242667-4.096 3.584-9.728 1.365333-14.336l-101.034667-188.416c10.922667-24.405333 16.896-49.322667 16.896-76.117333 0.512-102.229333-82.090667-185.344-184.490667-185.685333-0.341333 0-0.512 0-0.853333 0-101.888 0-184.661333 82.432-184.832 184.32-0.170667 25.770667 5.290667 51.370667 16.213333 75.946667l0.853333 1.877333-102.912 186.197333c-2.389333 4.437333-2.218667 10.24 1.024 14.336 3.072 4.096 8.362667 5.973333 13.312 4.949333l89.941333-20.309333 30.549333 85.845333c1.706667 4.778667 5.973333 8.192 11.093333 8.704 0.341333 0 0.512 0 0.853333 0l0.170667 0c5.12 0 9.557333-2.56 11.776-6.826667l90.453333-167.082667c16.042667 1.706667 25.258667 1.877333 40.618667 0.341333l90.965333 167.594667c2.218667 4.266667 6.656 6.826667 11.434667 6.826667 0 0 0 0 0.170667 0l0.512 0 0.170667 0 0.512 0c5.12-0.512 9.557333-3.754667 11.434667-8.704l30.890667-85.504 89.770667 20.821333C953.002667 906.24 958.122667 904.362667 961.194667 900.266667L961.194667 900.266667zM567.978667 871.424 567.978667 871.424l-13.824-38.912c-0.853333-2.218667-3.072-3.413333-5.290667-2.901333l-40.96 9.216 52.565333-94.378667c18.261333 18.602667 32.768 27.136 55.466667 39.594667L567.978667 871.424zM692.394667 744.96 692.394667 744.96c-68.778667-0.341333-124.586667-56.661333-124.245333-125.44 0.170667-68.608 55.978667-124.245333 124.757333-124.245333 0.170667 0 0.512 0 0.512 0 68.778667 0.341333 124.586667 56.32 124.245333 125.269333S761.344 744.96 692.394667 744.96zM839.68 842.752 839.68 842.752c-3.072-0.682667-5.973333 1.024-7.168 3.925333l-15.872 44.373333-54.954667-101.034667c25.941333-14.336 43.178667-24.576 64.341333-45.738667l60.245333 109.056L839.68 842.752 839.68 842.752z" p-id="3333"></path><path d="M224.938667 213.504 224.938667 271.701333 682.496 271.701333 682.496 213.504Z" p-id="3334"></path><path d="M815.104 52.736l-689.493333 0c-34.304 0-62.122667 28.842667-62.122667 64.170667l0 733.696c0 35.498667 27.989333 64.170667 62.122667 64.170667l245.76 0 0-58.026667L121.514667 856.746667 121.514667 110.592 819.2 110.592l0 280.576 58.026667 0L877.226667 116.906667C877.226667 81.408 849.237333 52.736 815.104 52.736L815.104 52.736z" p-id="3335"></path><path d="M550.912 432.469333 550.912 374.272 224.938667 374.272 224.938667 432.469333Z" p-id="3336"></path></svg>
          <label style="margin-left: 5px;">资质文件</label>
        </template>

        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="就业资格详情" placement="top">
            <el-button style="margin-left: 30px" type="primary" icon="el-icon-view" @click="graduateQualificationsShow(scope.row)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>

      <el-table-column>
        <template slot="header">
          <svg t="1718826150683" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4464" width="32" height="32"><path d="M809.472 406.016h-2.56c-16.896 0-31.232 5.12-44.544 13.312-11.776-34.304-41.984-59.392-80.896-59.392-16.896 0-33.28 5.12-47.104 13.312-11.776-34.304-41.984-59.392-80.896-59.392-15.36 0-29.184 3.584-41.472 10.24V235.52c0-48.128-36.352-87.552-85.504-87.552-48.64 0-88.064 39.424-88.064 87.552v339.968l-53.76-53.248c-34.304-34.304-95.232-29.184-124.928 0-29.184 29.184-48.64 88.576-6.656 130.56l246.272 244.736c5.12 5.12 10.752 9.216 16.384 12.8 45.056 36.864 96.256 58.368 205.312 58.368 248.832 0 271.872-134.144 271.872-299.52v-175.104c1.024-48.64-34.304-88.064-83.456-88.064z m38.4 262.656c0 139.776-0.512 253.44-225.28 253.44-95.232 0-152.064-20.992-195.584-64l-233.472-231.936c-20.48-20.48-15.36-47.104 1.536-64 16.896-16.896 48.128-17.408 64-1.024 0 0 40.96 40.448 76.288 75.776 26.624 26.624 50.176 49.664 50.176 49.664v-441.856c0-23.04 18.944-41.472 41.984-41.472 23.04 0 38.912 18.432 38.912 41.472v281.088h0.512c-0.512 1.536-0.512 3.072-0.512 4.608 0 12.8 10.24 23.04 23.04 23.04s23.04-10.24 23.04-23.04c0-1.536 0-3.072-0.512-4.608h0.512v-115.2c0-23.04 16.896-41.472 39.936-41.472 0 0 40.96-0.512 40.96 41.472v152.064h0.512c-0.512 1.536-0.512 3.072-0.512 4.608 0 12.8 10.24 23.04 23.04 23.04s23.04-10.24 23.04-23.04c0-1.536 0-3.072-0.512-4.608h0.512v-105.984c0-23.04 16.384-41.472 39.424-41.472 0 0 41.984 2.56 41.984 41.472v133.632h0.512c-0.512 1.536-0.512 3.072-0.512 4.608 0 12.8 10.24 23.04 23.04 23.04s22.528-10.24 22.528-23.04c0-1.536 0-3.072-0.512-4.608h0.512v-91.136c0-23.04 17.408-41.472 40.448-41.472 0 0 40.448-1.536 40.448 41.472 0.512 0 0.512 132.608 0.512 169.472z m-543.232-302.592v-77.312c-7.168-16.384-11.776-34.816-11.776-54.272 0-73.216 59.392-133.12 133.12-133.12 73.216 0 133.12 59.392 133.12 133.12 0 10.24-1.024 19.968-3.072 29.184 16.896 0.512 31.744 7.68 43.008 18.944 4.096-15.36 6.656-31.232 6.656-47.616 0-98.816-80.384-179.2-179.2-179.2s-179.2 80.384-179.2 179.2c-0.512 51.712 22.016 98.304 57.344 131.072z" p-id="4465"></path></svg>
          <label style="margin-left: 5px;">操作</label>
        </template>

        <template slot-scope="scope">
          <el-tooltip class="item" effect="dark" content="审核通过" placement="top" v-if="scope.row.graduateQualificationCheck == '未审核'">
            <el-button type="primary" icon="el-icon-check" circle @click="checkPass(scope.row)"></el-button>
          </el-tooltip>

          <el-tooltip class="item" effect="dark" content="审核未通过" placement="top" v-if="scope.row.graduateQualificationCheck == '未审核'">
            <el-button type="danger" icon="el-icon-close" circle @click="checkOut(scope.row)"></el-button>
          </el-tooltip>

          <el-tooltip class="item" effect="dark" content="重置审核状态" placement="top" v-if="scope.row.graduateQualificationCheck != '未审核'">
            <el-button type="warning" icon="el-icon-refresh-right" circle @click="checkReset(scope.row)"></el-button>
          </el-tooltip>
        </template>
      </el-table-column>

    </el-table>

    <!--界面预览弹窗-->
    <el-dialog :visible.sync="preview.previewDialog" class="demo-image__lazy">
      <el-image v-for="index in preview.previewImageUrls" :key="index" :src="index" lazy></el-image>
    </el-dialog>
  </div>
</template>

<style>

</style>