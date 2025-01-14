package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Annonce;
import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Repositorys.CandidatRepo.CandidatRepository;
import com.workify.workify_ag.Repositorys.OffreRepo.OffreRepository;
import com.workify.workify_ag.Repositorys.RecrutementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecrutementServiceImpl implements RecrutementService {

    @Autowired
    private RecrutementRepository recrutementRepository;

    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private OffreRepository offreRepository;

    @Autowired
    private CandidatRepository candidatRepository;

    /**
     * Ajoute un recrutement à l'historique en utilisant les IDs de l'offre et du candidat.
     * La date de recrutement est automatiquement définie sur la date et l'heure actuelles.
     *
     * @param offreId    L'ID de l'offre concernée.
     * @param candidatId L'ID du candidat recruté.
     * @return Le recrutement créé.
     * @throws RuntimeException Si l'offre ou le candidat n'est pas trouvé.
     */
    @Override
    public Recrutement ajouterRecrutement(Long offreId, Long candidatId) {
        // Récupérer l'offre et le candidat existants
        Offre offre = offreRepository.findById(offreId)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée"));
        Candidat candidat = candidatRepository.findById(candidatId)
                .orElseThrow(() -> new RuntimeException("Candidat non trouvé"));

        // Créer et enregistrer le recrutement avec la date actuelle
        Recrutement recrutement = new Recrutement(offre, candidat, new Date()); // Date système
        return recrutementRepository.save(recrutement);
    }

    /**
     * Récupère l'historique des recrutements.
     *
     * @return La liste des recrutements avec les informations nécessaires.
     */
    @Override
    public List<Recrutement> getHistoriqueRecrutement() {
        return recrutementRepository.findAll();
    }

    /**
     * Recrute un candidat pour une offre spécifique.
     *
     * @param offreId    L'ID de l'offre.
     * @param candidatId L'ID du candidat.
     * @return Le recrutement créé.
     * @throws RuntimeException Si la candidature n'est pas trouvée.
     */
    @Override
    public Recrutement recruterCandidat(Long offreId, Long candidatId) {
        // Récupérer l'annonce correspondante (candidature)
        Annonce annonce = annonceService.getCandidaturesPourOffre(offreId)
                .stream()
                .filter(a -> a.getCandidat().getId().equals(candidatId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Candidature non trouvée"));

        // Créer un recrutement
        Recrutement recrutement = new Recrutement(annonce.getOffre(), annonce.getCandidat(), new Date());

        // Enregistrer le recrutement
        return recrutementRepository.save(recrutement);
    }
}