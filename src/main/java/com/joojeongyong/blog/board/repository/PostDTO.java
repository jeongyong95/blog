package com.joojeongyong.blog.board.repository;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

public class PostDTO {

    @NoArgsConstructor
    @Data
    public static class PostRegisterDTO {
        private String title;
        private String content;
        private User user;

        public Post toEntity() {
            return Post.builder().title(title).content(content).user(user).build();
        }
    }
}
