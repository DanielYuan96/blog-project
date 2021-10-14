package com.ziqiyuan.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ziqiyuan.blog.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

    /**
     * 根据文章id查询标签列表
     * @param articleLong
     * @return
     */
    List<Tag> findTagsByArticleId(@Value("articleLong") long articleLong  );

    /**
     * 查询最热的标签 前n条
     * @param limit
     * @return
     */
    List<Long> findHotsTagIds(int limit);

    List<Tag> findTagsByTagIds(List<Long> tagIds);

    //    List<Map<String, Object>> findTagsByArticleId2(@Value("articID") String
//     articID  );
}
