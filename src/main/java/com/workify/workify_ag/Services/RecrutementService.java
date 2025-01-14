package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Entities.Recrutement;

import java.util.Date;
import java.util.List;

public interface RecrutementService {
    Recrutement ajouterRecrutement(Offre offre, Candidat candidat, Date dateRecrutement);
    List<Recrutement> getHistoriqueRecrutement();
    Recrutement recruterCandidat(Long offreId, Long candidatId);
}
