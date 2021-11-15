package com.jojoldu.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest     // @SpringBootTest 사용시 설정없이 H2database자동 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  // Junit 단위 테스트가 끌날때 수행
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()                // C,U 쿼리 실행
                .title(title)
                .content(content)
                .author("jimiboy@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();  // selectAll과 동일

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록(){
        // given
        LocalDateTime now = LocalDateTime.of(2021,11,4,0,0,0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>>>> createDate=" + posts.getCreatDate()
                + ", modifiedDate = " + posts.getModifiedDate());
        assertThat(posts.getCreatDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
