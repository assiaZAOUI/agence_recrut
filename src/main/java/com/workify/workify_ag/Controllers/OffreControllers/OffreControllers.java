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
    public ResponseEntity<Offre> ajouterOffre(@RequestBody OffreDTO offreDTO) {
        Offre nvOffre = offreServiceImp.ajouterOffre(offreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nvOffre);
    }
    @GetMapping("/ListVilles")
    public ResponseEntity<List<String>> getListVille() {
        List<String> villes = offreServiceImp.getListVille();
        return ResponseEntity.ok(villes);
    }

    @GetMapping("/ListFonctions")
    public ResponseEntity<List<String>> getListFonction() {
        List<String> fonctions = offreServiceImp.getListFonction();
        return ResponseEntity.ok(fonctions);
    }

    @GetMapping("/ListNiveauxEtude")
    public ResponseEntity<List<String>> getListNiveauEtude() {
        List<String> niveauxEtude = offreServiceImp.getListNiveauEtude();
        return ResponseEntity.ok(niveauxEtude);
    }
    @GetMapping("/ListeOffreActives")
    public ResponseEntity<List<Offre>> getOffresActives() {
        List<Offre> offresActives = offreServiceImp.getOffresActives();
        return ResponseEntity.ok(offresActives);
    }

    @GetMapping("/ListeOffreDesactives")
    public ResponseEntity<List<Offre>> getOffresDesactivees() {
        List<Offre> offresDesactivees = offreServiceImp.getOffresDesactivees();
        return ResponseEntity.ok(offresDesactivees);
    }
}
