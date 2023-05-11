package com.example.springstarbucksapi.service;

import com.example.springstarbucksapi.model.StarbucksAdminUser;
import com.example.springstarbucksapi.repository.StarbucksAdminUserRepository;
import com.example.springstarbucksapi.rest.StarbucksAdminUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StarbucksAdminUserService {
    @Autowired
    private StarbucksAdminUserRepository starbucksAdminUserRepository;

    public void createUser(StarbucksAdminUserController.AdminUser adminUser) {
        if (Objects.isNull(adminUser.getUserName()) || adminUser.getUserName().length() < 5) {
            throw new IllegalArgumentException("Username must be least 5 characters long");
        }
        if (Objects.isNull(adminUser.getPassword()) || adminUser.getPassword().length() < 5) {
            throw new IllegalArgumentException("Password must be least 5 characters long");
        }

        StarbucksAdminUser starbucksAdminUser = new StarbucksAdminUser(adminUser.getUserName(), adminUser.getPassword());

        starbucksAdminUserRepository.save(starbucksAdminUser);
    }

    public ResponseEntity<Void> logIn(StarbucksAdminUserController.AdminUser adminUser) {
        Optional<StarbucksAdminUser> foundUserOptional = starbucksAdminUserRepository.findByUserNameAndPassword(adminUser.getUserName(), adminUser.getPassword());

        if (foundUserOptional.isEmpty()) {
            throw new IllegalArgumentException("Username or password is incorrect");
        } else {
            StarbucksAdminUser starbucksAdminUser = foundUserOptional.get();
            // Flag the user as being logged in
            starbucksAdminUser.setIsLoggedIn(true);
            starbucksAdminUserRepository.save(starbucksAdminUser);

            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<?> checkIsLoggedIn(StarbucksAdminUserController.AdminUserNameRequest userNameWrapper) {
        Optional<StarbucksAdminUser> foundUserOptional = starbucksAdminUserRepository.findByUserName(userNameWrapper.getUserName());

        if (foundUserOptional.isEmpty()) {
            throw new IllegalArgumentException("User does not exist in the database");
        } else {
            StarbucksAdminUser starbucksAdminUser = foundUserOptional.get();

            // Send a response indicating whether the user is logged in
            StarbucksAdminUserController.AdminUserIsLoggedInResponse adminUserIsLoggedInResponse = new StarbucksAdminUserController.AdminUserIsLoggedInResponse(starbucksAdminUser.getIsLoggedIn());

            return ResponseEntity.ok(adminUserIsLoggedInResponse);
        }
    }


    public ResponseEntity<?> logOut(StarbucksAdminUserController.AdminUserNameRequest userNameWrapper) {
        Optional<StarbucksAdminUser> foundUserOptional = starbucksAdminUserRepository.findByUserName(userNameWrapper.getUserName());

        if (foundUserOptional.isEmpty()) {
            throw new IllegalArgumentException("User does not exist in the database");
        } else {
            StarbucksAdminUser starbucksAdminUser = foundUserOptional.get();
            // Flag the user as being logged out
            starbucksAdminUser.setIsLoggedIn(false);
            starbucksAdminUserRepository.save(starbucksAdminUser);

            return ResponseEntity.ok().build();
        }
    }
}
