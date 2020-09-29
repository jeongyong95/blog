package com.joojeongyong.blog.user.repository;

import com.joojeongyong.blog.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDTO {

    @NoArgsConstructor
    @Data
    public static class UserRegiDTO {
        private String email;
        private String password;
        private String username;

        public User toEntity() {
            return User.builder().email(email).password(password).username(username).build();
        }
    }

    @NoArgsConstructor
    @Data
    public static class UserLoginDTO {
        private String email;
        private String password;
    }
}
