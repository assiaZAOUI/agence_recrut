package com.workify.workify_ag.DTOs.OffresDTO;

import com.workify.workify_ag.Entities.Edition;
import com.workify.workify_ag.Entities.Journal;
import lombok.Data;

@Data
public class OffreDTO {
    private String titre;
    private int nbrPost;
    private int nbrAnneeExpDemander;
    private String CompetenceSouhaite;
    private boolean Etat;
    private String niveauEtude;
    private Journal journal;
    private Edition edition;
    private double salaire;

    public boolean getEtat(){
        return Etat;
    }
}
