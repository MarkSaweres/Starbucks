package com.example.springstarbucksapi.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STARBUCKS_USER", indexes = @Index(name = "userNameUniqueIndex", columnList = "userName", unique = true))
@Data
@RequiredArgsConstructor
public class StarbucksAdminUser {

    private @Id
    @GeneratedValue
    @JsonIgnore  /* https://www.baeldung.com/jackson-ignore-properties-on-serialization */
            Long id;

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean isLoggedIn = false;

    public StarbucksAdminUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
