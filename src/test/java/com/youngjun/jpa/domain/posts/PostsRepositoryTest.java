package com.youngjun.jpa.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
//        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "게시글 제목";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // save 메서드 : 테이블에 id 값이 있다면 update, 없다면 insert 쿼리 실행
                .title(title)
                .content(content)
                .author("youngjun108059@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll(); // 모든 데이터를 조회

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}