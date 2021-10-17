package com.ziqiyuan.blog.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ziqiyuan.blog.service.CommentsService;
import com.ziqiyuan.blog.vo.Result;
import com.ziqiyuan.blog.vo.params.CommentParam;
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

    @PostMapping("create/change")
    public Result comment(@RequestBody JSONObject commentJson) {
        System.out.println(commentJson.toJSONString());
        Long articleId =
                Long.parseLong((String)commentJson.getJSONObject("article").get(
                        "id"));
        String content = (String) commentJson.get("content");
        CommentParam commentParam = new CommentParam();
        commentParam.setArticleId(articleId);
        commentParam.setContent(content);
        if (commentJson.get("parent") != null) {
            commentParam.setParent(Long.parseLong((String)commentJson.getJSONObject(
                    "parent").get("id")));
        }
        if (commentJson.getJSONObject("toUser").get("id") != null) {
            commentParam.setToUserId(Long.parseLong((String)commentJson.getJSONObject(
                    "toUser").get("id")));
        }
        System.out.println(Long.parseLong((String)commentJson.getJSONObject(
                "toUser").get("id")));
        return commentsService.comment(commentParam);
    }
}
