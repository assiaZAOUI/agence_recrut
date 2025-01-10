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

    // Relation 1:N avec Abonnement
    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    private List<Abonnement> abonnements;

    // Relation N:N avec Offre
    @ManyToMany
    @JoinTable(
            name = "entreprise_offre",
            joinColumns = @JoinColumn(name = "entreprise_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id")
    )
    private List<Offre> offres;
}
