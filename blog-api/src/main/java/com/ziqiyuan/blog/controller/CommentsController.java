package com.ziqiyuan.blog.controller;

import com.ziqiyuan.blog.service.CommentsService;
import com.ziqiyuan.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    ///comments/article/{id}
    @GetMapping("article/{id}")
    public Result comments(@PathVariable("id") Long id) {
        return commentsService.commentsByArticleId(id);
    }
}
