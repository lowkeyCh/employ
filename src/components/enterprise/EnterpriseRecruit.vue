<script>
export default {
  name:"MyRecruit",
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
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1518 弄',
        zip: 200333
      }, {
        date: '2016-05-04',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1517 弄',
        zip: 200333
      }, {
        date: '2016-05-01',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1519 弄',
        zip: 200333
      }, {
        date: '2016-05-03',
        name: '王小虎',
        province: '上海',
        city: '普陀区',
        address: '上海市普陀区金沙江路 1516 弄',
        zip: 200333
      }]
    }
  }
}
</script>

<template>
  <div>
    <div>
      <span style="font-style: normal;font-size: 25px;font-weight: bolder;height:auto;display: block;text-align: left;white-space: pre-wrap;word-break:break-all;"> 人才高级查询</span>
      <el-input v-model="class_no" placeholder="关键字搜索" suffix-icon="el-icon-search" style="width: 300px;"></el-input>
      <el-button type="primary" style="margin-left: 5px;" @click="loadPost">查询</el-button>
      <el-button type="success" @click="resetParam">重置</el-button>
      <el-form ref="condForm" :model="condForm" label-width="78px" :inline="true">
        <el-row>
          <el-col :span="8" class="elrow">
            <el-form-item label="学历要求:" prop="xsbh" style="padding-left: 0px;" >
              <el-select v-model="value" filterable placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="8" class="elrow">
            <el-form-item label="年龄要求:"  prop="xsbh" style="padding-left: 10px;" >
              <el-select v-model="value" filterable placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="8" class="elrow">
            <el-form-item label="性别:"  prop="xsbh" style="padding-left: 10px;" >
              <el-select v-model="value" filterable placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </el-row>
        <el-row>
          <el-col :span="8" class="elrow">
            <el-form-item label="工作经验:"  prop="xsbh" style="padding-left: 0px;" >
              <el-select v-model="value" filterable placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="8" class="elrow">
            <el-form-item label="意向地区:"  prop="xsbh" style="padding-left: 10px;" >
              <el-select v-model="value" filterable placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="8" class="elrow">
            <el-form-item label="简历日期:" label-postion="label-postion=left" prop="xsbh" style="padding-left: 10px;" >
              <el-select v-model="value" filterable placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                </el-option>
              </el-select>
            </el-form-item>
          </el-col>

        </el-row>
      </el-form>
    </div>
    <el-divider></el-divider>
    <span style="font-style: normal;font-size: 25px;font-weight: bolder;height:auto;display: block;text-align: left;white-space: pre-wrap;word-break:break-all;"> 最新简历</span>
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="date"
          label="日期"
          width="120">
      </el-table-column>
      <el-table-column
          prop="name"
          label="学生姓名"
          width="110">
      </el-table-column>
      <el-table-column
          prop="age"
          label="年龄"
          width="60">
      </el-table-column>
      <el-table-column
          prop="degree"
          label="学历"
          width="100">
      </el-table-column>
      <el-table-column
          prop="province"
          label="毕业学校"
          width="200">
      </el-table-column>
      <el-table-column
          prop="city"
          label="意向地区"
          width="150">
      </el-table-column>
      <el-table-column
          prop="address"
          label="学生简历"
          width="200">
        <template slot-scope="scope">
          <el-button size="small" type="primary" @click="mod(scope.row)">查看简历详情</el-button>
        </template>
      </el-table-column>
      <el-table-column
          prop="city"
          label="应聘状态"
          width="100">
      </el-table-column>
      <el-table-column prop="operate" label="操作">
        <template slot-scope="scope">
          <el-button size="small" type="success" @click="mod(scope.row)">约见面试</el-button>
          <el-button size="small" type="info" @click="mod(scope.row)">录取</el-button>
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