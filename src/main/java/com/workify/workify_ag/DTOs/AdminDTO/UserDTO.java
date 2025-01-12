package com.workify.workify_ag.DTOs.AdminDTO;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String type;
    private String nom;
    private String prenom;
    private String nomEntreprise;
    private String email;
    private Date dateCreationCompte;
}
