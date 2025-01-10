package com.workify.workify_ag.Controllers.CandidatControllers;

import com.workify.workify_ag.DTOs.*;
import com.workify.workify_ag.Services.CondidatService.CandidatServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CandidatController {
    private final CandidatServiceImp candidatServiceImp;

    @Autowired
    public CandidatController(CandidatServiceImp candidatServiceImp) {
        this.candidatServiceImp = candidatServiceImp;
    }
    @PutMapping("/api/Candidat/modifier-salaire")
    public ResponseEntity<String> modifierSalaire(@RequestBody ModifierSalaireCandidat modifierSalaireCandidat) {
        candidatServiceImp.modifierSalaire(modifierSalaireCandidat);
        return ResponseEntity.ok("Salaire mis à jour avec succès");
    }
    @PutMapping("/api/Candidat/modifier-experience")
    public ResponseEntity<String> modifierExperience(@RequestBody ModifierExperienceCandidat modifierExperienceCandidat) {
        candidatServiceImp.modifierExperience(modifierExperienceCandidat);
        return ResponseEntity.ok("Expérience mise à jour avec succès");
    }
    @PutMapping("/api/Candidat/modifier-diplome")
    public ResponseEntity<String> modifierDiplome(@RequestBody ModifierDiplomeCandidat modifierDiplomeCandidat) {
        candidatServiceImp.modifierDiplome(modifierDiplomeCandidat);
        return ResponseEntity.ok("Diplôme mis à jour avec succès");
    }

}
