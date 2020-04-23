package com.springboot.test.testProject.web.dto;

/* Controller 와 Service에서 사용할 DTO클래스
*  반드시, Entity 클래스와 Controller에서 사용하는 DTO클래스는 분리해서 사용!!
* */

import com.springboot.test.testProject.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public Posts toEntity() {
        return Posts.builder().title(title)
                            .content(content)
                            .author(author)
                            .build();
    }
}
