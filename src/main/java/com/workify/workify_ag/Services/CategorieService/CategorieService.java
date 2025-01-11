package com.workify.workify_ag.Services.CategorieService;

import com.workify.workify_ag.Entities.Categorie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface CategorieService {

    Optional<Categorie> getCategorieById(Long idCategorie);
    Optional<Categorie> getCategorieByLibelle(String libelle);
    List<Categorie> getAllCategories();
    Categorie saveCategorie(Categorie categorie);
    void deleteCategorie(Long idCategorie);
}
