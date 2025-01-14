package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Annonce;
import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Repositorys.AnnonceRepo.AnnonceRepository;
import com.workify.workify_ag.Repositorys.CandidatRepo.CandidatRepository;
import com.workify.workify_ag.Repositorys.OffreRepo.OffreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService{

    @Autowired
    private AnnonceRepository annonceRepository;

    @Autowired
    private CandidatRepository candidatRepository;


    @Autowired
    private OffreRepository offreRepository;

    /**
     * Ajoute une annonce (candidature) en associant un candidat, une entreprise et une offre.
     *
     * @param candidatId    L'ID du candidat.
     * @param offreId       L'ID de l'offre.
     * @return L'annonce créée.
     * @throws RuntimeException Si le candidat, l'entreprise ou l'offre n'est pas trouvé.
     */
    @Override
    public Annonce postuler(Long candidatId, Long offreId) {
        // Récupérer le candidat, l'entreprise et l'offre existants
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé"));
        Offre offre = offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée"));

        // Créer une nouvelle annonce
        Annonce annonce = new Annonce();
        annonce.setCandidat(candidat);
        annonce.setOffre(offre);

        // Enregistrer l'annonce
        return annonceRepository.save(annonce);
    }

    /**
     * Récupère toutes les annonces pour une offre donnée.
     *
     * @param offreId L'ID de l'offre.
     * @return La liste des annonces pour cette offre.
     */
    public List<Annonce> getCandidaturesPourOffre(Long offreId) {
        return annonceRepository.findByOffreId(offreId);
    }
}
