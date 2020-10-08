package com.joojeongyong.blog.board.service;

import com.joojeongyong.blog.board.repository.PostDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    //    Create
    void registerPost(PostDTO.PostRegisterDTO postRegisterDTO);


    //    Read
    PostDTO.PostDisplayDTO getPost(Long id);

    Page<PostDTO.PostDisplayDTO> getPostPage(Pageable pageable);

    Page<PostDTO.PostDisplayDTO> searchPost(Pageable pageable, Integer searchType, String searchKeyword);

//    Update

//    Delete
    void deletePost(Long postId);
}
