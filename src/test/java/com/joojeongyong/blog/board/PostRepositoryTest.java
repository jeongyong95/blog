package com.joojeongyong.blog.board;

import com.joojeongyong.blog.board.repository.PostDTO;
import com.joojeongyong.blog.board.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class PostRepositoryTest {

    @Resource
    private PostRepository postRepo;

    @Test
    public void insertTest() {
        for (int i = 0; i < 200; i++) {
            PostDTO.PostRegisterDTO post = new PostDTO.PostRegisterDTO();
            post.setTitle("제목" + String.format("%3d", i));
            post.setContent("테스트 " + String.format("%3d", i) + "의 내용입니다.");
            postRepo.save(post.toEntity());
        }
    }
}
