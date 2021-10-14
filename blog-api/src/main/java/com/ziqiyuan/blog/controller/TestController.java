package com.ziqiyuan.blog.controller;

import com.ziqiyuan.blog.dao.pojo.SysUser;
import com.ziqiyuan.blog.utils.UserThreadLocal;
import com.ziqiyuan.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test() {
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }

}
