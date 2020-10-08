package com.joojeongyong.blog.controller;

import com.joojeongyong.blog.user.domain.User;
import com.joojeongyong.blog.user.repository.UserDTO;
import com.joojeongyong.blog.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(path = "login")
    public ModelAndView getLoginForm() {
        return new ModelAndView("user/login", "loginDTO", new UserDTO.UserLoginDTO());
    }

    @GetMapping(path = "logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:";
    }

    @PostMapping(path = "checkLogin")
    public ModelAndView checkLoginForm(HttpSession session, RedirectAttributes redirectAttributes, UserDTO.UserLoginDTO loginDTO) {
        User user = userService.getUser(loginDTO.getEmail());
        String message = "비밀번호가 일치하지 않습니다.";

        if (user.getEmail().equals(loginDTO.getEmail()) && user.getPassword().equals(loginDTO.getPassword())) {
            session.setAttribute("loginUser", user);
            return new ModelAndView("redirect:");
        }

        if (!user.getEmail().equals(loginDTO.getEmail())) {
            message = "존재하지 않는 계정입니다.";
        }

        redirectAttributes.addAttribute("message", message);
        return new ModelAndView("redirect:login");
    }

    @GetMapping(path = "join")
    public ModelAndView getJoinForm() {
        return new ModelAndView("user/join", "registerDTO", new UserDTO.UserRegiDTO());
    }

    @PostMapping(path = "registerUser")
    public String registerUser(UserDTO.UserRegiDTO registerDTO) {
        userService.registerUser(registerDTO);

        return "redirect:login";
    }
}
