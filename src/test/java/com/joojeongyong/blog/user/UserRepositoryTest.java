package com.joojeongyong.blog.user;

import com.joojeongyong.blog.user.domain.User;
import com.joojeongyong.blog.user.repository.UserDTO;
import com.joojeongyong.blog.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepo;

    @Test
    public void registerTest() {
        for (int i = 0; i < 1000; i++) {
            UserDTO.UserRegiDTO userDTO = new UserDTO.UserRegiDTO();
            userDTO.setEmail("tester" + String.format("%3d", i) + "@gmail.com");
            userDTO.setPassword("test" + String.format("%3d", i));
            userDTO.setUsername("tester" + String.format("%3d", i));
            userRepo.save(userDTO.toEntity());
        }
    }

    @Test
    public void updateTest() {
        for (int i = 1; i <= 300; i++) {
            Optional<User> updateToDTO = userRepo.findById((long) i);
            if (updateToDTO.isEmpty()) break;
            int finalI = i;
            updateToDTO.get().setEmail("NoUpdate Tester" + finalI+"@naver.com");
            userRepo.save(updateToDTO.get());
        }
    }

    @Test
    public void deleteTest() {
        userRepo.deleteAll();
    }

    @Test
    public void deleteAdvancedTest() {
        userRepo.deleteAllAdvanced();
    }
}
