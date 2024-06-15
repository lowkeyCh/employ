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
  <el-table
      :data="tableData"
      height="250"
      border
      :default-sort = "{prop: 'date', order: 'descending'}"
      style="width: 100%; margin-top: 20px">
    <el-table-column
        label="投递日期"
        width="180">
      <template slot-scope="scope">
        <i class="el-icon-time"></i>
        <span style="margin-left: 10px">{{ scope.row.date }}</span>
      </template>
    </el-table-column>
    <el-table-column
        label="公司名称"
        width="500">
      <template slot-scope="scope">
        <el-popover trigger="hover" placement="top">
          <p>进度: {{ scope.row.jindu }}</p>
          <p>状态: {{ scope.row.status }}</p>
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.name }}</el-tag>
          </div>
        </el-popover>
      </template>
    </el-table-column>
    <el-table-column
        prop="jindu"
        label="进度">
    </el-table-column>
    <el-table-column
        prop="status"
        label="状态">
    </el-table-column>
    <el-table-column label="操作">
      <template slot-scope="scope">
        <el-button
            size="mini"
            @click="handleEdit(scope.$index, scope.row)">取消申请</el-button>
        <el-button
            size="mini"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>

  </el-table>
</template>

<style scoped>

</style>