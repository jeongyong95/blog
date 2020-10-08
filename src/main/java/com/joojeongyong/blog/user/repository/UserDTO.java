package com.joojeongyong.blog.user.repository;

import com.joojeongyong.blog.user.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

public class UserDTO {

    @Data
    @NoArgsConstructor
    public static class UserRegiDTO {
        private String email;
        private String password;
        private String username;

        public User toEntity() {
            return User.builder().email(email).password(password).username(username).build();
        }
    }

    @Data
    @NoArgsConstructor
    public static class UserLoginDTO {
        private String email;
        private String password;
    }

    public static class UserDisplayDTO {
        private Long userId;
        private String email;
        private String username;
    }
}
