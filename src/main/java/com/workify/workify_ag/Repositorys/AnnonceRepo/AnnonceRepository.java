package com.workify.workify_ag.Repositorys.AnnonceRepo;

import com.workify.workify_ag.Entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    @Query("SELECT a FROM Annonce a WHERE a.offre.idOffre = :offreId")
    List<Annonce> findByOffreId(@Param("offreId") Long offreId);// Récupère les annonces pour une offre donnée
}
