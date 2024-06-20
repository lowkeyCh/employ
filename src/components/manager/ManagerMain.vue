<script>
  export default {
    mounted() {
      /**
       * 从数据库中查询所有企业并保存在enterpriseLists中
       */
      this.$axios.get('http://localhost:8081/graduate/query_all').then(res=>{
        for(let i = 0; i < res.data.length; i++) {
          this.graduateLists[i].graduateId = res.data[i].graduateId
          this.graduateLists[i].graduateName = res.data[i].graduateName
          this.graduateLists[i].graduateAge = res.data[i].graduateAge
          this.graduateLists[i].graduateSex = res.data[i].graduateSex
          this.graduateLists[i].graduateBirthday = res.data[i].graduateBirthday
          this.graduateLists[i].graduateCollege = res.data[i].graduateCollege
          this.graduateLists[i].graduateGraduateDate = res.data[i].graduateGraduateDate
          this.graduateLists[i].graduateMajor = res.data[i].graduateMajor
          this.graduateLists[i].userId = res.data[i].userId
          this.graduateLists[i].graduatePhone = res.data[i].graduatePhone
          this.graduateLists[i].graduateEmail = res.data[i].graduateEmail
          this.graduateLists[i].graduateQualificationCheck = res.data[i].graduateQualificationCheck
        }
      })
    },

    data() {
      return {
        /**
         * 毕业生个人基本信息集合
         */
        graduateLists: [{
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
      }
    }
  }
</script>

<template>
  <div>
    <div style="padding: 5px 20px 10px 0px">
      <el-input placeholder="企业名称" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
      <el-button type="primary" icon="el-icon-search" style="margin-left: 10px">查询</el-button>
    </div>



    <el-table :data="graduateLists"
              :header-cell-style="{background:'rgba(152,157,159,0.5)',color:'#555555'}"
              border
    >
      <el-table-column align="center" label="ID" width="100" type="index">
      </el-table-column>

      <el-table-column width="300" prop="graduateName">
        <template slot="header">
          <svg t="1718477379784" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11215" width="32" height="32"><path d="M512 447.223c-88.224 0-160-71.776-160-160s71.776-160 160-160c88.225 0 160 71.776 160 160s-71.775 160-160 160z m0-256c-52.935 0-96 43.065-96 96s43.065 96 96 96 96-43.065 96-96-43.065-96-96-96zM454.901 870.594c-96.594 0-184.933-3.802-231.263-49.955C203.308 800.386 193 774.164 193 742.701c0-31.629 10.247-62.812 30.457-92.686 17.978-26.573 42.908-50.741 74.098-71.833C359.256 536.46 437.418 512.53 512 512.53c74.55 0 152.55 23.943 214.002 65.691 31.05 21.094 55.861 45.273 73.746 71.867C819.822 679.937 830 711.096 830 742.701c0 31.552-10.317 57.827-30.664 78.097-50.714 50.521-151.822 50.128-258.88 49.723a7395.45 7395.45 0 0 0-56.914-0.001c-9.605 0.037-19.163 0.074-28.641 0.074zM512 806.447c9.567 0 19.149 0.037 28.701 0.073 49.52 0.191 96.284 0.37 135.808-4.396 38.418-4.633 64.546-13.604 77.659-26.668 5.079-5.06 11.832-13.96 11.832-32.755 0-38.089-27.688-78.744-75.963-111.54C638.933 596.442 574.04 576.53 512 576.53c-126.309 0-255 83.862-255 166.171 0 18.675 6.738 27.547 11.807 32.596 32.045 31.922 128.975 31.55 214.491 31.224 9.556-0.037 19.139-0.074 28.702-0.074z" fill="" p-id="11216"></path></svg>
          <label style="margin-left: 5px;">毕业生姓名</label>
        </template>
      </el-table-column>

      <el-table-column width="300" prop="graduateCollege">
        <template slot="header">
          <svg t="1718477095303" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6634" width="32" height="32"><path d="M440.832 785.408v29.696H583.68v-29.696h-24.576v-296.96h24.576v-29.696H440.32v29.696h24.576v297.472h-24.064zM169.472 785.408v29.696H312.32v-29.696h-24.576v-296.96H312.32v-29.696H169.472v29.696h24.576v297.472h-24.576zM711.68 785.408v29.696h142.848v-29.696h-24.576v-296.96h24.576v-29.696H711.68v29.696h24.576v297.472H711.68z" fill="#AEC9FF" p-id="6635"></path><path d="M102.4 871.936v12.288c-0.512 9.728 7.168 17.92 16.896 18.432h786.432c9.728-0.512 16.896-8.704 16.384-18.432v-12.288c0.512-9.728-7.168-17.92-16.384-18.432H118.784c-9.728 0-16.896 8.704-16.384 18.432zM966.656 934.912H57.344c-9.728 0.512-16.896 8.704-16.896 18.432v12.288c-0.512 9.728 7.168 17.92 16.896 18.432h909.312c9.728-0.512 16.896-8.704 16.896-18.432v-12.288c0-9.728-7.168-17.92-16.896-18.432zM89.6 424.448h844.8c7.68-0.512 14.848-5.632 16.384-13.312 2.56-7.68 0-16.384-6.144-22.016L522.24 43.52c-5.632-5.12-14.336-5.12-20.48 0L79.36 389.12c-6.144 5.632-8.704 13.824-6.144 22.016 2.048 7.168 8.704 12.8 16.384 13.312zM512.512 174.08c37.376 0 67.072 33.792 67.072 75.776s-30.208 75.776-67.072 75.776c-36.864 0-67.584-33.792-67.584-75.776S475.136 174.08 512.512 174.08z" fill="#3366FF" p-id="6636"></path></svg>
          <label style="margin-left: 5px;">毕业院校</label>
        </template>
      </el-table-column>

      <el-table-column width="300" prop="graduateMajor">
        <template slot="header">
          <svg t="1718477186983" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7792" width="32" height="32"><path d="M1024 248.512L775.168 0l-266.24 265.856L250.56 7.68 0 257.92l258.496 258.112L87.36 686.912l-65.92 285.44a23.488 23.488 0 0 0 28.16 28.224l286.592-65.088 171.136-170.88L767.168 1024l250.496-250.176-259.84-259.52L1024 248.512zM250.496 113.408l204.096 203.776-145.152 144-23.36-23.296 46.272-46.272a37.312 37.312 0 0 0-52.864-52.8l-46.336 46.208-38.08-38.016 46.336-46.208a37.312 37.312 0 1 0-52.928-52.864l-46.272 46.272-36.416-36.352 144.64-144.448z m516.672 804.928l-37.184-37.12 46.272-46.272a37.312 37.312 0 0 0-52.928-52.864l-46.272 46.272-38.08-38.016 46.336-46.208a37.312 37.312 0 0 0-52.864-52.864l-46.336 46.272-24.96-25.024 144.128-144.96 206.592 206.272-144.64 144.512z m151.04-669.824l-56.256 56.128-143.04-142.848 56.32-56.128 142.976 142.848zM112.64 909.568l42.752-184.96 12.16-12.16 142.976 142.848-11.968 11.968-185.92 42.24z" p-id="7793"></path></svg>
          <label style="margin-left: 5px;">所学专业</label>
        </template>
      </el-table-column>

      <el-table-column>
        <template slot="header">
          <svg t="1718826150683" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4464" width="32" height="32"><path d="M809.472 406.016h-2.56c-16.896 0-31.232 5.12-44.544 13.312-11.776-34.304-41.984-59.392-80.896-59.392-16.896 0-33.28 5.12-47.104 13.312-11.776-34.304-41.984-59.392-80.896-59.392-15.36 0-29.184 3.584-41.472 10.24V235.52c0-48.128-36.352-87.552-85.504-87.552-48.64 0-88.064 39.424-88.064 87.552v339.968l-53.76-53.248c-34.304-34.304-95.232-29.184-124.928 0-29.184 29.184-48.64 88.576-6.656 130.56l246.272 244.736c5.12 5.12 10.752 9.216 16.384 12.8 45.056 36.864 96.256 58.368 205.312 58.368 248.832 0 271.872-134.144 271.872-299.52v-175.104c1.024-48.64-34.304-88.064-83.456-88.064z m38.4 262.656c0 139.776-0.512 253.44-225.28 253.44-95.232 0-152.064-20.992-195.584-64l-233.472-231.936c-20.48-20.48-15.36-47.104 1.536-64 16.896-16.896 48.128-17.408 64-1.024 0 0 40.96 40.448 76.288 75.776 26.624 26.624 50.176 49.664 50.176 49.664v-441.856c0-23.04 18.944-41.472 41.984-41.472 23.04 0 38.912 18.432 38.912 41.472v281.088h0.512c-0.512 1.536-0.512 3.072-0.512 4.608 0 12.8 10.24 23.04 23.04 23.04s23.04-10.24 23.04-23.04c0-1.536 0-3.072-0.512-4.608h0.512v-115.2c0-23.04 16.896-41.472 39.936-41.472 0 0 40.96-0.512 40.96 41.472v152.064h0.512c-0.512 1.536-0.512 3.072-0.512 4.608 0 12.8 10.24 23.04 23.04 23.04s23.04-10.24 23.04-23.04c0-1.536 0-3.072-0.512-4.608h0.512v-105.984c0-23.04 16.384-41.472 39.424-41.472 0 0 41.984 2.56 41.984 41.472v133.632h0.512c-0.512 1.536-0.512 3.072-0.512 4.608 0 12.8 10.24 23.04 23.04 23.04s22.528-10.24 22.528-23.04c0-1.536 0-3.072-0.512-4.608h0.512v-91.136c0-23.04 17.408-41.472 40.448-41.472 0 0 40.448-1.536 40.448 41.472 0.512 0 0.512 132.608 0.512 169.472z m-543.232-302.592v-77.312c-7.168-16.384-11.776-34.816-11.776-54.272 0-73.216 59.392-133.12 133.12-133.12 73.216 0 133.12 59.392 133.12 133.12 0 10.24-1.024 19.968-3.072 29.184 16.896 0.512 31.744 7.68 43.008 18.944 4.096-15.36 6.656-31.232 6.656-47.616 0-98.816-80.384-179.2-179.2-179.2s-179.2 80.384-179.2 179.2c-0.512 51.712 22.016 98.304 57.344 131.072z" p-id="4465"></path></svg>
          <label style="margin-left: 5px;">操作</label>
        </template>
        <el-tooltip class="item" effect="dark" content="查看详细信息" placement="top">
          <el-button type="primary" icon="el-icon-more" circle></el-button>
        </el-tooltip>

        <el-tooltip class="item" effect="dark" content="删除当前毕业生" placement="top">
          <el-button type="danger" icon="el-icon-delete" circle></el-button>
        </el-tooltip>
      </el-table-column>

    </el-table>
  </div>
</template>

<style scoped>

</style>