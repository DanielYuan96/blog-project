package com.ziqiyuan.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ziqiyuan.blog.dao.mapper.CategoryMapper;
import com.ziqiyuan.blog.dao.pojo.Category;
import com.ziqiyuan.blog.service.CategoryService;
import com.ziqiyuan.blog.vo.CategoryVo;
import com.ziqiyuan.blog.vo.Result;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public CategoryVo findCategoryById(Long categoryId) {
        Category category = categoryMapper.selectById(categoryId);
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(categoryVo, category);
        return categoryVo;
    }

    @Override
    public Result findAll() {
        List<Category> categories =
                categoryMapper.selectList(new LambdaQueryWrapper<>());
        //和页面交互的对象应为Vo对象

        return Result.success(copyList(categories));
    }

    public CategoryVo copy(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }
    public List<CategoryVo> copyList(List<Category> categoryList) {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryVoList.add(copy(category));
        }
        return categoryVoList;
    }
}
