package com.joojeongyong.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = {"/", "/index"})
@Controller
public class MainController {

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping(path = "about")
    public String about() {
        return "about";
    }

    @GetMapping(path = "post")
    public String post() {
        return "post";
    }

    @GetMapping(path = "contact")
    public String contact() {
        return "contact";
    }
}
