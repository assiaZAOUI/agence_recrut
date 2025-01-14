package com.workify.workify_ag.Repositorys.JournalRepo;

import com.workify.workify_ag.Entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    List<Journal> findAll();
    Optional<Journal> findByNom(String name);
    @Query("SELECT j FROM Journal j JOIN j.categorie c WHERE c.libelle = :nom")
    List<Journal> findByCategorie(@Param("nom")String nom);
    List<Journal> findByLibelle(String libelle);
    @Query("SELECT COUNT(j) FROM Journal j")
    long countAllJournals();
Optional<Journal> findByCode(Long code);
    //List<Journal> findBy
}
