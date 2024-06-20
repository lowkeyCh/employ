package org.du3.ccisp.controller;

import com.alibaba.fastjson.JSON;
import org.du3.ccisp.pojo.Enterprise;
import org.du3.ccisp.pojo.Graduate;
import org.du3.ccisp.pojo.User;
import org.du3.ccisp.service.GraduateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！
//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
//@Controller这个是可以与Thymeleaf模板引擎使用时可以返回一个页面的
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的
@RequestMapping(value = "/graduate")
public class GraduateController {
    @Autowired
    private GraduateService graduateService;

    @GetMapping("/query")
    @ResponseBody
    public String query(Integer userId) {
        return JSON.toJSONString(graduateService.getGraduateByUserId(userId));
    }

    @PostMapping("/modify")
    @ResponseBody
    public void modify(@RequestBody Graduate graduate) {
        graduateService.modify(graduate);
    }

    @GetMapping("/query_all")
    @ResponseBody
    public List<Graduate> queryAll() {
        return graduateService.queryAll();
    }
}