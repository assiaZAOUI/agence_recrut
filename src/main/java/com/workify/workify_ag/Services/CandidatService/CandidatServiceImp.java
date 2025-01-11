package com.workify.workify_ag.Services.CandidatService;

import com.workify.workify_ag.DTOs.CandiatDTO.*;
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

    @Override
    @Transactional
    public void supprimerSalaire(SuppDeCandidat suppSalaireCandidat) {
        // Récupérer le candidat par son ID
        Candidat candidat = candidatRepository.findById(suppSalaireCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + suppSalaireCandidat.getIdCondidat()));

        candidat.setSalaireSouhaite(0.0);//impossi de mettre null dans ca

        // Sauvegarder les modifications dans la base de données
        candidatRepository.save(candidat);
    }


    @Transactional
    public void modifierExperience(ModifierExperienceCandidat modifierExperienceCandidat) {
        Candidat candidat = candidatRepository.findById(modifierExperienceCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + modifierExperienceCandidat.getIdCondidat()));

        candidat.setNomEntreExp(modifierExperienceCandidat.getNomExperience());
        candidat.setNbrAnneeExperiences(modifierExperienceCandidat.getNbrAnneExp());
        candidat.setExperience(modifierExperienceCandidat.getFonction());
        candidatRepository.save(candidat);
    }

    @Override
    @Transactional
    public void supprimerExperience(SuppDeCandidat suppExperienceCandidat) {
        Candidat candidat = candidatRepository.findById(suppExperienceCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + suppExperienceCandidat.getIdCondidat()));
        candidat.setExperience("");
        candidatRepository.save(candidat);

    }

    @Transactional
    public void modifierDiplome(ModifierDiplomeCandidat modifierDiplomeCandidat) {
        Candidat candidat = candidatRepository.findById(modifierDiplomeCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + modifierDiplomeCandidat.getIdCondidat()));

        candidat.setDiplome(modifierDiplomeCandidat.getNouveauDiplome());
        candidatRepository.save(candidat);
    }

    @Override
    @Transactional
    public void supprimerDiplome(SuppDeCandidat suppDiplomeCandidat) {
        Candidat candidat = candidatRepository.findById(suppDiplomeCandidat.getIdCondidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + suppDiplomeCandidat.getIdCondidat()));

        candidat.setDiplome("");
        candidatRepository.save(candidat);


    }
    @Override
    @Transactional
    public void modifierCv(CvLettreMotivation updatedCvLettreMotivation) {
        // Trouver le candidat par son ID
        Candidat candidat = candidatRepository.findById(updatedCvLettreMotivation.getIdCandidat())
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé avec l'ID : " + updatedCvLettreMotivation.getIdCandidat()));

        // Mettre à jour les informations du CV
        CvLettreMotivation cvLettreMotivation = updatedCvLettreMotivation;

            cvLettreMotivation.setSecteurActivite(updatedCvLettreMotivation.getSecteurActivite());
            cvLettreMotivation.setFonction(updatedCvLettreMotivation.getFonction());
            cvLettreMotivation.setNombreAnneeExp(updatedCvLettreMotivation.getNombreAnneeExp());
            cvLettreMotivation.setNiveauEtude(updatedCvLettreMotivation.getNiveauEtude());
            cvLettreMotivation.setVille(updatedCvLettreMotivation.getVille());
            cvLettreMotivation.setDisponibilite(updatedCvLettreMotivation.getDisponibilite());
            cvLettreMotivation.setCv(updatedCvLettreMotivation.getCv());
            cvLettreMotivation.setLettreMotivation(updatedCvLettreMotivation.getLettreMotivation());
            cvLettreMotivation.setMotivation(updatedCvLettreMotivation.getMotivation());

            // Sauvegarder les modifications
            candidatRepository.save(candidat);

    }

}





