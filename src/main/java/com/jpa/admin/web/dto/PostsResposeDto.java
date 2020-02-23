package com.jpa.admin.web.dto;

import com.jpa.admin.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResposeDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResposeDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
