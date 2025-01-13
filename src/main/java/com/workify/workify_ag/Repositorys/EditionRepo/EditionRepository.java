package com.workify.workify_ag.Repositorys.EditionRepo;

import com.workify.workify_ag.Entities.Edition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Long> {
    // Trouver les éditions par ID du journal
    List<Edition> findByJournalCode(Long journalId); // Méthode personnalisée pour récupérer les éditions d'un journal
}
