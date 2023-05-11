package com.example.springstarbucksclient.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthCommand {
    String userName;
    String password;
}
