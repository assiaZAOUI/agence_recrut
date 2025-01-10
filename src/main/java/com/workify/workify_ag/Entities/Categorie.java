package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idCategorie;
    private String libelle;

    // Relation 1:N avec Journal
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Journal> journaux;

}
