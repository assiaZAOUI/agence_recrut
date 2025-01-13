package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEdition;
    @Column(unique = true)
    private int numEdition;
    private Date dateParrution;

    // Chaque édition est liée à un journal
    @ManyToOne
    @JoinColumn(name = "journal_id" ,nullable = false/*ne peut pas accepter de valeurs nulles*/)
    private Journal journal;

    // Relation avec Offre (ManyToOne)
    //eviter boucle
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offre_id", nullable = false)
    private Offre offre;
}