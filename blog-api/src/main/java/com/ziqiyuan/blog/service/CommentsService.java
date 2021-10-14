package com.ziqiyuan.blog.service;

import com.ziqiyuan.blog.vo.Result;

public interface CommentsService {

    /**
     * 根据文章id 查询所有的评论列表
     * @param id
     * @return
     */
    Result commentsByArticleId(Long id);
}