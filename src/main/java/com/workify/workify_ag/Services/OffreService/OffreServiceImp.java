package com.workify.workify_ag.Services.OffreService;


import com.workify.workify_ag.DTOs.OffresDTO.FiltrerOffre;
import com.workify.workify_ag.DTOs.OffresDTO.OffreDTO;
import com.workify.workify_ag.Entities.Edition;
import com.workify.workify_ag.Entities.Journal;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Repositorys.EditionRepo.EditionRepository;
import com.workify.workify_ag.Repositorys.JournalRepo.JournalRepository;
import com.workify.workify_ag.Repositorys.OffreRepo.OffreRepository;
import com.workify.workify_ag.Specification.OffreSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffreServiceImp implements OffreService{

    private final OffreRepository offreRepository;

    public OffreServiceImp(OffreRepository offreRepository) {
        this.offreRepository = offreRepository;
    }

    public List<Offre> filtrerOffres(FiltrerOffre filtrerOffre) {
        Specification<Offre> spec = Specification.where(OffreSpecification.hasTitre(filtrerOffre.getTitre()))
                .and(OffreSpecification.hasVille(filtrerOffre.getVille()))
                .and(OffreSpecification.hasDomaine(filtrerOffre.getDomaine()))
                .and(OffreSpecification.hasNiveauEtude(filtrerOffre.getNiveauEtude()));

        return offreRepository.findAll(spec);
    }

    @Override
    public Offre ajouterOffre(OffreDTO offreDTO) {
        // Créer une nouvelle instance d'Offre à partir de l'OffreDTO
        Offre offre = new Offre();
        offre.setTitre(offreDTO.getTitre());
        offre.setNbrAnneeExpDemander(offreDTO.getNbrAnneeExpDemander());
        offre.setCompetenceSouhaite(offreDTO.getCompetenceSouhaite());
        offre.setEtat(false);  // Mise à jour de l'état à true après la création
        offre.setNiveauEtude(offreDTO.getNiveauEtude());
        offre.setSalaire(offreDTO.getSalaire());

        // Récupérer le journal à partir de son code
        //Journal journal = JournalRepository.findById(offreDTO.getJournal().getCode())
         //       .orElseThrow(() -> new RuntimeException("Journal not found"));

        // Récupérer l'édition à partir de son id
       // Edition edition = EditionRepository.findById(offreDTO.getEdition().getIdEdition())
        //        .orElseThrow(() -> new RuntimeException("Edition not found"));

        // Associer le journal et l'édition à l'offre
        //offre.setJournal(journal);
        //offre.getEditions().add(edition);  // Associer l'édition à l'offre (s'il y en a plusieurs)

        // Sauvegarder l'offre dans la base de données
        return offreRepository.save(offre);
    }
}
