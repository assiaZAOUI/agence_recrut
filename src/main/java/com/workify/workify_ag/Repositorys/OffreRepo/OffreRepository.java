package com.workify.workify_ag.Repositorys.OffreRepo;

import com.workify.workify_ag.Entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OffreRepository extends JpaRepository<Offre, Long>, JpaSpecificationExecutor<Offre> {


}