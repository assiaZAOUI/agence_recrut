package com.workify.workify_ag.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Edition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEdition;
    private int numEdition;
    private Date dateParrution;

    // Relation N:1 avec Journal
    @ManyToOne
    @JoinColumn(name = "journal_id")
    private Journal journal;

    // Relation N:N avec Annonce
    @ManyToMany(mappedBy = "editions")
    private List<Annonce> annonces;

}