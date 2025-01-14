package com.workify.workify_ag.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @ManyToOne
    @JoinColumn(name = "edition_id", nullable = false)
    private Edition edition;
    @OneToMany(mappedBy = "offre")
    @JsonManagedReference // Gère la sérialisation de ce côté
    private List<Annonce> annonces;
    //une Offre est associée à une seule Entreprise
    @ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;
}
