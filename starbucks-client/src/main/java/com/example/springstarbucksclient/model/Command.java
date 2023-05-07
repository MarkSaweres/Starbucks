package com.example.springstarbucksclient.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Command {

    private String action ;
    private String message ;
    private String stores ;
    private String register ;

}
