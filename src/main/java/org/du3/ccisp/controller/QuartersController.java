package org.du3.ccisp.controller;

import org.du3.ccisp.pojo.Enterprise;
import org.du3.ccisp.pojo.Quarters;
import org.du3.ccisp.pojo.User;
import org.du3.ccisp.service.QuartersService;
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
@RequestMapping(value = "/quarters")
public class QuartersController {
    @Autowired
    private QuartersService quartersService;

    @GetMapping("/query_all")
    @ResponseBody
    public List<Quarters> queryAll() {
        return quartersService.queryAll();
    }

    @GetMapping("/query_by_quarters_id")
    @ResponseBody
    public Quarters queryByQuartersId(int quartersId) {
        return quartersService.queryByQuartersId(quartersId);
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Quarters quarters) {
        quartersService.add(quarters);
        return "添加OK";
    }
}
