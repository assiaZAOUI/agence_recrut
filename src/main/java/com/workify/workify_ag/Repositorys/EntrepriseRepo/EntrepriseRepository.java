package com.workify.workify_ag.Repositorys.EntrepriseRepo;

import com.workify.workify_ag.Entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {


    List<Entreprise> findAll();
    Optional<Entreprise> findById(Long id);
    Optional<Entreprise> findByEmail(String email);
    List<Entreprise> findByRole(String role);
    // Nombre total d'entreprises
    @Query("SELECT COUNT(e) FROM Entreprise e")
    long countTotalEntreprises();

    // Nombre d'entreprises ayant postulé à des offres
    @Query("SELECT COUNT(DISTINCT e) FROM Entreprise e JOIN e.abonnements a WHERE a.journal IS NOT NULL")
    long countEntreprisesWithOffers();




}
