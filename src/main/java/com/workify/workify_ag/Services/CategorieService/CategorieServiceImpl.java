package com.workify.workify_ag.Services.CategorieService;

import com.workify.workify_ag.Entities.Categorie;
import com.workify.workify_ag.Repositorys.CategorieRepo.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    private CategorieRepository categorieRepository;


    @Override
    public Optional<Categorie> getCategorieById(Long idCategorie) {
        return categorieRepository.findByIdCategorie(idCategorie);
    }

    @Override
    public Optional<Categorie> getCategorieByLibelle(String libelle) {
        return categorieRepository.findByLibelle(libelle);
    }

    @Override
    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    @Override
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Override
    public void deleteCategorie(Long idCategorie) {
        categorieRepository.deleteById(idCategorie);
    }
}
