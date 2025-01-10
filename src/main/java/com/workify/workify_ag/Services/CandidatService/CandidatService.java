package com.workify.workify_ag.Services.CandidatService;

import com.workify.workify_ag.DTOs.CandiatDTO.ModifierDiplomeCandidat;
import com.workify.workify_ag.DTOs.CandiatDTO.ModifierExperienceCandidat;
import com.workify.workify_ag.DTOs.CandiatDTO.ModifierSalaireCandidat;

public interface CandidatService {

    public void modifierSalaire(ModifierSalaireCandidat modifierSalaireCandidat);
    public void modifierExperience(ModifierExperienceCandidat modifierExperienceCandidat);
    public void modifierDiplome(ModifierDiplomeCandidat modifierDiplomeCandidat);
}
