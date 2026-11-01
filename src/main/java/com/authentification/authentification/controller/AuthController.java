package com.authentification.authentification.controller;

import com.authentification.authentification.dto.AuthDto;
import com.authentification.authentification.dto.RegisterRequest;
import com.authentification.authentification.dto.UserResponseAbs;
import com.authentification.authentification.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public UserResponseAbs createUser(RegisterRequest registerRequest) {
        return authService.createUser(registerRequest);
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthDto authDto){
        Authentication auth = authService.login(authDto);
        return "Authentification réussie ";
    }
}
