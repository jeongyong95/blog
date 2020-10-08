package com.joojeongyong.blog.board.domain;

import com.joojeongyong.blog.user.domain.User;
import com.joojeongyong.blog.utility.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;

    private String comment;

    @ManyToOne
    private Post post;

    @ManyToOne
    private User user;

    @Builder
    public Reply(String comment, Post post, User user) {
        this.comment = comment;
        this.post = post;
        this.user = user;
    }

    public void update(String comment) {
        this.comment = comment;
    }
}
