package com.workify.workify_ag.Controllers.adminControllers;


import com.workify.workify_ag.Entities.Journal;
import com.workify.workify_ag.Services.JournalService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class JournalController {

    private JournalServiceImp journalServiceImp;

    @Autowired
    public JournalController(JournalServiceImp journalServiceImp) {
        this.journalServiceImp = journalServiceImp;
    }

    @PutMapping("addJournal")
    public ResponseEntity<String> ajouterJournal(@RequestBody Journal journal) {

        try{
            journalServiceImp.ajouterJournal(journal);
            return ResponseEntity.ok("Success");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }

    }

    @GetMapping("AllJournal")
    public List<Journal> getAllJournal() {
            return journalServiceImp.getAllJournals();
           // return ResponseEntity.ok("Success");

    }

    @GetMapping("filtragejour/categorie")
    public Optional<Journal> getJournalByCategorie(@PathVariable String categorie) {
        return journalServiceImp.getJournalByCategorie(categorie);

    }

    @GetMapping("filtreagejour/libelle")
    public List<Journal> getJournalByLibelle(@PathVariable String libelle) {
        return journalServiceImp.getJournalByLibelle(libelle);
    }

    @GetMapping("tatolJournaux")
    public long getTotalJournal() {
        return journalServiceImp.getTotalJournals();
    }





}
