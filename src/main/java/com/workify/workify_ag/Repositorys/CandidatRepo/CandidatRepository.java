package com.workify.workify_ag.Repositorys.CandidatRepo;

import com.workify.workify_ag.Entities.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import java.util.Optional;

@Repository
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
     Optional<Candidat> findCandidatByEmail(String email);
     Optional<Candidat> findByRole(String role);
     @Query("SELECT c FROM Candidat c WHERE c.id = :id ")
     Optional<Candidat> findById( Long id);



}
