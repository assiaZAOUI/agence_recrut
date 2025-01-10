package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Annonce {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long annonceId;

    @ManyToOne
    @JoinColumn(name = "entreprise_id")
    private Entreprise entreprise; // L'entreprise qui a publié l'annonce

    // Relation N:N avec Offre
    @ManyToMany(mappedBy = "annonces")
    private List<Offre> offres;

    // Relation N:N avec Edition
    @ManyToMany
    @JoinTable(
            name = "annonce_edition",
            joinColumns = @JoinColumn(name = "annonce_id"),
            inverseJoinColumns = @JoinColumn(name = "edition_id")
    )
    private List<Edition> editions;

    // Relation N:N avec Candidat
    @ManyToMany
    @JoinTable(
            name = "candidat_annonce",
            joinColumns = @JoinColumn(name = "annonce_id"),
            inverseJoinColumns = @JoinColumn(name = "candidat_id")
    )
    private List<Candidat> candidats;

}
