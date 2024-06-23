<script>
  import {right} from "core-js/internals/array-reduce";
  import { pcaTextArr } from 'element-china-area-data'

  export default {
    name:"MyReceive",
    methods: {right},

    data() {
      return {
        pcaTextArr,
        selectedOptions: [],
        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
          delivery: false,
          type: [],
          resource: '',
          desc: ''
        },
        options3: [{
          value: '不限',
          label: '不限'
        }, {
          value: '1年以内',
          label: '1年以内'
        }, {
          value: '1-3年',
          label: '1-3年'
        }, {
          value: '3-5年',
          label: '3-5年'
        }, {
          value: '5-10年',
          label: '5-10年'
        }, {
          value: '10年以上',
          label: '10年以上'
        }],
        options4: [{
          value: '不限',
          label: '不限'
        }, {
          value: '初中及以下',
          label: '初中及以下'
        }, {
          value: '中专',
          label: '中专'
        }, {
          value: '高中',
          label: '高中'
        }, {
          value: '大专',
          label: '大专'
        }, {
          value: '本科',
          label: '本科'
        }, {
          value: '硕士',
          label: '硕士'
        }, {
          value: '博士',
          label: '博士'
        }],
        options5: [{
          value: '2k',
          label: '2k'
        }, {
          value: '3k',
          label: '3k'
        }, {
          value: '4k',
          label: '4k'
        }, {
          value: '6k',
          label: '6k'
        }, {
          value: '8k',
          label: '8k'
        }, {
          value: '10k',
          label: '10k'
        }, {
          value: '12k',
          label: '12k'
        }, {
          value: '15k',
          label: '15k'
        }],
        value: [],
        options: [{
          value: '互联网',
          label: '互联网',
          children: [{
            value: '后端开发',
            label: '后端开发',
            children: [{
              value: 'Java',
              label: 'Java'
            }, {
              value: 'C/C++',
              label: 'C/C++'
            }, {
              value: 'Python',
              label: 'Python'
            }]
          }, {
            value: '前端/移动开发',
            label: '前端/移动开发',
            children: [{
              value: '前端开发工程师',
              label: '前端开发工程师'
            }, {
              value: 'Android',
              label: 'Android'
            },{
              value: 'IOS',
              label: 'IOS'
            }]
          }]
        }, {
          value: '电子/电气/通信',
          label: '电子/电气/通信',
          children: [{
            value: '电子/硬件开发',
            label: '电子/硬件开发',
            children: [{
              value: '电子工程师',
              label: '电子工程师'
            }, {
              value: '硬件工程师',
              label: '硬件工程师'
            }, {
              value: '嵌入式软件工程师',
              label: '嵌入式软件工程师'
            }]
          }, {
            value: '半导体芯片',
            label: '半导体芯片',
            children: [{
              value: '集成电路IC设计',
              label: '集成电路IC设计'
            }, {
              value: '芯片测试工程师',
              label: '芯片测试工程师'
            }, {
              value: 'DFT工程师',
              label: 'DFT工程师'
            }]
          }, {
            value: '通信',
            label: '通信',
            children: [{
              value: '通信项目专员',
              label: '通信项目专员'
            }, {
              value: '通信项目经理',
              label: '通信项目经理'
            }, {
              value: '通信技术工程师',
              label: '通信技术工程师'
            }]
          }]
        }, {
          value: '设计',
          label: '设计',
          children: [ {
            value: '视觉/交互设计',
            label: '视觉/交互设计',
            children: [{
              value: '平面设计',
              label: '平面设计'
            }, {
              value: '美工',
              label: '美工'
            }, {
              value: 'UI设计师',
              label: 'UI设计师'
            }]
          },  {
            value: '美术',
            label: '美术',
            children: [{
              value: '3D设计师',
              label: '3D设计师'
            }, {
              value: '插画师',
              label: '插画师'
            }, {
              value: '漫画师',
              label: '漫画师'
            }]
          }, {
            value: '游戏设计',
            label: '游戏设计',
            children: [{
              value: '游戏场景设计',
              label: '游戏场景设计'
            }, {
              value: '游戏角色设计',
              label: '游戏角色设计'
            }, {
              value: '系统策划',
              label: '系统策划'
            }]
          }]
        }]
      };

    }
  }
</script>

<template>
  <div class="AllRequire">

    <div class="myPicture">
      <el-row >
        <el-card :body-style="{ padding: '0px' }">
          <div class="word">
            <span style="font-style: normal;font-size: 34px;font-weight: bolder;height:auto;display: block;text-align: left;white-space: pre-wrap;word-break:break-all;">去发布一个职位吧</span>
            <span style="font-style: normal;font-size: 25px;height:auto;display: block;text-align: left;white-space: pre-wrap;word-break:break-all;">开启高效招聘方式</span>
          </div>
          <div>
            <img src="https://img.bosszhipin.com/static/file/2023/n3fa5j6es61684132314764.png" class="image" style="width: 500px; height: 550px">
          </div>
        </el-card>
      </el-row>
    </div>

    <div class="myRequire">
      <el-form ref="form" :model="form" label-width="80px">

        <el-form-item label="公司名称">
          <el-input v-model="form.name"></el-input>
        </el-form-item>

        <el-form-item label="职位名称">
          <el-cascader
              placeholder="选择职位名称"
              :options="options"
              filterable></el-cascader>
        </el-form-item>
        <el-form-item label="职位描述">
          <el-input type="textarea" v-model="form.desc" filterable placeholder="简要描述工作内容"></el-input>
        </el-form-item>

        <el-form-item label="经验学历">
          <el-select v-model="value" filterable placeholder="选择经验">
            <el-option
                v-for="item in options3"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
          <el-select v-model="value" filterable placeholder="选择学历">
            <el-option
                v-for="item in options4"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="薪资范围">
          <el-select v-model="value" filterable placeholder="最低月薪">
            <el-option
                v-for="item in options5"
                :key="item.value"
                :label="item.label"
                :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="工作地点">
          <el-cascader
              size="large"
              :options="pcaTextArr"
              v-model="selectedOptions">
          </el-cascader>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即创建</el-button>
          <el-button>取消</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<style>
.myPicture{
  width: 45%;
  position: relative;
  left: 0;
}

.myRequire{
  width: 45%;
  position: absolute;
  right: 0;
  top: 140px;
}
</style>