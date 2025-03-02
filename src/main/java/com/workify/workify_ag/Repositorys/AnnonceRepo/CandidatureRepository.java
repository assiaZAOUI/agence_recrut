package com.workify.workify_ag.Repositorys.AnnonceRepo;

import com.workify.workify_ag.Entities.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
    /**
     * Récupère toutes les candidatures pour une offre donnée.
     *
     * @param offreId L'ID de l'offre.
     * @return La liste des candidatures pour cette offre.
     */
    List<Candidature> findByOffreId(Long offreId);
}
