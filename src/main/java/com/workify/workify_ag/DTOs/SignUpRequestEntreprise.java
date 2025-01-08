package com.workify.workify_ag.DTOs;

import com.workify.workify_ag.Entities.ENUM.Roles;
import lombok.Data;

@Data
public class SignUpRequestEntreprise {
    private String email;
    private String telephone;
    private String ville;
    private String nomEntreprise;
    private String password;
}
