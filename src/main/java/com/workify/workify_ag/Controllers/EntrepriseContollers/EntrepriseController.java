package com.workify.workify_ag.Controllers.EntrepriseContollers;


import com.workify.workify_ag.DTOs.EntrepriseDTO.EntrepriseDTO;
import com.workify.workify_ag.Entities.Entreprise;
import com.workify.workify_ag.Services.EntrepriseService.EntrepriseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class EntrepriseController {
    private final EntrepriseServiceImp entrepriseServiceImp;

    @Autowired
    public EntrepriseController(EntrepriseServiceImp entrepriseServiceImp) {
        this.entrepriseServiceImp = entrepriseServiceImp;
    }

    @PutMapping("/modentrep/{idEntreprise}")
    public ResponseEntity<?> modifierEntreprise(
            @PathVariable Long idEntreprise,
            @RequestBody Entreprise entreprise) {
        try {
            entrepriseServiceImp.ModifierEntreprise(idEntreprise, entreprise);
            return ResponseEntity.ok("Entreprise modifiée avec succès");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/affichageEntrep/{idEntreprise}")
    public ResponseEntity<EntrepriseDTO> afficherEntreprise(@PathVariable Long idEntreprise) {
            EntrepriseDTO entrep = entrepriseServiceImp.afficherEntreprise(idEntreprise);
            return ResponseEntity.ok(entrep);




    }

}
