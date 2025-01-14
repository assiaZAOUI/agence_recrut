package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Entities.Recrutement;

import java.util.Date;
import java.util.List;

public interface RecrutementService {
    Recrutement ajouterRecrutement(Long offreId, Long candidatId);
    List<Recrutement> getHistoriqueRecrutement();
    Recrutement recruterCandidat(Long offreId, Long candidatId);
}
