package com.joojeongyong.blog.repository;

import com.joojeongyong.blog.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
