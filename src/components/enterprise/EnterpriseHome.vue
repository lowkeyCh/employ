<script>
  export default {
    name:"MyCompany",
    data () {
      return {
        qualify:"已有发布用人资格",
        tableData: [
          {
            title: '本公司挣够一个亿小目标',
            endTIme: '2099-12-31',
            percentage: 50,
            color: '#95de64',
          },
          {
            title: '给交大南岸校区翻新宿舍',
            endTIme: '2089-12-31',
            percentage: 8,
            color: '#69c0ff',
          },
          {
            title: '让台湾回归中国',
            endTIme: '指日可待',
            percentage: 76,
            color: '#1890FF',
          },
          {
            title: '本次项目老师给高分',
            endTIme: '应该没问题',
            percentage: 100,
            color: '#ffc069',
          },
          {
            title: '活到老，学到老',
            endTIme: '2094-12-16',
            percentage: 25,
            color: '#5cdbd3',
          },
          {
            title: '变成像文远彬一样优秀的人',
            endTIme: '此生无望',
            percentage: 1,
            color: '#b37feb',
          },
          {
            title: '跻身世界企业500强',
            endTIme: '2099-12-31',
            percentage: 30,
            color: '#95de64',
          },
        ],
        fits: ['fill'],
        url: 'https://tse3-mm.cn.bing.net/th/id/OIP-C.F40xz4iiLk6hGJAuJUBcuAAAAA?w=187&h=186&c=7&r=0&o=5&dpr=1.3&pid=1.7'
      }
    },
  }
</script>

<template>
  <div>
    <div class="plan">
      <el-card shadow="hover">
        <template #header>
          <vab-icon icon="send-plane-2-line" />
          <!-- 计划 -->
          <el-tag class="card-header-tag" type="success">祝本组成员都能住上别墅，开上保时捷</el-tag>
        </template>
        <el-table :data="tableData" height="800px" row-key="title">
          <el-table-column width="20px" />
          <el-table-column label="目标" prop="title" width="230px" />
          <el-table-column label="进度" width="220px">
            <template #default="{ row }">
              <el-progress :color="row.color" :percentage="row.percentage" />
            </template>
          </el-table-column>
          <el-table-column width="50px" />
          <el-table-column label="完成时间" prop="endTIme" />
        </el-table>
      </el-card>
    </div>
    <div class="information" v-for="fit in fits" :key="fit" >
      <el-avatar shape="square" :size="250" :fit="fit" :src="url"></el-avatar>
      <div class="operate">
        <el-button type="primary" style="margin-left: 5px;">用人资格审查</el-button>
        <el-button type="success" style="margin-left: 5px;">修改信息</el-button>
        <el-button type="danger" style="margin-left: 5px;">修改密码</el-button>
      </div>
    <el-descriptions :column="1" border>
      <el-descriptions-item label="用户名称" label-class-name="my-label" content-class-name="my-content">文远彬有限公司</el-descriptions-item>
      <el-descriptions-item label="公司邮箱">123456789.qq.com</el-descriptions-item>
      <el-descriptions-item label="公司联系人">文远彬</el-descriptions-item>
      <el-descriptions-item label="所属部门">人事资源部</el-descriptions-item>
      <el-descriptions-item label="备注">
        <el-tag size="medium">国企</el-tag>
      </el-descriptions-item>
      <el-descriptions-item label="公司地址" >重庆交通大学南岸校区</el-descriptions-item>
      <el-descriptions-item label="工作方向" >IT信息技术</el-descriptions-item>

    </el-descriptions>
    </div>
  </div>
</template>

<style>
.my-label {
  background: #E1F3D8;
}

.my-content {
  background: #FDE2E2;
}

.el-descriptions__body .el-descriptions__table {
  border-collapse: collapse;
  width: 30%;
  table-layout: fixed;
  height: 100%;
}
element.style {
  border-radius: 350px;
  height: 300px;
  width: 370px;
}

.el-descriptions__body .el-descriptions__table {
  border-collapse: collapse;
  width: 100%;
  table-layout: fixed;
  height: 100%;
}
.plan {
  display: flex;
  flex-direction: column;
  position: fixed;
  left: 800px;
  height: 600px;
}
.information {
  display: flex;
  flex-direction: column;
  position: fixed;
  width: 550px;
}
.el-avatar--square {
  border-radius: 300px;
  left: 1000px;
}
.operate{
  display: flex;
  flex-direction: column;
  position: fixed;
  width: 170px;
  left: 560px;
  top: 160px;
}

</style>