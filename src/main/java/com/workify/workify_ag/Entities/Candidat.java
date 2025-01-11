package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("CANDIDAT")
public class Candidat extends User{
    private String adresse;
    @Column(unique = true)
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

    // Un candidat peut postuler à plusieurs annonces
    @OneToMany(mappedBy = "candidat", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Annonce> annonces;

}
