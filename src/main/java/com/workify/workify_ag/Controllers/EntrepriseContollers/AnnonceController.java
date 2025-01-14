package com.workify.workify_ag.Controllers.EntrepriseContollers;

import com.workify.workify_ag.Entities.Candidature;
import com.workify.workify_ag.Services.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AnnonceController {

    @Autowired
    private CandidatureService candidatureService;

    /**
     * Endpoint pour postuler à une offre.
     *
     * @param candidature Les détails de l'annonce (candidature).
     * @return L'annonce créée.
     */
    @PostMapping("/postuler")
    public ResponseEntity<Candidature> postuler(@Validated @RequestBody Candidature candidature) {
        try {
            Candidature nouvelleCandidature = candidatureService.postuler(candidature);
            return ResponseEntity.ok(nouvelleCandidature);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null); // Ou retourner une réponse d'erreur personnalisée
        }
    }

    /**
     * Endpoint pour récupérer toutes les candidatures pour une offre donnée.
     *
     * @param offreId L'ID de l'offre.
     * @return La liste des annonces (candidatures) pour cette offre.
     */
    @GetMapping("/candidatures")
    public ResponseEntity<List<Candidature>> getCandidaturesPourOffre(
            @RequestParam Long offreId) {
        List<Candidature> candidatures = candidatureService.getCandidaturesPourOffre(offreId);
        return ResponseEntity.ok(candidatures);
    }
}