package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.Entities.Edition;
import com.workify.workify_ag.Services.EditionService.EditionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class EditionController {

    private final EditionService editionService;

    public EditionController(EditionService editionService) {
        this.editionService = editionService;
    }

    // Ajouter une nouvelle édition
    @PostMapping("/addEdition")
    public ResponseEntity<Edition> ajouterEdition(@RequestBody Edition edition) {
        Edition nouvelleEdition = editionService.ajouterEdition(edition);
        return ResponseEntity.status(HttpStatus.CREATED).body(nouvelleEdition);
    }

    // Modifier une édition existante
    @PutMapping("/updateEdition/{id}")
    public ResponseEntity<Edition> modifierEdition(@PathVariable Long id, @RequestBody Edition edition) {
        try {
            edition.setIdEdition(id); // S'assurer que l'ID est bien défini
            Edition editionModifiee = editionService.modifierEdition(edition);
            return ResponseEntity.ok(editionModifiee);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    // Supprimer une édition
    @DeleteMapping("/deleteEdition/{id}")
    public ResponseEntity<Void> supprimerEdition(@PathVariable Long id) {
        try {
            editionService.supprimerEdition(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Obtenir la liste des éditions d'un journal spécifique
    @GetMapping("/edition/journal/{journalId}")
    public ResponseEntity<List<Edition>> getEditionsByJournal(@PathVariable Long journalId) {
        List<Edition> editions = editionService.getEditionsByJournal(journalId);
        if (editions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(editions);
        }
        return ResponseEntity.ok(editions);
    }
}