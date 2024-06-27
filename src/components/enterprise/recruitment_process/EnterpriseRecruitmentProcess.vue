<template>
  <div>
    <div style="width:90%; margin-left:auto; margin-right:auto; margin-top: 20px">
      <el-steps :active="tableData.rpPhaseId">
        <el-step title="简历投递" icon="el-icon-user-solid" description=""></el-step>
        <el-step title="个人资料审核" icon="el-icon-document-copy" description=""></el-step>
        <el-step title="面试" icon="el-icon-s-comment" description=""></el-step>
        <el-step title="就业协议书" icon="el-icon-document-checked" description=""></el-step>
        <el-step title="招聘完成" icon="el-icon-success" description=""></el-step>
      </el-steps>
    </div>

    <div style="margin-top: 20px;" v-show="stepsShow.firstShow">
      <el-card>
        <el-descriptions class="margin-top" title="毕业生基本资料" :column="2" border>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477379784" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="11215" width="32" height="32"><path d="M512 447.223c-88.224 0-160-71.776-160-160s71.776-160 160-160c88.225 0 160 71.776 160 160s-71.775 160-160 160z m0-256c-52.935 0-96 43.065-96 96s43.065 96 96 96 96-43.065 96-96-43.065-96-96-96zM454.901 870.594c-96.594 0-184.933-3.802-231.263-49.955C203.308 800.386 193 774.164 193 742.701c0-31.629 10.247-62.812 30.457-92.686 17.978-26.573 42.908-50.741 74.098-71.833C359.256 536.46 437.418 512.53 512 512.53c74.55 0 152.55 23.943 214.002 65.691 31.05 21.094 55.861 45.273 73.746 71.867C819.822 679.937 830 711.096 830 742.701c0 31.552-10.317 57.827-30.664 78.097-50.714 50.521-151.822 50.128-258.88 49.723a7395.45 7395.45 0 0 0-56.914-0.001c-9.605 0.037-19.163 0.074-28.641 0.074zM512 806.447c9.567 0 19.149 0.037 28.701 0.073 49.52 0.191 96.284 0.37 135.808-4.396 38.418-4.633 64.546-13.604 77.659-26.668 5.079-5.06 11.832-13.96 11.832-32.755 0-38.089-27.688-78.744-75.963-111.54C638.933 596.442 574.04 576.53 512 576.53c-126.309 0-255 83.862-255 166.171 0 18.675 6.738 27.547 11.807 32.596 32.045 31.922 128.975 31.55 214.491 31.224 9.556-0.037 19.139-0.074 28.702-0.074z" fill="" p-id="11216"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 毕业生姓名</label>
            </template>
            <label class="show">{{ graduate.graduateName }}</label>
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477095303" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6634" width="32" height="32"><path d="M440.832 785.408v29.696H583.68v-29.696h-24.576v-296.96h24.576v-29.696H440.32v29.696h24.576v297.472h-24.064zM169.472 785.408v29.696H312.32v-29.696h-24.576v-296.96H312.32v-29.696H169.472v29.696h24.576v297.472h-24.576zM711.68 785.408v29.696h142.848v-29.696h-24.576v-296.96h24.576v-29.696H711.68v29.696h24.576v297.472H711.68z" fill="#AEC9FF" p-id="6635"></path><path d="M102.4 871.936v12.288c-0.512 9.728 7.168 17.92 16.896 18.432h786.432c9.728-0.512 16.896-8.704 16.384-18.432v-12.288c0.512-9.728-7.168-17.92-16.384-18.432H118.784c-9.728 0-16.896 8.704-16.384 18.432zM966.656 934.912H57.344c-9.728 0.512-16.896 8.704-16.896 18.432v12.288c-0.512 9.728 7.168 17.92 16.896 18.432h909.312c9.728-0.512 16.896-8.704 16.896-18.432v-12.288c0-9.728-7.168-17.92-16.896-18.432zM89.6 424.448h844.8c7.68-0.512 14.848-5.632 16.384-13.312 2.56-7.68 0-16.384-6.144-22.016L522.24 43.52c-5.632-5.12-14.336-5.12-20.48 0L79.36 389.12c-6.144 5.632-8.704 13.824-6.144 22.016 2.048 7.168 8.704 12.8 16.384 13.312zM512.512 174.08c37.376 0 67.072 33.792 67.072 75.776s-30.208 75.776-67.072 75.776c-36.864 0-67.584-33.792-67.584-75.776S475.136 174.08 512.512 174.08z" fill="#3366FF" p-id="6636"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 毕业院校</label>
            </template>
            {{ graduate.graduateCollege }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477186983" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="7792" width="32" height="32"><path d="M1024 248.512L775.168 0l-266.24 265.856L250.56 7.68 0 257.92l258.496 258.112L87.36 686.912l-65.92 285.44a23.488 23.488 0 0 0 28.16 28.224l286.592-65.088 171.136-170.88L767.168 1024l250.496-250.176-259.84-259.52L1024 248.512zM250.496 113.408l204.096 203.776-145.152 144-23.36-23.296 46.272-46.272a37.312 37.312 0 0 0-52.864-52.8l-46.336 46.208-38.08-38.016 46.336-46.208a37.312 37.312 0 1 0-52.928-52.864l-46.272 46.272-36.416-36.352 144.64-144.448z m516.672 804.928l-37.184-37.12 46.272-46.272a37.312 37.312 0 0 0-52.928-52.864l-46.272 46.272-38.08-38.016 46.336-46.208a37.312 37.312 0 0 0-52.864-52.864l-46.336 46.272-24.96-25.024 144.128-144.96 206.592 206.272-144.64 144.512z m151.04-669.824l-56.256 56.128-143.04-142.848 56.32-56.128 142.976 142.848zM112.64 909.568l42.752-184.96 12.16-12.16 142.976 142.848-11.968 11.968-185.92 42.24z" p-id="7793"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 所学专业</label>
            </template>
            {{ graduate.graduateMajor }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477233983" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8841" width="32" height="32"><path d="M312.888889 113.777778h56.888889v56.888889h-56.888889zM483.555556 113.777778h56.888888v56.888889h-56.888888zM654.222222 113.777778h56.888889v56.888889h-56.888889zM312.888889 227.555556h56.888889v199.111111h-56.888889zM483.555556 227.555556h56.888888v199.111111h-56.888888zM654.222222 227.555556h56.888889v199.111111h-56.888889z" fill="#333C40" p-id="8842"></path><path d="M824.888889 853.333333V483.555556a28.444444 28.444444 0 0 0-28.444445-28.444445H227.555556a28.444444 28.444444 0 0 0-28.444445 28.444445v369.777777h625.777778zM227.555556 398.222222h568.888888a85.333333 85.333333 0 0 1 85.333334 85.333334v426.666666H142.222222V483.555556a85.333333 85.333333 0 0 1 85.333334-85.333334z" fill="#333C40" p-id="8843"></path><path d="M28.444444 853.333333h967.111112v56.888889H28.444444z" fill="#333C40" p-id="8844"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 年龄</label>
            </template>
            {{ graduate.graduateAge }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477284102" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="10161" width="32" height="32"><path d="M416 221.6C416 152.9 360.1 97 291.4 97s-124.6 55.9-124.6 124.6 55.9 124.6 124.6 124.6S416 290.4 416 221.6z" fill="#1375FF" p-id="10162"></path><path d="M227 356.4c-90.4 28.7-149.5 116-149.5 210.9v150.4c0 7.4 6 13.4 13.4 13.4h72.3v181.7c0 6.2 5 11.2 11.2 11.2h234.8c6.2 0 11.2-5 11.2-11.2V731.1h55.8c16.5 0 29.9-13.5 29.9-29.9V554c0.1-135.9-140.3-241.7-279.1-197.6z m646-93.2c0-68.7-55.9-124.6-124.6-124.6-68.7 0-124.6 55.9-124.6 124.6s55.9 124.6 124.6 124.6c68.7 0 124.6-55.9 124.6-124.6zM947 751.6l-63-247.4c-13.7-67.4-74-116.4-143.5-116.4s-129.8 49-143 114.1L534 751.6c-3.1 12.3-0.4 25.2 7.3 35.3 7.7 10.1 19.5 16 32.1 16.3 0 0 30.9 0.6 55.3 0.8 7.9 23.5 19.6 58.2 30.2 91.8 5.3 16.9 21 28.3 38.7 28.3h85.9c17.5 0 33.1-11.3 38.4-28.1 10.6-33.7 22.4-69.3 30.3-92.9 24.4-0.1 55.3-0.3 55.3-0.3 12.6-0.3 24.5-6 32.1-16.1 7.8-10.1 10.5-22.8 7.4-35.1z" fill="#1375FF" p-id="10163"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 性别</label>
            </template>
            <el-tag size="small">{{ graduate.graduateSex }}</el-tag>
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477453809" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="12332" width="32" height="32"><path d="M838.954667 234.666667H170.666667c-3.626667 0-7.168 0.448-10.56 1.322666l323.690666 323.669334a21.333333 21.333333 0 0 0 30.165334 0L838.954667 234.666667z m46.144 14.186666l-260.693334 260.693334 262.933334 262.912c5.44-7.168 8.661333-16.106667 8.661333-25.792V277.333333c0-10.944-4.117333-20.906667-10.88-28.48zM843.861333 789.333333l-249.6-249.621333-50.133333 50.133333a64 64 0 0 1-90.517333 0l-50.112-50.133333L156.373333 786.88c4.48 1.578667 9.28 2.453333 14.314667 2.453333h673.194667zM128.661333 754.218667L373.333333 509.525333 129.578667 265.813333A42.709333 42.709333 0 0 0 128 277.333333v469.333334c0 2.56 0.213333 5.098667 0.661333 7.552zM170.666667 192h682.666666a85.333333 85.333333 0 0 1 85.333334 85.333333v469.333334a85.333333 85.333333 0 0 1-85.333334 85.333333H170.666667a85.333333 85.333333 0 0 1-85.333334-85.333333V277.333333a85.333333 85.333333 0 0 1 85.333334-85.333333z" fill="#333333" p-id="12333"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 邮箱地址</label>
            </template>
            {{ graduate.graduateEmail }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477474092" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="13426" width="32" height="32"><path d="M820.409449 797.228346q0 25.19685-10.07874 46.866142t-27.716535 38.299213-41.322835 26.204724-50.897638 9.574803l-357.795276 0q-27.212598 0-50.897638-9.574803t-41.322835-26.204724-27.716535-38.299213-10.07874-46.866142l0-675.275591q0-25.19685 10.07874-47.370079t27.716535-38.80315 41.322835-26.204724 50.897638-9.574803l357.795276 0q27.212598 0 50.897638 9.574803t41.322835 26.204724 27.716535 38.80315 10.07874 47.370079l0 675.275591zM738.771654 170.330709l-455.559055 0 0 577.511811 455.559055 0 0-577.511811zM510.992126 776.062992q-21.165354 0-36.787402 15.11811t-15.622047 37.291339q0 21.165354 15.622047 36.787402t36.787402 15.622047q22.173228 0 37.291339-15.622047t15.11811-36.787402q0-22.173228-15.11811-37.291339t-37.291339-15.11811zM591.622047 84.661417q0-8.062992-5.03937-12.598425t-11.086614-4.535433l-128 0q-5.03937 0-10.582677 4.535433t-5.543307 12.598425 5.03937 12.598425 11.086614 4.535433l128 0q6.047244 0 11.086614-4.535433t5.03937-12.598425z" p-id="13427"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 手机号码</label>
            </template>
            {{ graduate.graduatePhone }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477522475" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="14540" width="32" height="32"><path d="M853.34016 830.52544H199.24992V270.06976h654.09024v560.45568z m-613.13024-40.96h572.17024V311.02976H240.20992v478.53568z" fill="#070606" p-id="14541"></path><path d="M317.44 165.10976h40.96v245.76h-40.96zM698.88 165.10976h40.96v245.76h-40.96zM219.72992 463.5648h613.13024v40.96H219.72992z" fill="#070606" p-id="14542"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 出生日期</label>
            </template>
            {{ graduate.graduateBirthday }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1718477568038" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="18089" width="32" height="32"><path d="M462.592 103.808c17.856-4.544 35.2-7.808 49.408-7.808 14.208 0 31.552 3.2 49.408 7.808 18.432 4.672 39.552 11.328 62.08 19.328 44.928 15.936 96.768 37.696 145.92 61.184 49.024 23.424 96.32 49.088 131.84 72.96 17.6 11.904 33.408 24.064 45.184 35.968 5.888 5.952 11.52 12.608 15.808 19.84 4.224 7.04 8.448 16.768 8.448 28.224 0 11.52-4.224 21.12-8.448 28.224a106.496 106.496 0 0 1-15.808 19.84c-10.56 10.752-24.32 21.568-39.808 32.256v276.224c3.648 8.128 8.32 16.832 14.016 27.52v0.128c3.84 7.04 8 14.848 12.608 23.936 12.288 24.064 25.6 53.12 33.472 86.4 5.312 22.144 8.448 51.456-12.416 72.384a64.64 64.64 0 0 1-32.448 16.768 158.08 158.08 0 0 1-33.728 3.008h-26.88c-11.584 0-23.232-0.64-33.792-3.008a64.64 64.64 0 0 1-32.448-16.768c-20.864-20.928-17.728-50.24-12.416-72.384 7.872-33.28 21.12-62.336 33.472-86.4 4.608-9.088 8.832-17.024 12.608-24.064 5.76-10.624 10.368-19.392 13.952-27.52V460.8a1559.68 1559.68 0 0 1-219.2 98.752c-22.4 7.936-43.52 14.592-62.016 19.328-17.856 4.48-35.2 7.808-49.408 7.808-14.208 0-31.552-3.264-49.408-7.808a728.32 728.32 0 0 1-62.08-19.328c-44.928-16-96.832-37.76-145.92-61.184-49.024-23.488-96.32-49.088-131.84-72.96a300.608 300.608 0 0 1-45.184-35.968 106.56 106.56 0 0 1-15.808-19.904 55.36 55.36 0 0 1-8.448-28.16c0-11.52 4.224-21.184 8.448-28.224 4.288-7.296 9.92-13.952 15.808-19.84 11.776-11.968 27.52-24.128 45.184-36.032 35.52-23.872 82.816-49.536 131.84-72.96a1559.424 1559.424 0 0 1 145.92-61.184c22.528-8 43.648-14.656 62.08-19.328z" fill="#333333" p-id="18090"></path><path d="M644.864 619.84c-23.68 8.384-46.72 15.744-67.584 21.056-19.2 4.864-42.88 9.792-65.28 9.792s-45.952-4.928-65.216-9.792a793.28 793.28 0 0 1-67.584-21.056 1564.864 1564.864 0 0 1-119.168-48.384 21.696 21.696 0 0 0-30.72 20.48l5.248 119.04c0.256 5.952 0.96 13.824 3.456 22.08 5.824 19.328 17.28 38.912 36.352 52.608 28.608 20.48 66.56 34.496 106.88 43.52a610.816 610.816 0 0 0 130.816 13.44c44.8 0 90.112-4.416 130.816-13.44 40.32-9.024 78.208-23.04 106.816-43.52a99.2 99.2 0 0 0 36.352-52.608c2.56-8.32 3.2-16.128 3.456-22.144l5.248-118.976a21.696 21.696 0 0 0-30.72-20.48c-40.64 18.368-81.92 35.2-119.168 48.384z" fill="#333333" p-id="18091"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 毕业日期</label>
            </template>
            {{ graduate.graduateGraduateDate }}
          </el-descriptions-item>


          <el-descriptions-item>
            <template slot="label">
              <svg t="1719507021790" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6273" width="32" height="32"><path d="M0 512a512 512 0 1 0 1024 0A512 512 0 1 0 0 512z" fill="#06B666" p-id="6274"></path><path d="M702.922 268.414H321.078a34.891 34.891 0 0 0-34.891 34.761v418.173a34.891 34.891 0 0 0 34.891 34.76h381.844a34.891 34.891 0 0 0 34.891-34.76V303.175a34.891 34.891 0 0 0-34.891-34.76z m-295.857 87.033H616.15a17.38 17.38 0 0 1 0 34.76H407.065a17.38 17.38 0 1 1 0-34.76z m0 69.52H616.15a17.511 17.511 0 0 1 0 34.892H407.065a17.511 17.511 0 1 1 0-34.891z m69.652 104.544h-69.652a17.511 17.511 0 1 1 0-34.891h69.521a17.511 17.511 0 0 1 0 34.891z m193.666 59.72l-46.653 34.5 16.597 55.8a5.62 5.62 0 0 1-1.96 5.88 5.489 5.489 0 0 1-3.137 0.915 6.273 6.273 0 0 1-3.005-0.915l-47.698-33.323-48.09 32.67a2.352 2.352 0 0 1-1.438 0h-2.613l-1.568-0.785a5.489 5.489 0 0 1-1.83-5.75l17.12-55.015-46.653-35.153a5.096 5.096 0 0 1-1.83-5.75 5.358 5.358 0 0 1 4.966-3.659h58.544l1.83-5.358 17.51-49.004a5.227 5.227 0 0 1 4.967-3.529 5.62 5.62 0 0 1 4.965 3.529l16.989 49.396 1.83 5.358h28.487l29.795 0.784a5.358 5.358 0 0 1 4.835 3.66 5.227 5.227 0 0 1-1.96 5.75z" fill="#FFFFFF" p-id="6275"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 企业用人资格</label>
            </template>
            <el-tooltip class="item" effect="dark" content="用人资格详情" placement="top">
              <el-button style="margin-left: 30px" type="primary" icon="el-icon-view" @click="graduateQualificationsShow"></el-button>
            </el-tooltip>
          </el-descriptions-item>

        </el-descriptions>
      </el-card>

      <!--界面预览弹窗-->
      <el-dialog :visible.sync="preview.previewDialog" class="demo-image__lazy">
        <el-image v-for="index in preview.previewImageUrls" :key="index" :src="index" lazy></el-image>
      </el-dialog>

      <el-button @click="firstOff" type="danger" style="color:black; font-size: 20px; width: 200px; height: 66px; margin-top: 50px; margin-right: 20px; float: right">
        审核未通过
      </el-button>

      <el-button @click="firstOk" type="success" style="color:black; font-size: 20px; width: 200px; height: 66px; margin-top: 50px; margin-right: 20px; float: right">
        审核通过
      </el-button>
    </div>

    <div v-show="stepsShow.secondShow">

      <div id="container">
      </div>
      <el-button type="primary" @click="faceLocate" style="margin-left: 60px; height: 66px;">
        确定面试地点: {{ recruitmentProcess.rpFaceLocation }}
      </el-button>
      <el-button @click="firstOff" type="danger" style="color:black; font-size: 20px; width: 200px; height: 66px; margin-top: 70px; margin-right: 20px; float: right">
        面试未通过
      </el-button>
      <el-button @click="secondOk" type="success" style="color:black; font-size: 20px; width: 200px; height: 66px; margin-top: 70px; margin-right: 20px; float: right">
        面试通过
      </el-button>
    </div>

    <div style="margin-top: 20px;" v-show="stepsShow.thirdShow">
      <el-card>
        <el-descriptions class="margin-top" title="上传就业协议书" :column="2" border>
          <el-descriptions-item>
            <template slot="label">
              <svg t="1719520900385" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4250" width="32" height="32"><path d="M360.448 286.72c4.096 0 8.192-4.096 12.288-4.096L491.52 159.744l0 598.016c0 12.288 8.192 20.48 20.48 20.48 12.288 0 20.48-8.192 20.48-20.48L532.48 159.744l118.784 118.784C651.264 282.624 659.456 286.72 663.552 286.72c12.288 0 20.48-8.192 20.48-20.48 0-4.096-4.096-8.192-4.096-12.288l-151.552-151.552c-4.096-4.096-8.192-4.096-12.288-4.096-4.096 0-8.192 4.096-12.288 4.096L348.16 253.952C344.064 258.048 339.968 262.144 339.968 266.24 339.968 278.528 352.256 286.72 360.448 286.72z" p-id="4251"></path><path d="M794.624 360.448l-208.896 0c-12.288 0-20.48 8.192-20.48 20.48 0 12.288 8.192 20.48 20.48 20.48L778.24 401.408l0 491.52L245.76 892.928l0-491.52 188.416 0c12.288 0 20.48-8.192 20.48-20.48 0-12.288-8.192-20.48-20.48-20.48L229.376 360.448C217.088 360.448 208.896 368.64 208.896 380.928l0 528.384c0 12.288 8.192 20.48 20.48 20.48l565.248 0c12.288 0 20.48-8.192 20.48-20.48L815.104 380.928C815.104 368.64 806.912 360.448 794.624 360.448z" p-id="4252"></path></svg>
              <label style="font-weight: bolder; font-size: large"> 上传</label>
            </template>
            <el-upload
                action=""
                :http-request="upload"
                :on-remove="remove"
                multiple
                :file-list="fileList"
                v-if="fileListShow"
            >
              <el-button size="small" type="primary">点击上传</el-button>
              <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
          </el-descriptions-item>
        </el-descriptions>
      </el-card>

      <el-button v-if="this.fileList.length != 0" type="info" :loading="true" style="color:black; font-size: 20px; width: 300px; height: 66px; margin-top: 70px; margin-right: 20px; float: right">
        毕业生签字中
      </el-button>

      <el-button v-if="this.fileList.length == 0" type="info" :loading="true" style="color:black; font-size: 20px; width: 300px; height: 66px; margin-top: 70px; margin-right: 20px; float: right">
        请上传就业协议书
      </el-button>
    </div>

    <div style="margin-top: 200px; margin-left: 550px; "  v-show="stepsShow.fourthShow">
      <svg t="1719525633630" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="4473" width="200" height="200"><path d="M135.168 209.408c3.072-9.216 13.824-14.336 23.04-11.264l121.344 41.472c16.896 6.144 34.816 14.848 53.76 12.288 11.776-1.024 22.016-7.168 32.768-11.776 23.04-10.752 50.688-12.8 75.264-4.096 78.848 26.624 157.184 53.76 235.52 80.896 5.12 1.536 10.24 4.096 13.312 8.704 4.096 5.12 3.072 12.288 2.048 18.432-3.072 20.48-11.264 41.472-27.648 55.296-14.336 13.312-35.328 17.408-54.784 14.336-8.704-1.536-17.408-3.072-25.6-6.144-27.648-9.216-55.808-18.944-83.456-28.16C487.424 409.6 466.944 438.272 438.784 455.68c-24.576 15.872-54.272 22.528-82.944 20.48-19.456-1.024-38.4-5.632-56.832-11.776-5.632-2.048-10.752-6.144-11.776-12.288-3.072-8.704 3.584-19.456 12.8-21.504 7.168-2.048 13.824 1.536 20.48 3.072 28.672 8.704 60.928 10.24 89.088-2.56 27.136-12.8 46.592-37.888 58.88-65.024 3.584-8.192 4.608-17.92 12.288-24.064 5.12-4.096 12.288-4.096 17.92-2.048 30.72 10.24 61.952 20.992 92.672 31.744 13.824 4.608 29.184 10.24 43.52 4.608 12.288-4.096 18.944-17.408 22.016-29.696-74.752-25.6-148.992-51.2-223.744-76.8-10.752-3.584-22.528-5.632-33.792-3.584-13.824 2.048-25.6 10.24-38.4 14.848-23.552 8.704-49.664 7.168-73.216-2.048-32.768 94.208-65.024 188.928-97.792 283.136-3.072 9.216-13.312 15.36-22.528 11.776-40.448-13.312-80.384-27.648-120.832-40.96-4.096-1.536-8.704-3.584-11.264-7.68-4.608-5.632-4.096-13.824-1.536-20.48 33.28-97.28 67.072-196.608 101.376-295.424z m-49.664 253.952c-4.608 14.336-10.24 28.16-14.336 42.496 30.208 9.728 59.904 20.48 89.6 30.208 30.208-89.088 60.928-178.688 91.648-267.776-29.696-10.24-59.904-20.48-89.6-30.72-26.112 75.264-51.2 150.528-77.312 225.792z" p-id="4474"></path><path d="M822.784 203.264c6.144-3.072 13.312-6.144 19.968-2.56 7.68 3.072 10.24 11.264 13.824 17.92 43.52 88.576 87.04 177.664 131.072 266.24 2.56 5.632 6.656 11.264 5.632 17.408 0 6.144-4.608 11.776-10.24 14.848-35.84 17.408-71.68 35.328-107.52 52.224-3.072 1.536-6.656 3.072-9.216 5.632-25.088 24.064-50.688 47.104-77.312 69.632-28.672 22.016-58.88 43.008-91.136 59.392-22.528 12.288-45.568 23.04-68.096 34.304-54.272 26.624-108.032 52.736-162.304 79.36-8.704 4.608-18.432 8.704-28.672 9.216-23.04 1.536-46.592-12.288-54.784-33.792-2.048-5.12-3.072-10.752-4.096-16.384-12.8 6.656-26.624 13.312-41.984 11.264-28.16-2.048-51.712-28.16-50.176-56.32-18.944-0.512-37.888-10.752-47.104-27.648-11.776-18.944-9.728-44.032 3.584-61.44-7.68-6.656-14.848-14.336-18.432-24.064-7.68-19.456-3.584-43.008 11.264-58.368 5.632-6.656 13.312-10.24 20.992-14.336 24.576-11.776 49.152-24.064 73.728-35.84 5.12-2.56 10.752-5.632 16.384-4.608 9.728 1.024 17.92 11.776 14.848 20.992-1.536 8.192-9.216 12.288-16.384 15.36L271.36 578.56c-7.168 3.072-13.312 9.728-13.312 17.92-1.024 12.8 12.8 24.064 25.088 20.48 5.632-2.048 10.24-4.608 15.36-7.168 49.152-24.064 98.816-48.64 147.968-72.192 8.192-4.608 18.432-0.512 23.552 7.168 3.072 6.144 2.56 14.336-2.048 19.968-5.12 5.12-11.776 7.168-17.92 10.24C394.24 603.136 337.92 629.76 281.6 657.408c-7.168 3.584-13.824 10.752-12.8 19.456 0 9.216 7.68 16.896 16.384 18.944 7.68 1.536 14.336-3.072 20.48-6.144 61.952-30.208 123.904-60.928 185.856-91.136 4.608-2.048 9.216-5.12 14.336-5.12 10.24-0.512 19.456 9.728 17.408 19.968-0.512 6.144-4.608 10.752-9.728 13.824-58.88 28.672-117.76 57.856-177.152 86.528-7.168 3.584-13.312 10.752-13.312 18.944 0 13.312 15.872 24.064 28.16 17.92 60.928-29.696 122.368-59.904 183.296-89.6 8.704-5.12 20.992-1.024 25.088 8.192 2.56 4.096 1.536 8.704 0.512 13.312-2.56 4.096-5.632 8.192-10.24 10.24-39.936 19.456-80.384 38.912-120.32 58.88-7.68 3.584-15.36 10.752-14.848 19.968-0.512 13.824 16.384 24.576 28.672 17.92 61.952-30.208 123.392-60.416 184.832-90.624 25.6-12.288 51.2-24.576 75.776-38.912 23.552-14.848 47.104-30.208 68.608-48.64 22.016-18.432 42.496-37.888 64-57.344-44.032-90.624-89.088-181.248-133.12-271.872-5.12-8.704-1.024-20.992 8.192-25.088 37.376-17.92 74.24-35.84 111.104-53.76z m-79.872 78.848c41.472 84.48 82.432 168.96 123.904 253.44l84.48-41.472c-40.96-84.48-82.944-168.448-123.392-253.44-28.672 13.312-56.832 27.136-84.992 41.472z" p-id="4475"></path><path d="M85.504 463.36c26.112-75.264 51.712-150.528 77.824-225.792 29.696 10.24 59.904 19.968 89.6 30.72-30.72 89.088-61.44 178.688-91.648 267.776-29.696-10.24-59.904-20.48-89.6-30.208 3.584-14.848 9.216-28.16 13.824-42.496z" fill="#A7A9AC" p-id="4476"></path><path d="M742.912 282.112c28.16-13.824 56.32-28.16 84.992-41.472 40.96 84.48 82.432 168.448 123.392 253.44-28.16 13.824-56.32 27.136-84.48 41.472-41.472-84.48-82.432-168.96-123.904-253.44z" fill="#3C92CA" p-id="4477"></path>
      </svg>
      <label style="display: block; margin-left: 45px; color: green; font-size: larger">此次招聘完成</label>
    </div>
  </div>


</template>

<script>
import AMapLoader from '@amap/amap-jsapi-loader';

export default {
  mounted() {
    /**
     * 挂载阶段调用，DOM初始化完成进行地图初始化
     */
    this.initMap();

    /**
     * 获取用户id并根据用户id获取企业基本信息
     */
    let userId = JSON.parse(localStorage.getItem("user")).user.userId
    this.$axios.get('http://localhost:8081/enterprise/query?userId='+ userId).then(res=> {
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
      } else {
        /**
         * 如果未选择某一招聘过程就进入
         */
        if(this.$route.query.rpId == undefined) {
          const loading = this.$loading({
            lock: true,
            background: 'rgba(0, 0, 0, 0.7)'
          })

          setTimeout(() => {
            loading.close();
            this.$router.push('/EnterpriseENGraduates');
            this.$notify({
              title: '提示',
              message: '请选择某位毕业生',
              iconClass: 'el-icon-user'
            })
          }, 1000);
        } else {
          this.$axios.get('http://localhost:8081/rp/query_by_rp_id?rpId=' + this.$route.query.rpId).then(res=> {
            this.recruitmentProcess = {
              rpId: res.data.rpId,
              graduateId: res.data.graduateId,
              enId: res.data.enId,
              rpPhase: res.data.rpPhase,
              rpCheck: res.data.rpCheck,
              rpFaceLocation: res.data.rpFaceLocation,
              rpWorkFile: res.data.rpWorkFile
            }

            if(this.recruitmentProcess.rpWorkFile != '' && this.recruitmentProcess.rpWorkFile != undefined && this.recruitmentProcess.rpWorkFile != null) {
              this.recruitmentProcess.rpWorkFile.split(',').forEach(file => {
                console.log(file)
                if(file != '' && file != undefined && file != null) {
                  this.fileList[this.fileList.length] = {
                    name: file,
                    url: "http://localhost:8081/" + file,
                  }
                }
              })

              /**
               * 重新渲染el-upload
               */
              // 移除组件
              this.fileListShow = false
              // 在组件移除后，重新渲染组件
              // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
              this.$nextTick(() => {
                this.fileListShow = true
              })
            }



            if(this.recruitmentProcess.rpPhase == '简历投递') {
              this.tableData.rpPhaseId = 1
              this.stepsShow.firstShow = true
            } else if(this.recruitmentProcess.rpPhase == '个人资料审核') {
              this.tableData.rpPhaseId = 2
              this.stepsShow.secondShow = true
            } else if(this.recruitmentProcess.rpPhase == '面试') {
              this.tableData.rpPhaseId = 3
              this.stepsShow.thirdShow = true
            } else if(this.recruitmentProcess.rpPhase == '就业协议书') {
              this.tableData.rpPhaseId = 5
              this.stepsShow.fourthShow = true
            } else if(this.recruitmentProcess.rpPhase == '招聘完成') {
              this.tableData.rpPhaseId = 5
              this.stepsShow.fifthShow = true
            }
          })

          this.$axios.get('http://localhost:8081/graduate/query_by_graduate_id?graduateId='+ this.$route.query.graduateId).then(res=>{
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
             * 根据毕业生id获取毕业生毕业资料相关信息
             */
            this.$axios.get('http://localhost:8081/gq/query_by_graduate_id?graduateId='+ this.graduate.graduateId).then(res2=> {
              for (let j = 0; j < res2.data.length; j++) {
                this.graduateQualificationsList[j] = {
                  graduateId: res2.data[j].graduateId,
                  gqId: res2.data[j].gqId,
                  gqIndex: res2.data[j].gqIndex,
                }

                /**
                 * 为tableDataList赋值展示数据
                 */
                this.preview.previewImageUrls[j] = "http://localhost:8081/" + this.graduateQualificationsList[j].gqIndex
              }
            })


          })
        }
      }
    })
  },


  data() {
    return {
      /**
       * 就业协议书表
       */
      fileList: [],
      fileListShow: true,

      /**
       * 就业协议书展示
       */
      workFileShow: true,

      /**
       * 初始化 map 对象
       */
      map: null,

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
       * 毕业生毕业资格信息
       */
      graduateQualificationsList: [{
        graduateId: 0,
        gqId: 0,
        gqIndex: '',
      }],


      /**
       * 招聘过程
       */
      recruitmentProcess: {
        rpId: 0,
        graduateId: 0,
        enId: 0,
        rpPhase: '',
        rpFaceLocation: '',
        rpCheck: '',
        rpWorkFile: '',
      },

      /**
       * 界面预览弹窗显示对象
       */
      preview: {
        previewDialog: false,
        previewImageUrls: [''],
      },

      /**
       * 展示数据
       */
      tableData: {
        enId: 0,
        graduateId: 0,
        rpPhase: '',
        rpPhaseId: 0,
        rpCheck: '',
        rpFaceLocation: '',
      },

      /**
       * 用于展示某一步
       */
      stepsShow: {
        firstShow: false,
        secondShow: false,
        thirdShow: false,
        fourthShow: false,
        fifthShow: false,
      }
    }
  },

  methods: {
    /**
     * 地图初始化加载
     */
    initMap() {
      AMapLoader.load({
        key: "ba38ade2e475299da6034aa0cabfecaf",  //此处填入我们注册账号后获取的Key
        version: "2.0",                           //指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
        plugins: [''],                            //需要使用的的插件列表，如比例尺'AMap.Scale'等
      }).then((AMap) => {
        this.map = new AMap.Map("container", {    //设置地图容器id
          viewMode: "2D",                         //是否为3D地图模式
          zoom: 5,                                //初始化地图级别
          center: [105.602725, 37.076636],        //初始化地图中心点位置
        });

        // 绑定地图事件
        this.map.on("click", this.handleMapClick);
      }).catch(e => {
        console.log(e);
      })
    },

    handleMapClick(e) {
      let position = '' + e.lnglat.lng + ',' + e.lnglat.lat + ''
      this.$axios.get('https://restapi.amap.com/v3/geocode/regeo?key=bed5f199a63ff072651a76b9f4d7c9a8&location=' + position).then(res=>{
        console.log(res)
        this.recruitmentProcess.rpFaceLocation = res.data.regeocode.formatted_address
        this.tableData.rpFaceLocation = res.data.regeocode.formatted_address
      })
    },

    /**
     * 文件上传
     * @param param
     */
    upload(param) {
      console.log(param)
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

        console.log(this.fileList)

        /**
         * 重新渲染el-upload
         */
        // 移除组件
        this.workFileShow = false
        // 在组件移除后，重新渲染组件
        // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
        this.$nextTick(() => {
          this.workFileShow = true
        })

        /**
         * 重新渲染el-upload
         */
        // 移除组件
        this.stepsShow.thirdShow = false
        // 在组件移除后，重新渲染组件
        // this.$nextTick可实现在DOM 状态更新后，执行传入的方法。
        this.$nextTick(() => {
          this.stepsShow.thirdShow = true
        })

        this.recruitmentProcess.rpWorkFile = ''
        for(let i = 0; i != this.fileList.length; i++) {
          this.recruitmentProcess.rpWorkFile += ',' + this.fileList[i].name
        }

        this.$axios.post('http://localhost:8081/rp/update', this.recruitmentProcess).then(res1=> {
          //判断是否添加成功并返回对应信息
          if (res1.data == "修改OK") {
            this.$message({message: '就业协议书上传成功', type: 'success'})
          }
        })

      })
    },

    /**
     * 展示资质信息
     */
    graduateQualificationsShow() {
      this.preview.previewDialog = true
    },

    /**
     * 个人信息审核通过
     */
    firstOk() {
      /**
       * 修改信息
       */
      this.recruitmentProcess.rpPhase = '个人资料审核'

      this.$axios.post('http://localhost:8081/rp/update', this.recruitmentProcess).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "修改OK") {
          this.$message({message: '审核成功', type: 'success'})

          /**
           * 修改展示信息
           */
          this.tableData.rpPhase = '个人资料审核'
          this.tableData.rpPhaseId = 2
          this.stepsShow.firstShow = false
          this.stepsShow.secondShow = true
        }
      })
    },

    /**
     * 面试审核通过
     */
    secondOk() {
      /**
       * 修改信息
       */
      this.recruitmentProcess.rpPhase = '面试'

      this.$axios.post('http://localhost:8081/rp/update', this.recruitmentProcess).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "修改OK") {
          this.$message({message: '审核成功', type: 'success'})

          /**
           * 修改展示信息
           */
          this.tableData.rpPhase = '面试'
          this.tableData.rpPhaseId = 3
          this.stepsShow.secondShow = false
          this.stepsShow.thirdShow = true
        }
      })
    },

    /**
     * 确定面试地点
     */
    faceLocate() {
      this.$axios.post('http://localhost:8081/rp/update', this.recruitmentProcess).then(res=> {
        //判断是否添加成功并返回对应信息
        if (res.data == "修改OK") {
          this.$message({message: '面试地点确定成功', type: 'success'})

          /**
           * 修改展示信息
           */
          this.tableData.rpFaceLocation = this.recruitmentProcess.rpFaceLocation
        }
      })
    },

    /**
     * 个人信息审核未通过
     */
    firstOff() {

    },


  },
}
</script>

<style>
#container {
  width: 90%;
  height: 500px;
  margin: 50px auto;
  border: 2px solid black;
}
</style>