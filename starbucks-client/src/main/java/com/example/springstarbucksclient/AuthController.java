package com.example.springstarbucksclient;

import com.example.springstarbucksclient.model.AuthCommand;
import com.example.springstarbucksclient.model.CashierOrder;
import com.example.springstarbucksclient.model.Command;
import com.example.springstarbucksclient.service.SpringCashierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private SpringCashierService springCashierService;

    @PostMapping
    public String handleLoginAttempt(@Valid @ModelAttribute("authCommand") AuthCommand authCommand,
                             Errors errors, Model model, HttpServletRequest request) {
        // Todo: if the username and password are not valid, redirect them back to the login page, but with a message that says the username and/or password is incorrect
        // TODO: make REST calls to he API via RestTemplate

        if (true) {
            model.addAttribute("message", "Failed to sign in - please check your username and password and try again");

            return "login";
        }

        // TODO: if the login is successful, set the cookie on the HttpServletResponse

//        model.addAttribute("message", message);
//        model.addAttribute("server", host_name + "/" + server_ip);

        return "starbucks";
    }

    @PostMapping("register")
    public String renderRegistrationForm(@Valid @ModelAttribute("authCommand") AuthCommand authCommand,
                                         Errors errors, Model model, HttpServletRequest request) {


        // TODO: if the signup is successful, set the cookie on the HttpServletResponse
        return "starbucks";
    }

    @PostMapping("registration")
    public String renderRegistrationForm() {
        return "signUp";
    }

    @PostMapping("/selectStore")
    public String selectStore(@RequestParam String store, HttpSession session) {
        session.setAttribute("store", store);
        return "redirect:/";
    }
}
