<script>
  export default {
    name:"MyStudent",
    methods: {
      handleEdit(index, row) {
        console.log(index, row);
      },
      handleDelete(index, row) {
        console.log(index, row);
      }
    },
    data() {
      return {
        headUrl: "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
        introduceUrl:"https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
        name: "何吉祥",
        num: "1234567",
        birthday: "1949-7-20",
        department: "信息科学与工程学院",
        majory: "计算机科学与技术",
        class1: "曙光2101班",
        tel: "120",
        age: 12,
        email: "120@qq.com",

        tableData: [{
          date: '2016-05-03',
          name: '华为',
          jindu: '已被拒绝',
          status: '申请中'
        }, {
          date: '2016-05-02',
          name: '腾讯',
          jindu: '已录取',
          status: '已拒绝'
        }, {
          date: '2016-05-04',
          name: '字节跳动',
          jindu: '第二轮面试',
          status: '申请中'
        }, {
          date: '2016-05-01',
          name: '谷歌',
          jindu: '第一轮面试',
          status: '申请中'
        }, {
          date: '2016-05-08',
          name: '京东',
          jindu: '第一轮面试',
          status: '申请中'

        }, {
          date: '2016-05-06',
          name: '阿里巴巴',
          jindu: '第一轮面试',
          status: '申请中'
        }, {
          date: '2016-05-07',
          name: '百度',
          jindu: '第三轮面试',
          status: '申请中'
        }],

        activities: [{
          content: '提交申请',
          timestamp: '2018-04-12 20:46',
          size: 'large',
          type: 'primary',
          icon: 'el-icon-more'
        }, {
          content: '第一轮面试',
          timestamp: '2018-04-03 20:46',
          color: '#0bbd87'
        }, {
          content: '第二轮面试',
          timestamp: '2018-04-03 20:46',
          size: 'large'
        }, {
          content: '已录取',
          timestamp: '2018-04-03 20:46'
        }]


      }
    },
  }
</script>

<template>
  <el-card class="box-card" style="margin-top: 20px">
    <div slot="header" class="clearfix">
      <span style="font-size: 25px">简历</span>
      <el-button style="float: right; padding: 10px 0; font-size: 25px" type="text" >上传简历</el-button>
    </div>

    <div class="demo-image">
      <div class="block" >
        <el-image
            style="width: 100%; height: 100%"
            :src="introduceUrl"
            :fit="fit"></el-image>
      </div>
    </div>
  </el-card>
</template>

<style scoped>
.box-card {
  width: 99%;
}
</style>