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

    // Relation Many-to-One avec Candidature
    @ManyToOne
    @JoinColumn(name = "candidature_id", nullable = false)
    private Candidature candidature;

    // Date du recrutement
    private Date dateRecrutement;

    // Constructeur pour faciliter la création d'un recrutement
    public Recrutement(Candidature candidature, Date dateRecrutement) {
        this.candidature = candidature;
        this.dateRecrutement = dateRecrutement;
    }
}
