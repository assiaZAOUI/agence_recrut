package com.workify.workify_ag.Repositorys;

import com.workify.workify_ag.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
     Optional<Candidat> findCandidatByEmail(String email);
     Optional<Candidat> findByRole(String role);
     Optional<Candidat> findById(Long id);



}
