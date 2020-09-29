package com.joojeongyong.blog.user.service;

import com.joojeongyong.blog.user.domain.User;

public interface UserService {

    User getUser(String email);
}
