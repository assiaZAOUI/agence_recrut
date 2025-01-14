package com.workify.workify_ag.Repositorys;

import com.workify.workify_ag.Entities.Recrutement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecrutementRepository extends JpaRepository<Recrutement,Long> {

    List<Recrutement> findAll();
}
