package com.ziqiyuan.blog.service;

import com.ziqiyuan.blog.vo.CategoryVo;
import com.ziqiyuan.blog.vo.Result;

public interface CategoryService {
    /**
     * 查询类别
     * @param categoryId
     * @return
     */
    CategoryVo findCategoryById(Long categoryId);

    Result findAll();
}
