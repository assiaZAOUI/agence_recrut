package com.workify.workify_ag.Services.EditionService;

import com.workify.workify_ag.Entities.Edition;
import com.workify.workify_ag.Repositorys.EditionRepo.EditionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EditionServiceImp implements EditionService {

    private final EditionRepository editionRepository;

    public EditionServiceImp(EditionRepository editionRepository) {
        this.editionRepository = editionRepository;
    }

    @Override
    public Edition ajouterEdition(Edition edition) {
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

    @Override
    public Edition supprimerEdition(Edition edition) {
        Optional<Edition> existingEdition = editionRepository.findById(edition.getIdEdition());
        if (existingEdition.isPresent()) {
            editionRepository.delete(existingEdition.get());
            return existingEdition.get();
        } else {
            throw new RuntimeException("Édition introuvable pour la suppression");
        }
    }

    @Override
    public List<Edition> getEditionsByJournal(Long journalId) {
        return editionRepository.findByJournalCode(journalId);
    }
}
