package com.ziqiyuan.blog.service;

import com.ziqiyuan.blog.dao.pojo.Tag;
import com.ziqiyuan.blog.vo.Result;
import com.ziqiyuan.blog.vo.TagVo;

import java.util.List;
import java.util.Map;

public interface TagService {

    /**
     * 根据文章id查询标签列表
     * @param articleId
     * @return
     */
    List<TagVo>  findTagsByArticleId(Long articleId);

    Result hots(int limit);

    /**
     * 查询所有的文章标签
     * @return
     */
    Result findAll();
}
