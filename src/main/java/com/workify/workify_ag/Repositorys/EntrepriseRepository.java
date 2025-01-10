package com.workify.workify_ag.Repositorys;

import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    Optional<Entreprise> findByEmail(String email);
    Optional<Entreprise> findByRole(String role);




}
