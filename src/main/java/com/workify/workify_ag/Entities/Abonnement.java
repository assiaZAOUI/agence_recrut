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

    // Chaque abonnement est lié à une entreprise
    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise;

    // Chaque abonnement est lié à un journal
    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;
}