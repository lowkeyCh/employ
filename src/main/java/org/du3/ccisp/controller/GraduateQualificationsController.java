package org.du3.ccisp.controller;

import com.alibaba.fastjson.JSON;
import org.du3.ccisp.pojo.GraduateQualifications;
import org.du3.ccisp.pojo.User;
import org.du3.ccisp.service.GraduateQualificationsService;
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
@RequestMapping(value = "/gq")
public class GraduateQualificationsController {
    @Autowired
    private GraduateQualificationsService graduateQualificationsService;

    @GetMapping("/query_by_graduate_id")
    @ResponseBody
    public String queryByGraduateId(int graduateId) {
        return JSON.toJSONString(graduateQualificationsService.queryByGraduateId(graduateId));
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody GraduateQualifications graduateQualifications){
        graduateQualificationsService.add(graduateQualifications);
        return "上传成功";
    }

    @GetMapping("/delete_by_gq_index")
    @ResponseBody
    public String query(String gqIndex) {
        graduateQualificationsService.deleteByGqIndex(gqIndex);
        return "删除成功";
    }
}
