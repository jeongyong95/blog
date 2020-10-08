package com.joojeongyong.blog.board.repository;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.domain.Reply;
import com.joojeongyong.blog.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    Page<Reply> findByPost(Pageable pageable, Post post);

    Page<Reply> findByUser(Pageable pageable, User user);
}
