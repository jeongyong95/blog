package com.joojeongyong.blog.domain.board;

import com.joojeongyong.blog.domain.user.User;

import javax.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
