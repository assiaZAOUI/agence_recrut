package com.workify.workify_ag.Services.JournalService;

import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Entities.Journal;

import java.util.List;
import java.util.Optional;

public interface JournalService {

    List<Journal> getAllJournals();

    public List<Journal> getJournalByCategorie(String categorie);

    public List<Journal> getJournalByLibelle(String libelle);

    public long getTotalJournals();

    public Journal ajouterJournal(Journal journal);

    public void SupprimerJournal(Long journalId);
}
