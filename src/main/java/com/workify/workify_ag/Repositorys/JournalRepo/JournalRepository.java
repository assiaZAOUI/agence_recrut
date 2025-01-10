package com.workify.workify_ag.Repositorys.JournalRepo;

import com.workify.workify_ag.Entities.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalRepository extends JpaRepository<Journal, Long> {
}
