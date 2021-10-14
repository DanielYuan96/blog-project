package com.ziqiyuan.blog.service.impl;

import com.ziqiyuan.blog.dao.mapper.TagMapper;
import com.ziqiyuan.blog.dao.pojo.Tag;
import com.ziqiyuan.blog.service.TagService;
import com.ziqiyuan.blog.vo.Result;
import com.ziqiyuan.blog.vo.TagVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public  List<TagVo>  findTagsByArticleId(Long articleId) {
        //mybatisplus 无法进行多表查询
        List<Tag>  tags =
                tagMapper.findTagsByArticleId(articleId);
        return copyList(tags);
    }

    @Override
    public Result hots(int limit) {
        /**
         * 1. 标签所拥有的文章数量最多 即为最热标签
         * 2. 查询 根据tag_id 分组 计数， 从大到小排列 取前 limit 个
         */
        List<Long> tagIds = tagMapper.findHotsTagIds(limit);
        //需要的是tagId 和 tagName Tag对象
        if (CollectionUtils.isEmpty(tagIds)) {
            return Result.success(Collections.emptyList());
        }
        List<Tag> tagList = tagMapper.findTagsByTagIds(tagIds);
        return Result.success(tagList);
    }

    public TagVo copy(Tag tag) {
        TagVo tagVo = new TagVo();
        BeanUtils.copyProperties(tag,tagVo);
        return tagVo;
    }

    public List<TagVo> copyList(List<Tag> tagList) {
        List<TagVo> tagVoList = new ArrayList<>();
        for (Tag tag : tagList) {
            tagVoList.add(this.copy(tag));
        }
        return tagVoList;
    }
}
