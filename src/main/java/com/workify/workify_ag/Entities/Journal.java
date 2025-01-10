package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor

public class Journal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long code;
    private String nom;
    private String libelle;
    private String Langues;
    private String imageJournal;
    private String periodicite;

    // Relation N:N avec Abonnement
    @ManyToMany(mappedBy = "journaux")
    private List<Abonnement> abonnements;

    // Relation N:N avec Offre
    @ManyToMany
    @JoinTable(
            name = "offre_journal",
            joinColumns = @JoinColumn(name = "journal_id"),
            inverseJoinColumns = @JoinColumn(name = "offre_id")
    )
    private List<Offre> offres;

    // Relation N:1 avec Categorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Relation 1:N avec Edition
    @OneToMany(mappedBy = "journal", cascade = CascadeType.ALL)
    private List<Edition> editions;
}
