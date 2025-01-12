package com.workify.workify_ag.Controllers.OffreControllers;

import com.workify.workify_ag.DTOs.OffresDTO.*;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Services.OffreService.OffreServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class OffreControllers {
    private final OffreServiceImp offreServiceImp;

    public OffreControllers(OffreServiceImp offreServiceImp) {
        this.offreServiceImp = offreServiceImp;
    }

    @GetMapping("/Candidat/filtrer")
    public List<Offre> filtrerOffres(@ModelAttribute FiltrerOffre filtrerOffre) {
        return offreServiceImp.filtrerOffres(filtrerOffre);
    }

    @PostMapping("/ajouterOffre")
    public ResponseEntity<Offre> ajouterOffre(@RequestBody OffreDTO offre) {
        Offre nvOffre = offreServiceImp.ajouterOffre(offre);
        return ResponseEntity.status(HttpStatus.CREATED).body(nvOffre);
    }
}
