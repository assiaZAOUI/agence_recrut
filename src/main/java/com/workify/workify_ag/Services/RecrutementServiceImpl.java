package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Candidature;
import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Repositorys.AnnonceRepo.CandidatureRepository;
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
    private CandidatureService candidatureService; // Injection de CandidatureService

    @Override
    public Recrutement ajouterRecrutement(Long candidatureId, Date dateRecrutement) {
        // Récupérer la candidature par son ID
        Candidature candidature = candidatureService.getCandidatureById(candidatureId)
                .orElseThrow(() -> new RuntimeException("Candidature non trouvée"));

        // Créer un recrutement
        Recrutement recrutement = new Recrutement(candidature, dateRecrutement);
        return recrutementRepository.save(recrutement);
    }

    @Override
    public List<Recrutement> getHistoriqueRecrutement() {
        return recrutementRepository.findAll();
    }

    @Override
    public Recrutement recruterCandidat(Long offreId, Long candidatId) {
        // Utilisez l'instance candidatureService pour appeler la méthode
        Candidature candidature = candidatureService.getCandidaturesPourOffre(offreId)
                .stream()
                .filter(a -> a.getCandidat().getId().equals(candidatId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Candidature non trouvée"));

        // Créer un recrutement à partir de la candidature
        Recrutement recrutement = new Recrutement(candidature, new Date());
        return recrutementRepository.save(recrutement);
    }
}