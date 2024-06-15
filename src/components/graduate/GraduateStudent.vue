<script>
  export default {
    name:"MyStudent",
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
      }
    },
  }
</script>

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
      <div v-show="name"  class="text item" style="font-size: 25px">
        姓名 ： {{ name }}
      </div>
      <div v-show="birthday"  class="text item" style="font-size: 25px">
        出生日期： {{ birthday }}
      </div>
      <div v-show="majory"  class="text item" style="font-size: 25px">
        专业： {{ majory }}
      </div>
      <div v-show="tel"  class="text item" style="font-size: 25px">
        电话： {{ tel }}
      </div>
    </el-col>
    <el-col :span="9">
      <div v-show="num"  class="text item" style="font-size: 25px">
        学号： {{ num }}
      </div>
      <div v-show="department"  class="text item" style="font-size: 25px">
        院系： {{ department }}
      </div>
      <div v-show="class1"  class="text item" style="font-size: 25px">
        班级： {{ class1 }}
      </div>
      <div v-show="email"  class="text item" style="font-size: 25px">
        邮箱： {{ email }}
      </div>
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