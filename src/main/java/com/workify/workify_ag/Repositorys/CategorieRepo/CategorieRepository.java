package com.workify.workify_ag.Repositorys.CategorieRepo;

import com.workify.workify_ag.Entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    Optional<Categorie> findByLibelle(String libelle);
    Categorie findByIdCategorie(int idCategorie);
    List<Categorie> findAllCategorie();
}
