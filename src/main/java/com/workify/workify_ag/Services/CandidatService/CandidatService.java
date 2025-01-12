package com.workify.workify_ag.Services.CandidatService;

import com.workify.workify_ag.DTOs.CandiatDTO.*;
import org.springframework.stereotype.Service;

@Service
public interface CandidatService {

    public void modifierSalaire(ModifierSalaireCandidat modifierSalaireCandidat);

    public void supprimerSalaire(SuppDeCandidat suppSalaireCandidat);

    public void modifierExperience(ModifierExperienceCandidat modifierExperienceCandidat);

    public void supprimerExperience(SuppDeCandidat suppExperienceCandidat);

    public void modifierDiplome(ModifierDiplomeCandidat modifierDiplomeCandidat);

    public void supprimerDiplome(SuppDeCandidat suppDiplomeCandidat);

    public void modifierCv(CvLettreMotivation updatedCvLettreMotivation);

}

