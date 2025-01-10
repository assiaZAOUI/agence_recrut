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
    private int nbrAnneeExpDemander;
    private String CompetenceSouhaite;
    private boolean etat;
    private String niveauEtude;

    // Relation N:N avec Entreprise
    @ManyToMany(mappedBy = "offres")
    private List<Entreprise> entreprises;

    // Relation N:N avec Journal
    @ManyToMany(mappedBy = "offres")
    private List<Journal> journaux;

    // Relation N:N avec Annonce
    @ManyToMany
    @JoinTable(
            name = "offre_annonce",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "annonce_id")
    )
    private List<Annonce> annonces;
}
