package com.joojeongyong.blog.board.service;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.repository.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Post getPost(Long id);
    Page<Post> getPostList(Pageable pageable);
    void registerPost(PostDTO.PostRegisterDTO postRegisterDTO);
    Page<Post> searchPost(Pageable pageable, Integer searchType, String searchKeyword);
}
