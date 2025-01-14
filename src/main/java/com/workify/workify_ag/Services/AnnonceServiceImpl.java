package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Annonce;
import com.workify.workify_ag.Repositorys.AnnonceRepo.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnonceServiceImpl implements AnnonceService{

    @Autowired
    private AnnonceRepository annonceRepository;

    /**
     * Ajoute une annonce (candidature) à une offre.
     *
     * @param annonce L'annonce à ajouter.
     * @return L'annonce créée.
     */
    public Annonce postuler(Annonce annonce) {
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
