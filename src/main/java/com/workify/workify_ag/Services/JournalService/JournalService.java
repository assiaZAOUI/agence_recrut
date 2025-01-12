package com.workify.workify_ag.Services.JournalService;
import com.workify.workify_ag.Entities.Journal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JournalService {

    List<Journal> getAllJournals();

    List<Journal> getJournalByCategorie(String categorie);

    List<Journal> getJournalByLibelle(String libelle);

    long getTotalJournals();

    Journal ajouterJournal(Journal journal);

    void SupprimerJournal(Long journalId);
}
