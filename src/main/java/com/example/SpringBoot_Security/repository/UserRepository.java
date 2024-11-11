package com.example.SpringBoot_Security.repository;

import com.example.SpringBoot_Security.entity.UsersEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {

    UsersEntity findByUsername(String username);
}
