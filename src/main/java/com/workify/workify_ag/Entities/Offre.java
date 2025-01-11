package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Offre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOffre;//numero
    private String numero;
    private String titre;
    private String ville;
    private String domaine;
    private int nbrAnneeExpDemander;
    private String CompetenceSouhaite;
    private boolean etat;
    private String niveauEtude;

    // Une offre peut être présente dans plusieurs éditions
    @OneToMany(mappedBy = "offre", cascade = CascadeType.ALL)
    private List<Edition> editions;

    // Une offre peut contenir plusieurs annonces
    @OneToMany(mappedBy = "offre")
    private List<Annonce> annonces;

}
