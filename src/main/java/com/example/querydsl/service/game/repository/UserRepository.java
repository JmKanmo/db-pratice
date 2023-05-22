package com.example.querydsl.service.game.repository;

import com.example.querydsl.service.game.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
