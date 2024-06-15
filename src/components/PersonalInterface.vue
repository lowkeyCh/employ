<template>
  <el-card class="box-card">
    <el-col :span="6">
      <el-row class="demo-avatar demo-basic">
        <el-col :span="12">

          <div class="demo-basic--circle">
            <div class="block"><el-avatar shape="square" :size="200" style="margin: 30px" :src="headUrl"></el-avatar></div>
            <div class="block" v-for="size in sizeList" :key="size">
              <el-avatar shape="square" :size="size" :src="headUrl"></el-avatar>
            </div>
          </div>
        </el-col>
      </el-row>
    </el-col>
    <el-col :span="9">
      <div v-show="user.userName"  class="text item" style="font-size: 25px">
        账号名 ： {{ user.userName }}
      </div>
      <div v-show="user.userPassword"  class="text item" style="font-size: 25px">
        密码： {{ user.userPassword }}
      </div>
      <div v-show="user.userIdentity"  class="text item" style="font-size: 25px">
        身份： {{ user.userIdentity }}
      </div>
    </el-col>
    <el-col :span="9">
      <el-button>修改信息</el-button>
    </el-col>
  </el-card>
</template>

<style scoped>
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 99%;
}
</style>

<script>
export default {
  beforeMount() {
    this.user = JSON.parse(localStorage.getItem("user")).user
  },
  mounted() {
    if(this.user.userName == 'Loading'){
      location.reload()
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

      input: '',
      user: {
        userName: 'Loading',
      }
    }
  },
  methods:{

  }
}
</script>
