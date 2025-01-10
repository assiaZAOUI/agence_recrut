package com.workify.workify_ag.Entities;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Abonnement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long idAbonnement;
    private Date dateDebut;
    private Date dateExpiration;
    private boolean etat;

    // Relation N:1 avec Entreprise
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    // Relation N:N avec Journal
    @ManyToMany
    @JoinTable(
            name = "abonnement_journal",
            joinColumns = @JoinColumn(name = "abonnement_id"),
            inverseJoinColumns = @JoinColumn(name = "journal_id")
    )
    private List<Journal> journaux;
}