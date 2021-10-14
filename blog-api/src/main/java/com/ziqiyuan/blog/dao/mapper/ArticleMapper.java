package com.ziqiyuan.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziqiyuan.blog.dao.dos.Archives;
import com.ziqiyuan.blog.dao.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}
