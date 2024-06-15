//1.导入vue 和 vue router 的包
import Vue from 'vue'
import VueRouter from 'vue-router'

import PersonalInterface from "@/components/PersonalInterface.vue";
import LoginInterface from "@/components/LoginInterface.vue";

import ManagerIndex from "@/components/manager/ManagerIndex.vue";
import ManagerHome from "@/components/manager/ManagerHome.vue";
import ManagerCompany from "@/components/manager/ManagerCompany.vue";
import ManagerComaudit from "@/components/manager/ManagerComaudit.vue";
import ManagerMain from "@/components/manager/ManagerMain.vue";

import ManagerGraduationQualifications from "@/components/manager/ManagerGraduationQualifications.vue";
import GraduateIndex from "@/components/graduate/GraduateIndex.vue";
import GraduateWork from "@/components/graduate/GraduateWork.vue";
import GraduateStudent from "@/components/graduate/GraduateStudent.vue";
import GraduateResumeDelivery from "@/components/graduate/GraduateResumeDelivery.vue";

import GraduateResumeDetails from "@/components/graduate/GraduateResumeDetails.vue";
import EnterpriseIndex from "@/components/enterprise/EnterpriseIndex.vue";
import EnterpriseHome from "@/components/enterprise/EnterpriseHome.vue";
import EnterpriseResume from "@/components/enterprise/EnterpriseResume.vue"
import EnterpriseRequire from "@/components/enterprise/EnterpriseRequire.vue";
import EnterpriseRecruit from "@/components/enterprise/EnterpriseRecruit.vue";

//2.调用vue.use() 函数，把 VueRouter 安装为 Vue 的插件
//vue.use()函数的作用，就是来安装插件的
Vue.use(VueRouter)


const routes= [
    {
        path: '/',
        component: LoginInterface
    },
    {
        path: '/ManagerIndex',
        component: ManagerIndex,
        children:[
            {
                path: '/ManagerHome',
                meta: {
                    title: '首页'
                },
                component: ManagerHome
            },
            {
                path: '/ManagerCompany',
                meta: {
                    title: '企业基本信息管理',
                },
                component: ManagerCompany
            },
            {
                path: '/ManagerComaudit',
                meta:{
                    title: '企业基本信息审核',
                },
                component: ManagerComaudit
            },
            {
                path:'/ManagerMain',
                meta:{
                    title:'学生基本信息管理',
                },
                component: ManagerMain
            },
            {
                path:'/ManagerGraduationQualifications',
                meta:{
                    title:'学生毕业资格审查',
                },
                component: ManagerGraduationQualifications
            },
            {
                path:'/personal_gly',
                meta:{
                    title:'用户账号信息管理',
                },
                component: PersonalInterface
            }
        ]
    },
    {
        path: '/GraduateIndex',
        component: GraduateIndex,
        children: [
            {
                path: '/GraduateStudent',
                meta: {
                    title: '学生基本信息'
                },
                component: GraduateStudent
            },
            {
                path: '/GraduateWork',
                meta: {
                    title: '找工作'
                },
                component: GraduateWork
            },
            {
                path: '/GraduateResumeDelivery',
                meta: {
                    title: '简历投递'
                },
                component: GraduateResumeDelivery
            },
            {
                path: '/GraduateResumeDetails',
                meta: {
                    title: '简历详情'
                },
                component: GraduateResumeDetails
            },
            {
                path:'/personal_xs',
                meta:{
                    title:'用户账号信息管理',
                },
                component: PersonalInterface
            }
        ]
    },
    {
        path: '/EnterpriseIndex',
        component: EnterpriseIndex,
        children:[
            {
                path:'/EnterpriseHome',
                meta:{
                    title:'公司首页'
                },
                component: EnterpriseHome
            },
            {
                path:'/EnterpriseResume',
                meta:{
                    title:'简历查看'
                },
                component: EnterpriseResume
            },
            {
                path:'/EnterpriseRequire',
                meta:{
                    title:'录取档案'
                },
                component: EnterpriseRequire
            },
            {
                path:'/EnterpriseRecruit',
                meta:{
                    title:'正在招收'
                },
                component: EnterpriseRecruit
            },
            {
                path:'/personal_qy',
                meta:{
                    title:'用户账号信息管理',
                },
                component: PersonalInterface
            }
        ]
    }

]


//3.创建路由的实例对象
const router = new VueRouter({
    mode:'history',
    routes
})


export default router;