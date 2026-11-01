package com.authentification.authentification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest extends UserResponseAbs {
    @NotBlank @Size(min = 8, message = "8 caractères minimum")
    private String password;
}
