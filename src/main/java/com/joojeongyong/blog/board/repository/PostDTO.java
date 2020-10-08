package com.joojeongyong.blog.board.repository;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PostDTO {

    @Data
    @NoArgsConstructor
    public static class PostRegisterDTO {
        private String title;
        private String content;
        private User user;

        public Post toEntity() {
            return Post.builder().title(title).content(content).user(user).build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class PostDisplayDTO {
        private Long postId;
        private String title;
        private String content;
        private String username;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }
}
