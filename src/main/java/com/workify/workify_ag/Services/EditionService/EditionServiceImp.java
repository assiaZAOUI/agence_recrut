package com.workify.workify_ag.Services.EditionService;

import com.workify.workify_ag.Entities.Edition;
import com.workify.workify_ag.Entities.Journal;
import com.workify.workify_ag.Repositorys.EditionRepo.EditionRepository;
import com.workify.workify_ag.Repositorys.JournalRepo.JournalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EditionServiceImp implements EditionService {

    private final EditionRepository editionRepository;
    private final JournalRepository journalRepository;

    public EditionServiceImp(EditionRepository editionRepository, JournalRepository journalRepository) {
        this.editionRepository = editionRepository;
        this.journalRepository = journalRepository;
    }

    @Override
    public Edition ajouterEdition(Edition edition) {
        if (edition.getJournal() == null || edition.getJournal().getCode() == null) {
            throw new IllegalArgumentException("Un journal valide doit être associé à l'édition.");
        }

        // Récupérer le journal depuis la base de données
        Journal journal = journalRepository.findByCode(edition.getJournal().getCode())
                .orElseThrow(() -> new RuntimeException("Journal non trouvé avec l'ID : " + edition.getJournal().getCode()));

        // Associer le journal à l'édition
        edition.setJournal(journal);
        return editionRepository.save(edition);
    }

    @Override
    public Edition modifierEdition(Edition edition) {
        Optional<Edition> existingEdition = editionRepository.findById(edition.getIdEdition());
        if (existingEdition.isPresent()) {
            return editionRepository.save(edition);
        } else {
            throw new RuntimeException("Édition introuvable pour la modification");
        }
    }

    public void supprimerEdition(Long idEdition) {
        // Vérification si l'édition existe avant de supprimer
        if (!editionRepository.existsById(idEdition)) {
            throw new RuntimeException("L'édition avec l'ID " + idEdition + " n'existe pas.");
        }
        editionRepository.deleteById(idEdition);
    }

    @Override
    public List<Edition> getEditionsByJournal(Long journalId) {
        return editionRepository.findByJournalCode(journalId);
    }
    @Override
    public Edition getEditionById(Long idEdition) {
        return editionRepository.findById(idEdition)
                .orElseThrow(() -> new RuntimeException("L'édition avec l'ID " + idEdition + " n'existe pas."));
    }
}
