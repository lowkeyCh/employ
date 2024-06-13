package org.du3.ccisp.controller;

import com.alibaba.fastjson.JSON;
import org.du3.ccisp.pojo.User;
import org.du3.ccisp.service.UserService;
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
@RequestMapping(value = "/user")
public class UserController {
    //获取到UserInfoService
    @Autowired
    private UserService userService;

    //Get请求
    @GetMapping("/query_all")
    //@ResponseBody 注释后表示放回的是字符串
    @ResponseBody
    public String queryAll(){
        List<User> userList = userService.queryAll();
        return JSON.toJSONString(userList);
    }

    //使用了RestFull风格
    @GetMapping("/{user_id}")
    @ResponseBody
    public String query(@PathVariable(value = "user_id")Integer userId) {
        User user = userService.queryById(userId);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        return JSON.toJSONString(userList);
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/register")
    @ResponseBody
    public String add(@RequestBody User user){
        userService.add(user);
        return "添加OK";
    }

    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user){
        return JSON.toJSONString(userService.match(user));
    }

    //Delete请求
    @DeleteMapping(value = "/{user_id}")
    @ResponseBody
    public String delete(@PathVariable("user_id")Integer userId){
        userService.delete(userId);
        return "删除成功";
    }

    //Put请求
    @PutMapping("/{user_id}")
    @ResponseBody
    public String update(@PathVariable("user_id")Integer userId,
                         @RequestBody User user){
        user.setUserId(userId);
        userService.update(user);
        return "修改成功";
    }
}

