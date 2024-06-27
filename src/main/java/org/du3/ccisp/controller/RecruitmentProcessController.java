package org.du3.ccisp.controller;

import com.alibaba.fastjson.JSON;
import org.du3.ccisp.pojo.Quarters;
import org.du3.ccisp.pojo.RecruitmentProcess;
import org.du3.ccisp.pojo.User;
import org.du3.ccisp.service.RecruitmentProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！
//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
//@Controller这个是可以与Thymeleaf模板引擎使用时可以返回一个页面的
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的
@RequestMapping(value = "/rp")
public class RecruitmentProcessController {
    @Autowired
    private RecruitmentProcessService recruitmentProcessService;

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/add")
    @ResponseBody
    public String login(@RequestBody RecruitmentProcess recruitmentProcess) {
        recruitmentProcessService.add(recruitmentProcess);
        return "添加OK";
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody RecruitmentProcess recruitmentProcess) {
        recruitmentProcessService.update(recruitmentProcess);
        return "修改OK";
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @GetMapping("/query_by_graduate_id")
    @ResponseBody
    public List<RecruitmentProcess> queryByGraduateId(int graduateId) {
        return recruitmentProcessService.queryByGraduateId(graduateId);
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @GetMapping("/query_by_en_id")
    @ResponseBody
    public List<RecruitmentProcess> queryByEnId(int enId) {
        return recruitmentProcessService.queryByEnId(enId);
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @GetMapping("/query_by_rp_id")
    @ResponseBody
    public RecruitmentProcess queryByRpId(int rpId) {
        return recruitmentProcessService.queryByRpId(rpId);
    }

    @GetMapping("/query_all")
    @ResponseBody
    public List<RecruitmentProcess> queryAll() {
        return recruitmentProcessService.queryAll();
    }
}
