package com.ziqiyuan.blog.dao.pojo;

import lombok.Data;

@Data
public class Article {
    public static final Integer Article_TOP = 1;
    public static final Integer Article_Common = 0;

    private Long id;

    private String title;

    private String summary;

    private Integer commentCounts;

    private Integer viewCounts;

    private Long authorId;

    private Long bodyId;

    private Long categoryId;

    private Integer weight;

    private Long createDate;
}
