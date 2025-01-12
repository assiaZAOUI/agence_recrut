package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.Entities.Categorie;
import com.workify.workify_ag.Services.CategorieService.CategorieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class CategorieController {

    private final CategorieService categorieService;

    // Get all categories
    @GetMapping("/allCategorie")
    public List<Categorie> getAllCategories() {
        return categorieService.getAllCategories();
    }

    // Get category by ID
    @GetMapping("/categorie/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Long id) {
        Optional<Categorie> categorie = categorieService.getCategorieById(id);
        return categorie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get category by libelle
    @GetMapping("/categorie/libelle/{libelle}")
    public ResponseEntity<Categorie> getCategorieByLibelle(@PathVariable String libelle) {
        Optional<Categorie> categorie = categorieService.getCategorieByLibelle(libelle);
        return categorie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Save a new category
    @PostMapping("/categorie/add")
    public Categorie saveCategorie(@RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }

    // Delete a category by ID
    @DeleteMapping("/categorie/delete/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
        return ResponseEntity.noContent().build();
    }
}
