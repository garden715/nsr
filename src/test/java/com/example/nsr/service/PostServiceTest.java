package com.example.nsr.service;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.nsr.domain.posts.Posts;
import com.example.nsr.domain.posts.PostsRepository;
import com.example.nsr.dto.posts.PostsSaveRequestDto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void Dto데이터가_posts테이블에_저장된다() {
        PostsSaveRequestDto dto = PostsSaveRequestDto.builder().author("jojoldu@gmail.com").content("테스트")
                .title("테스트 타이틀").build();

        // when
        postsService.save(dto);

        // then
        Posts posts = postsRepository.findAll().get(0);

        assertAll(() -> assertEquals(posts.getAuthor(), dto.getAuthor()),
                () -> assertEquals(posts.getContent(), dto.getContent()),
                () -> assertEquals(posts.getTitle(), dto.getTitle()));
    }
}