package com.workify.workify_ag.Services.AffichageService;

import com.workify.workify_ag.DTOs.EntrepCandiDTO;
import com.workify.workify_ag.DTOs.EntrepriseDTO.EntrepriseDTO;
import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Entreprise;
import com.workify.workify_ag.Repositorys.AbonnementRepo.AbonnementRepository;
import com.workify.workify_ag.Repositorys.CandidatRepo.CandidatRepository;
import com.workify.workify_ag.Repositorys.EntrepriseRepo.EntrepriseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AffichageServiceImp implements AffichageService {

    private final CandidatRepository candidatRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final AbonnementRepository abonnementRepository;


    public AffichageServiceImp(CandidatRepository candidatRepository, EntrepriseRepository entrepriseRepository,AbonnementRepository abonnementRepository) {
        this.candidatRepository = candidatRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.abonnementRepository = abonnementRepository;
    }
    public List<EntrepCandiDTO> getAllCandidatsAndEntreprises() {
        List<EntrepCandiDTO> result = new ArrayList<>();

        // Récupérer tous les candidats
        List<Candidat> candidats = candidatRepository.findAll();
        for (Candidat candidat : candidats) {
            EntrepCandiDTO dto = new EntrepCandiDTO();
            dto.setType("Candidat");
            dto.setFullname(candidat.getNom() + " " + candidat.getPrenom()); // Concaténation de nom et prénom
            dto.setEmail(candidat.getEmail());
            result.add(dto);
        }

        // Récupérer toutes les entreprises
        List<Entreprise> entreprises = entrepriseRepository.findAll();
        for (Entreprise entreprise : entreprises) {
            EntrepCandiDTO dto = new EntrepCandiDTO();
            dto.setType("Entreprise");
            dto.setFullname(entreprise.getNomEntreprise());
            dto.setEmail(entreprise.getEmail());
            List<Abonnement> abonnements = abonnementRepository.findByEntreprise(entreprise);
            if (!abonnements.isEmpty()) {
                dto.setDatedebut(abonnements.get(0).getDateDebut()); // Prendre la date de début du premier abonnement
            } else {
                dto.setDatedebut(null); // Aucun abonnement trouvé
            }

            result.add(dto);
        }

        return result;
    }

    public EntrepriseDTO getEntrepriseById(Long id) {
        // Récupérer l'entreprise par ID
        Entreprise entreprise = entrepriseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID : " + id));

        // Mapper l'entité Entreprise vers EntrepriseDTO
        EntrepriseDTO entrepriseDTO = new EntrepriseDTO();
        entrepriseDTO.setNomEntreprise(entreprise.getNomEntreprise());
        entrepriseDTO.setDescriptionEntreprise(entreprise.getDescription());
        entrepriseDTO.setRaisonSocialEntreprise(entreprise.getRaisonSocial());
        entrepriseDTO.setVilleEntreprise(entreprise.getVille());

        return entrepriseDTO;
    }


}
