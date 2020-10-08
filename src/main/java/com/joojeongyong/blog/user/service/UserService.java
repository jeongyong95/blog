package com.joojeongyong.blog.user.service;

import com.joojeongyong.blog.user.domain.User;
import com.joojeongyong.blog.user.repository.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User getUser(String email);
    UserDTO.UserDisplayDTO getUserInfo(String email);
    Page<UserDTO.UserDisplayDTO> getUserInfoPage(Pageable pageable);

    void registerUser(UserDTO.UserRegiDTO registerDTO);
}
