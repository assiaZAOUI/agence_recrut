package com.workify.workify_ag.Controllers.CandidatControllers;

import com.workify.workify_ag.DTOs.CandiatDTO.*;
import com.workify.workify_ag.Services.CandidatService.CandidatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class CandidatController {

    private final CandidatServiceImp candidatServiceImp;

    @Autowired
    public CandidatController(CandidatServiceImp candidatServiceImp) {
        this.candidatServiceImp = candidatServiceImp;
    }
    @PutMapping("/modifierSalaire")
    public ResponseEntity<String> modifierSalaire(@RequestBody ModifierSalaireCandidat modifierSalaireCandidat) {
        candidatServiceImp.modifierSalaire(modifierSalaireCandidat);
        return ResponseEntity.ok("Salaire mis à jour avec succès");
    }
    @PutMapping("/modifierExperience")
    public ResponseEntity<String> modifierExperience(@RequestBody ModifierExperienceCandidat modifierExperienceCandidat) {
        candidatServiceImp.modifierExperience(modifierExperienceCandidat);
        return ResponseEntity.ok("Expérience mise à jour avec succès");
    }
    @PutMapping("/modifierDiplome")
    public ResponseEntity<String> modifierDiplome(@RequestBody ModifierDiplomeCandidat modifierDiplomeCandidat) {
        candidatServiceImp.modifierDiplome(modifierDiplomeCandidat);
        return ResponseEntity.ok("Diplôme mis à jour avec succès");
    }
    @PutMapping("/supprimer_salaire")
    public ResponseEntity<String> supprimerSalaire(@RequestBody SuppDeCandidat suppSalaireCandidat) {
        try {
            candidatServiceImp.supprimerSalaire(suppSalaireCandidat);
            return ResponseEntity.ok("Salaire supprimé avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/supprimer_diplome")
    public ResponseEntity<String> supprimerDiplome(@RequestBody SuppDeCandidat suppDiplomeCandidat) {
        try {
            candidatServiceImp.supprimerDiplome(suppDiplomeCandidat);
            return ResponseEntity.ok("Diplôme supprimé avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/supprimer_experience")
    public ResponseEntity<String> supprimerExperience(@RequestBody SuppDeCandidat suppExperienceCandidat) {
        try {
            candidatServiceImp.supprimerExperience(suppExperienceCandidat);
            return ResponseEntity.ok("Expérience supprimée avec succès.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping("/modifierCv")
    public ResponseEntity<String> modifierCv(@RequestBody CvLettreMotivation updatedCvLettreMotivation) {
        try {
            candidatServiceImp.modifierCv(updatedCvLettreMotivation);
            return ResponseEntity.ok("CV mis à jour avec succès !");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/affichageCandidat/{candidatId}")
    public ResponseEntity<CandidatDTO> affichageCandidat(@PathVariable Long candidatId) {

        CandidatDTO cand =candidatServiceImp.afficheCandidat(candidatId);

        return ResponseEntity.ok(cand);
    }



}
