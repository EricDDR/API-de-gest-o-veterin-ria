package com.example.authapi.controller;

import com.example.authapi.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.authapi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            authService.register(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) throws Exception {
        return authService.login(user.getUsername(), user.getPassword());
    }
}
