package com.joojeongyong.blog.repository;

import com.joojeongyong.blog.domain.board.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
