package com.workify.workify_ag.Services.OffreService;


import com.workify.workify_ag.DTOs.OffresDTO.FiltrerOffre;
import com.workify.workify_ag.DTOs.OffresDTO.OffreDTO;
import com.workify.workify_ag.Entities.Offre;
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
        Offre offre = new Offre();
        offre.setTitre(offreDTO.getTitre());
        offre.setVille(offreDTO.getVille());
        offre.setDomaine(offreDTO.getDomaine());
        offre.setNiveauEtude(offreDTO.getNiveauEtude());
        offre.setCompetenceSouhaite(offreDTO.getCompetenceSouhaite());
        offre.setEtat(offreDTO.getEtat());
        return offreRepository.save(offre);
    }
}
