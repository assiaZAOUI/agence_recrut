package com.workify.workify_ag.Repositorys.AbonnementRepo;

import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Entities.Entreprise;
import com.workify.workify_ag.Entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

    Optional<Abonnement> findByEntrepriseAndJournal(Entreprise entreprise, Journal journal);
    List<Abonnement> findByEntreprise(Entreprise entreprise);

}
