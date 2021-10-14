package com.ziqiyuan.blog.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.ziqiyuan.blog.dao.mapper.ArticleMapper;
import com.ziqiyuan.blog.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper, Article article) {
        int viewCounts = article.getViewCounts();
        Article articleUpdate = new Article();
        articleUpdate.setViewCounts(viewCounts + 1);
        LambdaUpdateWrapper<Article> updateWrapper =
                new LambdaUpdateWrapper<>();
        updateWrapper.eq(Article::getId,article.getId());
        updateWrapper.eq(Article::getViewCounts,viewCounts);
        // update article set view_count=100 where view_count=99 and id=11
        articleMapper.update(articleUpdate,updateWrapper);
        try {
            Thread.sleep(5000);
            System.out.println("更新完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
