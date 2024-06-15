<script>
  export default {
    name:"MyResume",
    methods: {
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
        this.pageNum=val

      }
    },
    data() {
      return {
        pageSize:10,
        pageNum:1,
        total:0,
        tableData: [{
          date: '2016-05-02',
          name: '王小虎',
          school: '清华大学',
          time: '2年',
          point:'在职',
          department: '南岸',
          zip: 200333
        }, {
          date: '2016-05-04',
          name: '文远彬',
          school: '北京大学',
          time: '1年',
          point:'在职',
          department: '南岸',
          zip: 200333
        }, {
          date: '2016-05-01',
          name: '张三',
          school: '交职院',
          time: '3年',
          point:'在职',
          department: '双福',
          zip: 200333
        }, {
          date: '2016-05-03',
          name: '李四',
          school: '重庆交通大学',
          time: '刚入职',
          department: '双福',
          point:'已离职',
          zip: 200333
        }]
      }
    }
  }
</script>

<template>
  <div>
    <div style="margin-bottom: 5px">
      <el-input v-model="class_no" placeholder="请输入查询信息" suffix-icon="el-icon-search" style="width: 300px;"></el-input>
      <el-button type="primary" style="margin-left: 5px;" @click="loadPost">查询</el-button>
      <el-button type="success" @click="resetParam">重置</el-button>

      <el-button type="primary" style="margin-left: 5px;" @click="add">新增</el-button>
    </div>
    <el-table
        :data="tableData"
        border
        style="width: 100%"
    >
      <el-table-column
          fixed
          prop="date"
          label="录取日期"
          width="150">
      </el-table-column>
      <el-table-column
          prop="name"
          label="学生姓名"
          width="150">
      </el-table-column>
      <el-table-column
          prop="school"
          label="所属学校"
          width="250"
          :filters="listZy"
          filter-placement="bottom-end"
          :filter-method="filterHandlerZy">
      </el-table-column>
      <el-table-column
          prop="time"
          label="工作时间"
          width="150">
      </el-table-column>
      <el-table-column
          prop="point"
          label="在职状态"
          width="100">
      </el-table-column>
      <el-table-column
          prop="department"
          label="所属分部"
          width="200">
      </el-table-column>
      <el-table-column prop="operate" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" @click="mod(scope.row)">修改信息</el-button>
          <el-popconfirm
              title="确定删除吗？"
              @confirm="del(scope.row.class_no)"
              style="margin-left: 5px"
          >
            <el-button slot="reference" size="small" type="danger">删除</el-button>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
    </el-pagination>
  </div>
</template>

<style>

</style>