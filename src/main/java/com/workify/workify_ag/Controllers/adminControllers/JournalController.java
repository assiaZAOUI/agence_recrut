package com.workify.workify_ag.Controllers.adminControllers;


import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Entities.Journal;
import com.workify.workify_ag.Services.JournalService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class JournalController {

    private JournalService journalService;

    @Autowired
    public JournalController(JournalServiceImp journalServiceImp) {
        this.journalService = journalServiceImp;
    }

    @PutMapping("addJournal")
    public ResponseEntity<String> ajouterJournal(@RequestBody Journal journal) {

        try{
            journalService.ajouterJournal(journal);
            return ResponseEntity.ok("Success");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @GetMapping("AllJournal")
    public List<Journal> getAllJournal() {
            return journalService.getAllJournals();
           // return ResponseEntity.ok("Success");

    }

    @GetMapping("filtragejour/categorie/{categorie}")
    public List<Journal> getJournalByCategorie(@PathVariable String categorie) {
        return journalService.getJournalByCategorie(categorie);

    }

    @GetMapping("filtreagejour/libelle/{libelle}")
    public List<Journal> getJournalByLibelle(@PathVariable String libelle) {
        return journalService.getJournalByLibelle(libelle);
    }

    @GetMapping("tatolJournaux")
    public long getTotalJournal() {

        return journalService.getTotalJournals();
    }
    @DeleteMapping("/suppjour/{journalId}")
    public ResponseEntity<?> supprimerJournal(@PathVariable Long journalId) {
        try {
            journalService.SupprimerJournal(journalId);
            return ResponseEntity.ok("Journal supprimé avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }








}
