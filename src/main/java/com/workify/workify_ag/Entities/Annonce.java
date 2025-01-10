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

    // Chaque annonce est liée à une offre
    @ManyToOne
    @JoinColumn(name = "offre_id")
    private Offre offre;

    // Une annonce peut être liée à plusieurs candidats
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;

}
