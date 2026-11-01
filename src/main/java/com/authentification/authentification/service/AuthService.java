package com.authentification.authentification.service;

import com.authentification.authentification.dto.AuthDto;
import com.authentification.authentification.dto.RegisterRequest;
import com.authentification.authentification.dto.UserResponseAbs;
import com.authentification.authentification.entity.Role;
import com.authentification.authentification.entity.User;
import com.authentification.authentification.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private  final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public User toEntity(RegisterRequest registerRequest){
        return User.builder()
                .email(registerRequest.getEmail())
                .nom(registerRequest.getNom())
                .prenom(registerRequest.getPrenom())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.ADMIN).build();

    }
    public UserResponseAbs toDto(User user){
        return UserResponseAbs.builder()
                .id(user.getId())
                .nom(user.getNom())
                .prenom((user.getPrenom()))
                .role(user.getRole())
                .email(user.getEmail())
                .build();
    }


    public UserResponseAbs  createUser(RegisterRequest registerRequest) {
        if(userRepository.existsByEmail(registerRequest.getEmail())){
            throw new RuntimeException("le mail existe deja");
        }
        return toDto(userRepository.save(toEntity(registerRequest)));
    }

    public Authentication login(AuthDto authDto) {
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authDto.getEmail(),authDto.getPassword()));
    }
}
