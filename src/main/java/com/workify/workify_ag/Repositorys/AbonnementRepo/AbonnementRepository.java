package com.workify.workify_ag.Repositorys.AbonnementRepo;

import com.workify.workify_ag.Entities.Abonnement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
    List<Abonnement> findByEtat(boolean etat);
    List<Abonnement> findByEntreprise_Id(Long entrepriseId);
}
