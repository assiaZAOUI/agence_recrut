package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.DTOs.EntrepCandiDTO;
import com.workify.workify_ag.DTOs.EntrepriseDTO.EntrepriseDTO;
import com.workify.workify_ag.Services.AffichageService.AffichageServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AffichageController {
    private final AffichageServiceImp affichageServiceImp;

    @Autowired
    public AffichageController(AffichageServiceImp affichageServiceImp) {
        this.affichageServiceImp = affichageServiceImp;
    }

    @GetMapping("/candidats-et-entreprises")
    public ResponseEntity<List<EntrepCandiDTO>> getAllCandidatsAndEntreprises() {
        List<EntrepCandiDTO> result = affichageServiceImp.getAllCandidatsAndEntreprises();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/entrepactuelle/{id}")
    public ResponseEntity<EntrepriseDTO> getEntrepriseById(@PathVariable Long id) {
        EntrepriseDTO entrepriseDTO = affichageServiceImp.getEntrepriseById(id);
        return ResponseEntity.ok(entrepriseDTO);
    }
}
