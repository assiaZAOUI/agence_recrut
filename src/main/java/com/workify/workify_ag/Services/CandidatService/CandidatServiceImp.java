package com.workify.workify_ag.Services.CandidatService;

import com.workify.workify_ag.DTOs.CandiatDTO.ModifierDiplomeCandidat;
import com.workify.workify_ag.DTOs.CandiatDTO.ModifierExperienceCandidat;
import com.workify.workify_ag.DTOs.CandiatDTO.ModifierSalaireCandidat;
import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Repositorys.CandidatRepo.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CandidatServiceImp implements CandidatService {

    private final CandidatRepository candidatRepository;

    @Autowired
    public CandidatServiceImp(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    @Override
    @Transactional
    public void modifierSalaire(ModifierSalaireCandidat modifierSalaireCandidat) {
        Candidat candidat = candidatRepository.findById(modifierSalaireCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + modifierSalaireCandidat.getIdCondidat()));

        candidat.setSalaireSouhaite(modifierSalaireCandidat.getNouveauSalaire());
        candidatRepository.save(candidat);
    }
    @Transactional
    public void modifierExperience(ModifierExperienceCandidat modifierExperienceCandidat) {
        Candidat candidat = candidatRepository.findById(modifierExperienceCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + modifierExperienceCandidat.getIdCondidat()));

        candidat.setExperience(modifierExperienceCandidat.getNouvelleExperience());
        candidatRepository.save(candidat);
    }

    @Transactional
    public void modifierDiplome(ModifierDiplomeCandidat modifierDiplomeCandidat) {
        Candidat candidat = candidatRepository.findById(modifierDiplomeCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + modifierDiplomeCandidat.getIdCondidat()));

        candidat.setDiplome(modifierDiplomeCandidat.getNouveauDiplome());
        candidatRepository.save(candidat);
    }


}
