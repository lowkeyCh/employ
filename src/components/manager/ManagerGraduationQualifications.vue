<script>
  export default {

    data() {
      return {
        list: {
          unit_account: "111"
        }
      }
    }

  }
</script>

<template>

  <div style="padding: 5px 20px;">
    <span>
      <el-input placeholder="毕业生名称" style="width: 200px" suffix-icon="el-icon-edit"></el-input>
      <el-button type="primary" icon="el-icon-search" style="margin-left: 10px">查询</el-button>
      <el-button type="success" icon="el-icon-edit">添加</el-button>
    </span>

    <el-table :data="list" element-loading-text="Loading" border fit highlight-current-row>

<!--      <el-table-column align="center" label="ID" width="50" type="index">-->
<!--      </el-table-column>-->

<!--      <el-table-column label="代收单位账号" prop="unit_account">-->
<!--      </el-table-column>-->

<!--      <el-table-column label="代收单位名称" prop="unit_name">-->
<!--      </el-table-column>-->

<!--      <el-table-column label="创建时间">-->
<!--        <template slot-scope="scope">-->
<!--          <i class="el-icon-time"></i>&nbsp;-->
<!--          <span style="margin-left: 5px" v-text="(scope.row.create_time).substring(-1,19).replace('T',' ')"></span>-->
<!--        </template>-->
<!--      </el-table-column>-->

      <el-table-column fixed="right" label="操作" width="120">

        <template slot-scope="scope">

          <el-tooltip class="item" effect="dark" content="修改密码" placement="top">
            <el-button type="primary" icon="el-icon-edit" circle @click="BJCollectionForm(scope.$index)"></el-button>
          </el-tooltip>

          <el-tooltip class="item" effect="dark" content="删除" placement="top">
            <el-button type="danger" icon="el-icon-delete" circle @click="deleteVisible(scope)"></el-button>
          </el-tooltip>

        </template>

      </el-table-column>

    </el-table>
  </div>

</template>

<style>

</style>