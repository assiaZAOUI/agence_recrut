package com.workify.workify_ag.Controllers.EntrepriseContollers;


import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Services.RecrutementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/auth")
public class EntrepriseController {

    @Autowired
    private RecrutementService recrutementService;

    /**
     * Recrute un candidat pour une offre.
     *
     * @param offreId    L'ID de l'offre.
     * @param candidatId L'ID du candidat.
     * @return Le recrutement créé.
     */
    @PostMapping("/{offreId}/recruter/{candidatId}")
    public ResponseEntity<Recrutement> recruterCandidat(@PathVariable Long offreId, @PathVariable Long candidatId) {
        Recrutement recrutement = recrutementService.recruterCandidat(offreId, candidatId);
        return ResponseEntity.ok(recrutement);
    }
}
