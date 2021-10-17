package com.ziqiyuan.blog.controller;

import com.ziqiyuan.blog.service.impl.CategoryServiceImpl;
import com.ziqiyuan.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorys")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    @GetMapping
    public Result categories() {
        return categoryService.findAll();
    }

}
