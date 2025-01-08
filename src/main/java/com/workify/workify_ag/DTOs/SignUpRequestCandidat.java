package com.workify.workify_ag.DTOs;

import lombok.Data;

@Data
public class SignUpRequestCandidat {
    private String email;
    private String telephone;
    private String nom;
    private String prenom;
    private String password;
}
