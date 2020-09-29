package com.joojeongyong.blog.user.service;

import com.joojeongyong.blog.user.domain.User;
import com.joojeongyong.blog.user.repository.UserDTO;
import com.joojeongyong.blog.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepo;

    @Override
    public User getUser(String email) {
        Optional<User> user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            return user.get();
        }
        return new UserDTO.UserRegiDTO().toEntity();
    }

}
