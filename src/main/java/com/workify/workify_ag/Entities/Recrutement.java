package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recrutement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "offre_id", nullable = false)
    private Offre offre;

    @ManyToOne
    @JoinColumn(name = "demandeur_id", nullable = false)
    private Candidat candidat;

    private Date dateRecrutement;

    // Constructeur pour faciliter la création d'un recrutement
    public Recrutement(Offre offre, Candidat candidat, Date dateRecrutement) {
        this.offre = offre;
        this.candidat = candidat;
        this.dateRecrutement = dateRecrutement;
    }

}
