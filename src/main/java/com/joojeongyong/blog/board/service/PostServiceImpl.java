package com.joojeongyong.blog.board.service;

import com.joojeongyong.blog.board.domain.Post;
import com.joojeongyong.blog.board.repository.PostDTO;
import com.joojeongyong.blog.board.repository.PostRepository;
import com.joojeongyong.blog.utility.objectMapper.PostMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class PostServiceImpl implements PostService {

    @Resource
    private PostRepository postRepo;
    @Resource
    private PostMapper postMapper;

    @Override
    public void registerPost(PostDTO.PostRegisterDTO postRegisterDTO) {
        postRepo.save(postRegisterDTO.toEntity());
    }

    @Override
    public PostDTO.PostDisplayDTO getPost(Long id) {
        Optional<Post> post = postRepo.findById(id);
        if (post.isPresent()) {
            return postMapper.toPostDisplayDTO(post.get(), post.get().getUser());
        }
        return new PostDTO.PostDisplayDTO();
    }

    @Override
    public Page<PostDTO.PostDisplayDTO> getPostPage(Pageable pageable) {
        Page<Post> postPage = postRepo.findAll(pageable);
        List<PostDTO.PostDisplayDTO> displayDTOList = postMapper.toDisplayDTOList(postPage.getContent());
        return new PageImpl<PostDTO.PostDisplayDTO>(displayDTOList, pageable, postPage.getTotalElements());
    }


    @Override
    public Page<PostDTO.PostDisplayDTO> searchPost(Pageable pageable, Integer searchType, String searchKeyword) {
        Page<Post> postPage = Page.empty();

        if (searchType == 0) {
            postPage = postRepo.findByTitleContainingOrContentContaining(pageable, searchKeyword, searchKeyword);
        }
        if (searchType == 1) {
            postPage = postRepo.findByTitleContaining(pageable, searchKeyword);
        }
        if (searchType == 2) {
            postPage = postRepo.findByContentContaining(pageable, searchKeyword);
        }

        List<PostDTO.PostDisplayDTO> displayDTOList = postMapper.toDisplayDTOList(postPage.getContent());
        return new PageImpl<PostDTO.PostDisplayDTO>(displayDTOList, pageable, postPage.getTotalElements());
    }

    @Override
    public void deletePost(Long postId) {
        postRepo.deleteById(postId);
    }

}
