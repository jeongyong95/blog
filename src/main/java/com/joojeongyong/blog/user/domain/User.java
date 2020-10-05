package com.joojeongyong.blog.user.domain;

import com.joojeongyong.blog.board.domain.Post;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String email;
    private String password;
    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    Set<Post> postList = new HashSet<>();

    @Builder
    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
