package com.joojeongyong.blog.user.repository;

import com.joojeongyong.blog.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("delete from User")
    void deleteAllAdvanced();
}
