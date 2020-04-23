package com.springboot.test.testProject.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*** 실제 DB와 매칭될 클래스(Entity 클래스)
 *   절대 Setter 메소드를 만들지 않음, 필드의 값 변경이 필요하면 명확히 그 목적을 나타낼 수 있는 메소드 추가!
 *
 *   어떻게 값을 채워 DB에 삽입할까?
 *
 *   */
@Getter
@NoArgsConstructor //기본생성자( public Post(){} )생성
@Entity
public class Posts extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //Todo) 해당 클래스의 빌더패턴 클래스 생성, 생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
/*
@Entity : 테이블과 링크될 클래스 지정

@Id : 해당 테이블의 PK 필드

@GeneratedValue : PK의 규칙
                  boot2.0부터는 GenerationType.IDENTITY를 추가해야만 auto_increment가 됨
 */