package com.joojeongyong.blog.board.service;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.repository.PostDTO;
import com.joojeongyong.blog.board.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostRepository postRepo;

    @Override
    public Post getPost(Long id) {
        Optional<Post> post = postRepo.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        return new PostDTO.PostRegisterDTO().toEntity();
    }

    @Override
    public Page<Post> getPostList(Pageable pageable) {
        return postRepo.findAll(pageable);
    }

    @Override
    public void registerPost(PostDTO.PostRegisterDTO postRegisterDTO) {
        postRepo.save(postRegisterDTO.toEntity());
    }

    @Override
    public Page<Post> searchPost(Pageable pageable, Integer searchType, String searchKeyword) {
        if (searchType == 0) {
            return postRepo.findByTitleContainingOrContentContaining(pageable, searchKeyword, searchKeyword);
        }
        if (searchType == 1) {
            return postRepo.findByTitleContaining(pageable, searchKeyword);
        }
        if (searchType == 2) {
            return postRepo.findByContentContaining(pageable, searchKeyword);
        }
        return (Page<Post>) Collections.EMPTY_LIST;
    }

}
