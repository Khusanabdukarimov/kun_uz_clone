package com.example.kunuz_clone.repository;

import com.example.kunuz_clone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
