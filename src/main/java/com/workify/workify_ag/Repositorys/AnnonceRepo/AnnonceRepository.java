package com.workify.workify_ag.Repositorys.AnnonceRepo;

import com.workify.workify_ag.Entities.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}
