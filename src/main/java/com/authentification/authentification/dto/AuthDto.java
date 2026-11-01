package com.authentification.authentification.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthDto {
    @NotBlank
    @Email
    private String email;
    @NotBlank @Size(min = 8, message = "8 caractères minimum")
    private String password;
}
