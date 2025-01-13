package com.workify.workify_ag.Repositorys.OffreRepo;

import com.workify.workify_ag.Entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>, JpaSpecificationExecutor<Offre> {
    @Query("SELECT DISTINCT o.ville FROM Offre o WHERE o.ville IS NOT NULL")
    List<String> findDistinctVilles();

    @Query("SELECT DISTINCT o.domaine FROM Offre o WHERE o.domaine IS NOT NULL")
    List<String> findDistinctFonctions();

    @Query("SELECT DISTINCT o.niveauEtude FROM Offre o WHERE o.niveauEtude IS NOT NULL")
    List<String> findDistinctNiveauxEtude();
    List<Offre> findByEtat(boolean etat);
}