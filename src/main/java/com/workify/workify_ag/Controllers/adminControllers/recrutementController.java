package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Services.RecrutementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class recrutementController {
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
}
