package com.workify.workify_ag.DTOs.OffreDTO;

import lombok.Data;
import lombok.Getter;

@Data
public class OffreDTO {
    private String titre;
    private int nbrAnneeExpDemander;
    private String CompetenceSouhaite;
    private boolean Etat;
    private String niveauEtude;
    private String ville;
    private String domaine;

    public boolean getEtat(){
        return Etat;
    }
}
