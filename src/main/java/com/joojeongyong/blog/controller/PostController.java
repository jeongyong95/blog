package com.joojeongyong.blog.controller;

import com.joojeongyong.blog.board.repository.PostDTO;
import com.joojeongyong.blog.board.service.PostService;
import com.joojeongyong.blog.user.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RequestMapping(path = "/post")
@Controller
public class PostController {

    @Resource
    private PostService postService;

    @GetMapping(path = "/writeForm")
    public ModelAndView getWriteForm() {
        return new ModelAndView("/post/write", "postRegisterDTO", new PostDTO.PostRegisterDTO());
    }

    @PostMapping("/write")
    public String writePost(HttpSession session, PostDTO.PostRegisterDTO postRegisterDTO) {
        User user = (User) session.getAttribute("loginUser");
        postRegisterDTO.setUser(user);
        postService.registerPost(postRegisterDTO);
        return "redirect:/";
    }

    @GetMapping(path = "/postView/{postId}")
    public ModelAndView getPost(@PathVariable Long postId) {
        return new ModelAndView("/post/postView", "post", postService.getPost(postId));
    }
}
