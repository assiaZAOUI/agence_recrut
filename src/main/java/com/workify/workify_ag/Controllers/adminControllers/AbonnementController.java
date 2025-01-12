package com.workify.workify_ag.Controllers.adminControllers;


import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Services.AbonnementService.AbonnementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AbonnementController {
    private final AbonnementService abonnementService;

    public AbonnementController(AbonnementService abonnementService) {
        this.abonnementService = abonnementService;
    }

    @PutMapping("/subscribe")
    public ResponseEntity<String> subscribeToJournal(
            @RequestParam Long entrepriseId,
            @RequestParam Long journalId,
            @RequestBody Abonnement abonnement) {
        try {
            Abonnement savedAbonnement = abonnementService.subscribeToJournal(entrepriseId, journalId, abonnement);
            return ResponseEntity.ok("Succes");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/unsubscribe")
    public ResponseEntity<?> unsubscribeFromJournal(
            @RequestParam Long entrepriseId,
            @RequestParam Long journalId) {
        try {
            abonnementService.unsubscribeFromJournal(entrepriseId, journalId);
            return ResponseEntity.ok("Désabonnement réussi");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
