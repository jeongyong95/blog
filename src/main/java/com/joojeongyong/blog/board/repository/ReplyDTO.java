package com.joojeongyong.blog.board.repository;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.domain.Reply;
import com.joojeongyong.blog.user.domain.User;

public class ReplyDTO {
    public static class ReplyRegisterDTO {
        private String comment;
        private Post post;
        private User user;

        public Reply toEntity() {
            return Reply.builder().comment(comment).post(post).user(user).build();
        }
    }
}
