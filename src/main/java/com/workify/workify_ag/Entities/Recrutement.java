package com.workify.workify_ag.Entities;

import jakarta.persistence.*;

import java.util.Date;

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

}