package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Services.RecrutementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class RecrutementController {

    @Autowired
    private RecrutementService recrutementService;

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

    /**
     * Crée un nouveau recrutement.
     *
     * @param candidatureId     L'ID de la candidature concernée.
     * @param dateRecrutement   La date du recrutement.
     * @return Le recrutement créé.
     */
    @PostMapping("/recrutement")
    public ResponseEntity<Recrutement> ajouterRecrutement(
            @RequestParam Long candidatureId,
            @RequestParam String dateRecrutement) { // Vous pouvez utiliser un format de date approprié
        // Convertir la dateRecrutement en objet Date (exemple simplifié)
        Date date = new Date(); // Remplacez ceci par une logique de conversion réelle
        Recrutement recrutement = recrutementService.ajouterRecrutement(candidatureId, date);
        return ResponseEntity.ok(recrutement);
    }

    /**
     * Recrute un candidat pour une offre spécifique.
     *
     * @param offreId    L'ID de l'offre.
     * @param candidatId L'ID du candidat.
     * @return Le recrutement créé.
     */
    @PostMapping("/recruter-candidat")
    public ResponseEntity<Recrutement> recruterCandidat(
            @RequestParam Long offreId,
            @RequestParam Long candidatId) {
        Recrutement recrutement = recrutementService.recruterCandidat(offreId, candidatId);
        return ResponseEntity.ok(recrutement);
    }
}
