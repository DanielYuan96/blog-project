package com.ziqiyuan.blog.service;

import com.ziqiyuan.blog.dao.pojo.SysUser;
import com.ziqiyuan.blog.vo.Result;
import com.ziqiyuan.blog.vo.params.LoginParam;

public interface LoginService {
    /**
     * 登陆功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    /**
     * 退出登陆
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     *
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
