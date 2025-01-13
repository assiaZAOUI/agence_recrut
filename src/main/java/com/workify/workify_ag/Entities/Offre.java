package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Offre {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idOffre;//numero
    private String titre;
    private String ville;
    private String domaine;
    private int nbrPost;
    private int nbrAnneeExpDemander;
    private String CompetenceSouhaite;
    private boolean etat;
    private String niveauEtude;
    private Double salaire;

    // Une offre peut être présente dans plusieurs éditions
    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = false)
    private Edition edition;

    // Une offre peut contenir plusieurs annonces
    @OneToMany(mappedBy = "offre")
    private List<Annonce> annonces;
    @ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;
}
