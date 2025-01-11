package com.workify.workify_ag.DTOs.OffresDTO;

import lombok.Data;

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
