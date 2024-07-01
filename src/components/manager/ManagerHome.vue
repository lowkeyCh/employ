<template>
    <div ref="vantaRef" style="width: 100%; height: 80vh;">
    <el-descriptions title="欢迎您，管理员" :column="3" border>
        <el-descriptions-item label="用户名" label-class-name="my-label" content-class-name="my-content">kooriookami</el-descriptions-item>
        <el-descriptions-item label="手机号">18100000000</el-descriptions-item>
        <el-descriptions-item label="性别">
            <el-tag size="small">男</el-tag>
            </el-descriptions-item>
        <el-descriptions-item label="角色">
            <el-tag size="small">管理员</el-tag>
        </el-descriptions-item>
        <el-descriptions-item label="联系地址" :contentStyle="{'text-align': 'right'}">江苏省苏州市吴中区吴中大道 1188 号</el-descriptions-item>
    </el-descriptions>
        <div style="width: 50%;float: left;overflow: hidden">
            <div id="myChart" :style="{width: '600px', height: '500px'}"></div>
        </div>
        <div style="width: 50%;float: left;overflow: hidden">
            <div id="myCharts" :style="{width: '600px', height: '500px'}"></div>
        </div>
        </div>
</template>

<script>

export default {
    data() {
        return {};
    },
    mounted() {
        let echarts = require('echarts')
        let echarts2= require('echarts')
        let myChart = echarts.init(document.getElementById('myChart'))
        let myCharts = echarts2.init(document.getElementById('myCharts'))
        var data = [{
            value: 3661,
            name: '<10w'
        }, {
            value: 5713,
            name: '10w-50w'
        }, {
            value: 9938,
            name: '50w-100w'
        }, {
            value: 17623,
            name: '100w-500w'
        }, {
            value: 3299,
            name: '>500w'
        }];
        // 绘制图表
        myChart.setOption({
            title: {
                text: '各学院就业量统计',
                left: 'center',
                top: 20,
                textStyle: {
                    color: '#555555'
                }
            },
            tooltip: {},
            xAxis: {
                data: [
                    "信息",
                    "经管",
                    "建筑",
                    "法学院",
                    "马院",
                    "河海"
                ]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data: [
                    {
                        value: 333,
                        itemStyle: {
                            color: "#3fb1e3"
                        }
                    },
                    {
                        value: 133,
                        itemStyle: {
                            color: "#c4ebad"
                        }
                    },
                    {
                        value: 99,
                        itemStyle: {
                            color: "#c4ebad"
                        }
                    },
                    {
                        value: 222,
                        itemStyle: {
                            color: "#6be6c1"
                        }
                    },
                    {
                        value: 399,
                        itemStyle: {
                            color: "#3fb1e3"
                        }
                    },
                    {
                        value: 123,
                        itemStyle: {
                            color: "#c4ebad"
                        }
                    }
                ]
            }]
        });
        myCharts.setOption({
            backgroundColor: '#fff',
            title: {
                text: '注册企业',
                subtext: '2024年',
                x: 'center',
                y: 'center',
                textStyle: {
                    fontWeight: 'normal',
                    fontSize: 16
                }
            },
            tooltip: {
                show: true,
                trigger: 'item',
                formatter: "{b}: {c} ({d}%)"
            },
            legend: {
                orient: 'horizontal',
                bottom: '0%',
                data: ['<10w', '10w-50w', '50w-100w', '100w-500w', '>500w']
            },
            series: [{
                type: 'pie',
                selectedMode: 'single',
                radius: ['25%', '58%'],
                color: ['#86D560', '#AF89D6', '#59ADF3', '#FF999A', '#FFCC67'],

                label: {
                    normal: {
                        position: 'inner',
                        formatter: '{d}%',

                        textStyle: {
                            color: '#fff',
                            fontWeight: 'bold',
                            fontSize: 14
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data: data
            }, {
                type: 'pie',
                radius: ['58%', '83%'],
                itemStyle: {
                    normal: {
                        color: '#F2F2F2'
                    },
                    emphasis: {
                        color: '#ADADAD'
                    }
                },
                label: {
                    normal: {
                        position: 'inner',
                        formatter: '{c}家',
                        textStyle: {
                            color: '#777777',
                            fontWeight: 'bold',
                            fontSize: 14
                        }
                    }
                },
                data: data
            }]
        })
     },
    methods: {
    },

};
</script>

<style>



</style>

