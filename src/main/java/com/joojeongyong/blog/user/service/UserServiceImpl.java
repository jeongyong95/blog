package com.joojeongyong.blog.user.service;

import com.joojeongyong.blog.user.domain.User;
import com.joojeongyong.blog.user.repository.UserDTO;
import com.joojeongyong.blog.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public UserDTO.UserDisplayDTO getUserInfo(String email) {
        return null;
    }

    @Override
    public Page<UserDTO.UserDisplayDTO> getUserInfoPage(Pageable pageable) {
        return null;
    }

    @Override
    public void registerUser(UserDTO.UserRegiDTO registerDTO) {
        userRepo.save(registerDTO.toEntity());
    }

}
