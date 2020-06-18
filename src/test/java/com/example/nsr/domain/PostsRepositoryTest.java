package com.example.nsr.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import com.example.nsr.domain.posts.Posts;
import com.example.nsr.domain.posts.PostsRepository;

@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @Test
    public void 게시글저장_불러오기() {
        // given
        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jungwon@seo.com").build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        assertAll(() -> assertEquals("테스트 게시글", posts.getTitle()), () -> assertEquals("테스트 본문", posts.getContent()));
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("jungwon@seo.com").build());
        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));
    }
}