package com.workify.workify_ag.Controllers.EntrepriseContollers;

import com.workify.workify_ag.Entities.Annonce;
import com.workify.workify_ag.Services.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    /**
     * Endpoint pour postuler à une offre.
     *
     * @param annonce Les détails de l'annonce (candidature).
     * @return L'annonce créée.
     */
    @PostMapping("/postuler")
    public ResponseEntity<Annonce> postuler(@Validated @RequestBody Annonce annonce) {
        try {
            Annonce nouvelleAnnonce = annonceService.postuler(annonce);
            return ResponseEntity.ok(nouvelleAnnonce);
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
    public ResponseEntity<List<Annonce>> getCandidaturesPourOffre(
            @RequestParam Long offreId) {
        List<Annonce> candidatures = annonceService.getCandidaturesPourOffre(offreId);
        return ResponseEntity.ok(candidatures);
    }
}