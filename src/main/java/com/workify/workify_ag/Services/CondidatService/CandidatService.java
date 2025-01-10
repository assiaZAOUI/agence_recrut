package com.workify.workify_ag.Services.CondidatService;

import com.workify.workify_ag.DTOs.ModifierDiplomeCandidat;
import com.workify.workify_ag.DTOs.ModifierExperienceCandidat;
import com.workify.workify_ag.DTOs.ModifierSalaireCandidat;

public interface CandidatService {

    public void modifierSalaire(ModifierSalaireCandidat modifierSalaireCandidat);
    public void modifierExperience(ModifierExperienceCandidat modifierExperienceCandidat);
    public void modifierDiplome(ModifierDiplomeCandidat modifierDiplomeCandidat);
}
