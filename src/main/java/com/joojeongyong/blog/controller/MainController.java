package com.joojeongyong.blog.controller;

import com.joojeongyong.blog.board.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class MainController {

    @Resource
    private PostService postService;

    //    파라미터로 Pageable 객체가 존재하면, Spring MVC가 객체를 생성하려고 시도한다.
    //    이때 pageable의 기본값은 page : 0, size : 20이다
    @GetMapping
    public String index(Model model, @PageableDefault(size = 7, sort = {"postId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        model.addAttribute("resultList", postService.getPostPage(pageable));
        return "index";
    }

    @GetMapping(path = "about")
    public String about() {
        return "about";
    }

    @GetMapping(path = "contact")
    public String contact() {
        return "contact";
    }

    @GetMapping(path = "search")
    public ModelAndView searchPost(Pageable pageable, Integer searchType, String searchKeyword) {
        return new ModelAndView("index", "resultList", postService.searchPost(pageable, searchType, searchKeyword));
    }
}
