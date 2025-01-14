package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Candidature;
import com.workify.workify_ag.Repositorys.AnnonceRepo.CandidatureRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatureServiceImpl implements CandidatureService {

    private static final Logger logger = LoggerFactory.getLogger(CandidatureServiceImpl.class);

    @Autowired
    private CandidatureRepository candidatureRepository;

    /**
     * Ajoute une candidature à une offre.
     *
     * @param candidature La candidature à ajouter.
     * @return La candidature créée.
     * @throws IllegalArgumentException Si la candidature est nulle.
     */
    @Override
    public Candidature postuler(Candidature candidature) {
        // Validation de l'entrée
        if (candidature == null) {
            logger.error("Tentative d'ajout d'une candidature nulle.");
            throw new IllegalArgumentException("La candidature ne peut pas être nulle.");
        }

        // Journalisation
        logger.info("Ajout d'une nouvelle candidature pour l'offre : {}", candidature.getOffre().getIdOffre());

        // Enregistrement de la candidature
        return candidatureRepository.save(candidature);
    }

    @Override
    public Optional<Candidature> getCandidatureById(Long candidatureId) {
        return candidatureRepository.findById(candidatureId);
    }

    @Override
    public List<Candidature> getCandidaturesPourOffre(Long offreId) {
        return candidatureRepository.findByOffre_Id(offreId); // Exemple de méthode
    }
}
