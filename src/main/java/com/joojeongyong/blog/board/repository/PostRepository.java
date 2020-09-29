package com.joojeongyong.blog.board.repository;

import com.joojeongyong.blog.board.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findByTitleContainingOrContentContaining(Pageable pageable, String titleKeyword, String contentKeyword);
    Page<Post> findByTitleContaining(Pageable pageable, String titleKeyword);
    Page<Post> findByContentContaining(Pageable pageable, String contentKeyword);
}
