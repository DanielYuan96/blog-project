package com.ziqiyuan.blog.vo.params;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

@Data
public class CommentParam {
    private Long articleId;

    private String content;

    private Long parent;

    private Long toUserId;
}
