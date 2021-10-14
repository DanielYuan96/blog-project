package com.ziqiyuan.blog.controller;

import com.ziqiyuan.blog.service.LoginService;
import com.ziqiyuan.blog.vo.Result;
import com.ziqiyuan.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParam loginParam) {
        //登陆 验证用户 访问用户表 但是
        return loginService.login(loginParam);
    }
}
