package com.ziqiyuan.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziqiyuan.blog.dao.pojo.Article;
import com.ziqiyuan.blog.dao.pojo.ArticleBody;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleBodyMapper extends BaseMapper<ArticleBody> {
}
