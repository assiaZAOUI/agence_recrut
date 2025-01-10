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

    // Une offre peut être liée à plusieurs journaux
    @ManyToMany
    @JoinTable(
            name = "offre_journal",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "journal_id")
    )
    private List<Journal> journaux;

    // Une offre peut contenir plusieurs annonces
    @OneToMany(mappedBy = "offre")
    private List<Annonce> annonces;

}
