package com.example.querydsl.game.repository;

import com.example.querydsl.game.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
