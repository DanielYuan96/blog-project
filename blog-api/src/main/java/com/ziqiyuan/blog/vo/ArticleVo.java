package com.ziqiyuan.blog.vo;



import com.alibaba.fastjson.serializer.ToStringSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ArticleVo {
//    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Integer weight;

    private String createDate;

    private String author;

    private ArticleBodyVo body;

    private  List<TagVo>  tags;

    private CategoryVo category;
}
