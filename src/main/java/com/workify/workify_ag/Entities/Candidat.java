package com.workify.workify_ag.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Candidat extends User{
    private String adresse;
    private String telephone;
    private String photo;
    private String ville;
    private String nom;
    private String prenom;
    private String experience;
    private String nomEntreExp;
    private String fonction;
    private String cv;
    private String lettreMotivation;
    private String motivation;
    private String filiere;
    private String diplome;
    private int nbrAnneeExperiences;
    private double salaireSouhaite;

}
