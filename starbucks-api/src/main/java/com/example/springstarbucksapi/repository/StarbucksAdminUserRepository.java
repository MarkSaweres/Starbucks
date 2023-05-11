package com.example.springstarbucksapi.repository;

import com.example.springstarbucksapi.model.StarbucksAdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarbucksAdminUserRepository extends JpaRepository<StarbucksAdminUser, Long> {
    Optional<StarbucksAdminUser> findByUserName(String userName);
    Optional<StarbucksAdminUser> findByUserNameAndPassword(String userName, String password);
}
