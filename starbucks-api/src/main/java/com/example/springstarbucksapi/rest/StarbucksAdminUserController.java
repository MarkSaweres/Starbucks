package com.example.springstarbucksapi.rest;

import com.example.springstarbucksapi.service.StarbucksAdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/* See:  https://spring.io/guides/gs/rest-service/ */

@RestController
@RequestMapping("authentication")
public class StarbucksAdminUserController {

    @Autowired
    private StarbucksAdminUserService starbucksAdminUserService;

    public static class AdminUser {
        private String userName;
        private String password;

        public AdminUser(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class AdminUserNameRequest {
        private String userName;

        public AdminUserNameRequest() {
        }

        public AdminUserNameRequest(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }
    }

    public static class AdminUserIsLoggedInResponse {
        private boolean isLoggedIn;

        public AdminUserIsLoggedInResponse(boolean isLoggedIn) {
            this.isLoggedIn = isLoggedIn;
        }

        public boolean getIsLoggedIn() {
            return isLoggedIn;
        }
    }

    @PostMapping("registration")
    public void createUser(@RequestBody AdminUser adminUser) {
        starbucksAdminUserService.createUser(adminUser);
    }

    @PostMapping
    public ResponseEntity<Void> logIn(@RequestBody AdminUser adminUser) {
        return starbucksAdminUserService.logIn(adminUser);
    }

    @PostMapping("validation")
    public ResponseEntity<?> checkIsLoggedIn(@RequestBody AdminUserNameRequest userNameWrapper) {
        return starbucksAdminUserService.checkIsLoggedIn(userNameWrapper);
    }

    @DeleteMapping
    public ResponseEntity<?> logOut(@RequestBody AdminUserNameRequest userNameWrapper) {
        return starbucksAdminUserService.logOut(userNameWrapper);
    }
}