package com.authentification.authentification.dto;

import com.authentification.authentification.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseAbs {
    private Long id;
    @NotBlank
    @Email
    private String email;
    @NotBlank @Size(min = 8, message = "le prenom est obligatoire")
    private  String prenom;
    @NotBlank @Size(min = 8, message = "le nom est obligatoire")
    private  String nom;
    private Role role;


}
