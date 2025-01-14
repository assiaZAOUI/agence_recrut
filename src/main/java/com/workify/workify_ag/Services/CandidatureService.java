package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Candidature;

import java.util.List;
import java.util.Optional;

public interface CandidatureService {
    /**
     * Ajoute une candidature à une offre.
     *
     * @param candidature La candidature à ajouter.
     * @return La candidature créée.
     */
    Candidature postuler(Candidature candidature);
    Optional<Candidature> getCandidatureById(Long candidatureId);
    /**
     * Récupère toutes les candidatures pour une offre donnée.
     *
     * @param offreId L'ID de l'offre.
     * @return La liste des candidatures pour cette offre.
     */
    List<Candidature> getCandidaturesPourOffre(Long offreId);
}
