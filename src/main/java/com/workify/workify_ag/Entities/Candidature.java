package com.workify.workify_ag.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.workify.workify_ag.Entities.ENUM.StatutCandidature;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Candidature {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCandidature;

    // Chaque annonce est liée à une offre
    @ManyToOne
    @JoinColumn(name = "offre_id", referencedColumnName = "idOffre", nullable = false)
    @JsonBackReference // Ignore la sérialisation de ce côté
    private Offre offre; // L'offre à laquelle le candidat postule

    // Une annonce peut être liée à plusieurs candidats
    @ManyToOne
    @JoinColumn(name = "candidat_id")
    private Candidat candidat;// Le candidat qui postule

    @Enumerated(EnumType.STRING)
    private StatutCandidature statut;

}
