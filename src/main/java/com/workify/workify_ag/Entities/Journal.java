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

    // Chaque journal appartient à une catégorie
    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    // Un journal peut être lié à plusieurs abonnements
    @OneToMany(mappedBy = "journal")
    private List<Abonnement> abonnements;

    // Un journal peut avoir plusieurs éditions
    @OneToMany(mappedBy = "journal")
    private List<Edition> editions;
}
