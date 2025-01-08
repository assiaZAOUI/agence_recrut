package com.workify.workify_ag.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entreprise extends User{
    private String adresse;
    private String telephone;
    private String photo;
    private String ville;
    private String nomEntreprise;
    private String raisonSocial;
    private String description;
}
