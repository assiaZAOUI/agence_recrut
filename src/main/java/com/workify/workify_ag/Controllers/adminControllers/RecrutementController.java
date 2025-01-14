package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.DTOs.RecrutementRequest;
import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Services.RecrutementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class RecrutementController {

    @Autowired
    private RecrutementService recrutementService;

    /**
     * Endpoint pour ajouter un recrutement en utilisant les IDs de l'offre et du candidat.
     * La date de recrutement est automatiquement définie sur la date et l'heure actuelles.
     *
     * @param request Un objet contenant les IDs de l'offre et du candidat.
     * @return Le recrutement créé.
     */
    @PostMapping("/ajouter")
    public Recrutement ajouterRecrutement(@RequestBody RecrutementRequest request) {
        return recrutementService.ajouterRecrutement(
                request.getOffreId(),
                request.getCandidatId()
        );
    }

    /**
     * Récupère l'historique des recrutements.
     *
     * @return La liste des recrutements avec les informations nécessaires.
     */
    @GetMapping("/historique-recrutement")
    public ResponseEntity<List<Recrutement>> getHistoriqueRecrutement() {
        List<Recrutement> historique = recrutementService.getHistoriqueRecrutement();
        return ResponseEntity.ok(historique);
    }
}