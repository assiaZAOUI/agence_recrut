package com.workify.workify_ag.DTOs;

import lombok.Data;
import lombok.Getter;

@Data
public class OffreDTO {
    private String titre;
    private int nbrAnneeExpDemander;
    private String CompetenceSouhaite;
    @Getter
    private boolean etat;
    private String niveauEtude;
    private String ville;
    private String domaine;

    public boolean getEtat() {
        return etat;
    }
}
