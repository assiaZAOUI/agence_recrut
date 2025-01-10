package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("ENTREPRISE")
public class Entreprise extends User{
    private String adresse;
    private String telephone;
    private String photo;
    private String ville;
    private String nomEntreprise;
    private String raisonSocial;
    private String description;

    // Une entreprise peut avoir plusieurs abonnements
    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    private List<Abonnement> abonnements;
}
