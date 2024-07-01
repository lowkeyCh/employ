package org.du3.ccisp.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin
//@Controller 控制层需要的注解
//@RestController 使用这个也是可以的，但是使用后他里面所有请求返回的都是字符串！
//一般只需要作为接口放回JSON格式数据的话推荐使用@RestController
//@Controller这个是可以与Thymeleaf模板引擎使用时可以返回一个页面的
@Controller
//@RequestMapping指定路径名
//@RequestMapping("/test")用这个来指定路径也是可以的
@RequestMapping(value = "/file")
public class FileUpdate {
    /**
     * 上传简历图片 并将保存地址返回
     * @param file
     * @return
     */
    @PostMapping("/upload_resume")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return "上传文件为空";
        }

        // 对上传的文件重命名, 避免文件重名
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());

        // 文件保存
        file.transferTo(new File("C:\\Users\\17703\\Desktop\\Projects\\ccis\\src\\main\\resources\\static\\resume", newName));

        // 返回上传文件的文件名
        return newName;

    }
}
