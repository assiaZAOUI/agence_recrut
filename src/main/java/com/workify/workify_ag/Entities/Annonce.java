package com.workify.workify_ag.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Entreprise entreprise; // L'entreprise qui a publié l'offre

    // Chaque annonce est liée à une offre
    @ManyToOne
    @JoinColumn(name = "offre_id")
    @JsonBackReference // Ignore la sérialisation de ce côté
    private Offre offre; // L'offre à laquelle le candidat postule

    // Une annonce peut être liée à plusieurs candidats
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;// Le candidat qui postule

}
