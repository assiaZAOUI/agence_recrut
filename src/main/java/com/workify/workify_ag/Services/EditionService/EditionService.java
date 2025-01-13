package com.workify.workify_ag.Services.EditionService;

import com.workify.workify_ag.Entities.Edition;

import java.util.List;

public interface EditionService {
    // Ajouter une édition
    Edition ajouterEdition(Edition edition);

    // Modifier une édition existante
    Edition modifierEdition(Edition edition);

    // Supprimer une édition existante
    void supprimerEdition(Long idEdition);

    // Obtenir la liste des éditions liées à un journal spécifique
    List<Edition> getEditionsByJournal(Long journalId);
    Edition getEditionById(Long idEdition);
}
