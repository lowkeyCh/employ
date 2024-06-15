<template>
  <div>
    <div style="display:flex;justify-content:center">
      <el-input prefix-icon="el-icon-search" style="width:600px;margin-right:10px" placeholder="输入岗位名称" size="small">     </el-input>
      <el-button type="primary" icon="el-icon-search" size="large" style="width: 50px; height: 40px; margin-top: 5px"></el-button>

    </div>

    <div class="admin-card">


      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{ work }}</span>
          <el-button style="float: right; padding: 3px 0" type="text">提交简历</el-button>
        </div>
        <div class="img-container">

          <img :src = url alt="" style="width:72px;height:72px;border-radius:36px">
        </div>

        <div class="userInfo-container">
          <div>公司简介：{{info}}
          </div>
          <div style="margin-top: 5px">邮箱：{{email}}</div>
          <div style="margin-top: 5px">地址：{{ address }}</div>
          <div style="margin-top: 5px" ><el-tag type="success" style="font-size: large">{{demand}}</el-tag></div>
          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ reward }}</el-tag>
          </div>

        </div>
      </el-card>


      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{ work }}</span>
          <el-button style="float: right; padding: 3px 0" type="text">提交简历</el-button>
        </div>
        <div class="img-container">
          <img :src = url alt="" style="width:72px;height:72px;border-radius:36px">
        </div>

        <div class="userInfo-container">
          <div>公司简介：{{info}}
          </div>
          <div style="margin-top: 5px">邮箱：{{email}}</div>
          <div style="margin-top: 5px">地址：{{ address }}</div>
          <div style="margin-top: 5px" ><el-tag type="success" style="font-size: large">{{demand}}</el-tag></div>
          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ reward }}</el-tag>
          </div>

        </div>
      </el-card>

      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{ work }}</span>
          <el-button style="float: right; padding: 3px 0" type="text">提交简历</el-button>
        </div>
        <div class="img-container">
          <img :src = url alt="" style="width:72px;height:72px;border-radius:36px">
        </div>

        <div class="userInfo-container">
          <div>公司简介：{{info}}
          </div>
          <div style="margin-top: 5px">邮箱：{{email}}</div>
          <div style="margin-top: 5px">地址：{{ address }}</div>
          <div style="margin-top: 5px" ><el-tag type="success" style="font-size: large">{{demand}}</el-tag></div>
          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ reward }}</el-tag>
          </div>

        </div>
      </el-card>


      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{ work }}</span>
          <el-button style="float: right; padding: 3px 0" type="text">提交简历</el-button>
        </div>
        <div class="img-container">
          <img :src = url alt="" style="width:72px;height:72px;border-radius:36px">
        </div>

        <div class="userInfo-container">
          <div>公司简介：{{info}}
          </div>
          <div style="margin-top: 5px">邮箱：{{email}}</div>
          <div style="margin-top: 5px">地址：{{ address }}</div>
          <div style="margin-top: 5px" ><el-tag type="success" style="font-size: large">{{demand}}</el-tag></div>
          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ reward }}</el-tag>
          </div>

        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{ work }}</span>
          <el-button style="float: right; padding: 3px 0" type="text">提交简历</el-button>
        </div>
        <div class="img-container">
          <!-- <img :src="admin.userFace" :alt="admin.id" :title="admin.name"> -->
          <img :src = url alt="" style="width:72px;height:72px;border-radius:36px">
        </div>

        <div class="userInfo-container">
          <div>公司简介：{{info}}
          </div>
          <div style="margin-top: 5px">邮箱：{{email}}</div>
          <div style="margin-top: 5px">地址：{{ address }}</div>
          <div style="margin-top: 5px" ><el-tag type="success" style="font-size: large">{{demand}}</el-tag></div>
          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ reward }}</el-tag>
          </div>

        </div>
      </el-card>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>{{ work }}</span>
          <el-button style="float: right; padding: 3px 0" type="text">提交简历</el-button>
        </div>
        <div class="img-container">
          <img :src = url  alt="" style="width:72px;height:72px;border-radius:36px">
        </div>

        <div class="userInfo-container">
          <div>公司简介：{{info}}
          </div>
          <div style="margin-top: 5px">邮箱：{{email}}</div>
          <div style="margin-top: 5px">地址：{{ address }}</div>
          <div style="margin-top: 5px" ><el-tag type="success" style="font-size: large">{{demand}}</el-tag></div>
          <div style="margin-top: 5px">
            <el-tag type="success" style="font-size: large">{{ reward }}</el-tag>
          </div>

        </div>
      </el-card>
    </div>

  </div>
</template>

<script>
export default {
  name:"SysAdmin",
  mounted(){
    this.initSys();
  },
  data(){
    return{
      demand:"应届生 3年工作经验",
      reward:"12-14k 16薪 包吃包住 早九晚五 双休",
      email:"119@qq.com",
      address: "重庆交通大学",
      info:"公司非常伟大",
      url:"https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg",
      value1:true,
      work:"Java开发工程师",
      initSys(){
        this.getRequest().then(resp=>{
          if(resp){
            return null;
          }
        });
      }
    }
  }

}
</script>

<style scoped>
.box-card{
  width: 360px;
}
.admin-card{
  /*
  加上display:flex可以显示在一行，

  加上flex-wrap: wrap;可以进行换行显示比较好看
  */
  display: flex;
  flex-wrap: wrap;
  /* 这个属性可以加大卡片之间的间隔距离 */
  justify-content: space-around;
  margin-top: 10px;
}
/* 图片在卡片的里面进行居中 */
.img-container{
  display: flex;
  justify-content: center;
}


</style>
