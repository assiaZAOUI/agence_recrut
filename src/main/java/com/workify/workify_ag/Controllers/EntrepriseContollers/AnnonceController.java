package com.workify.workify_ag.Controllers.EntrepriseContollers;

import com.workify.workify_ag.DTOs.PostulerRequest;
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
     * Endpoint pour ajouter une annonce (candidature).
     *
     * @param postulerRequest Le DTO contenant les IDs du candidat, de l'entreprise et de l'offre.
     * @return L'annonce créée.
     */
    @PostMapping("/postuler")
    public ResponseEntity<Annonce> postuler(@RequestBody PostulerRequest postulerRequest) {
        Annonce nouvelleAnnonce = annonceService.postuler(
                postulerRequest.getCandidatId(),
                postulerRequest.getOffreId()
        );
        return ResponseEntity.ok(nouvelleAnnonce);
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