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

    // Une catégorie peut contenir plusieurs journaux
    @OneToMany(mappedBy = "categorie")
    private List<Journal> journaux;

}
