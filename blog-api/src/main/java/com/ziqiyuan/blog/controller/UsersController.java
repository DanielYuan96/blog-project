package com.ziqiyuan.blog.controller;

import com.ziqiyuan.blog.service.LoginService;
import com.ziqiyuan.blog.service.SysUserService;
import com.ziqiyuan.blog.vo.ErrorCode;
import com.ziqiyuan.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private LoginService loginService;

    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token,
                              HttpServletResponse response) throws IOException {

        return sysUserService.findUserByToken(token);
    }
}
