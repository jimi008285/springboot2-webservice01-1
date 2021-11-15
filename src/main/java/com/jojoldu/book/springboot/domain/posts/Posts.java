package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // JPA 테이블과 링크될 클레스 표현
public class Posts extends BaseTimeEntity {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // springboot 2.0에선 IDENTITY를 사용시 increment 됨
    private Long id;

    @Column // 컬럼타입변경시 사용
    private String title;

    @Column
    private String content;

    private String author;

    @Builder // 빌드패턴사용 Lombok
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
