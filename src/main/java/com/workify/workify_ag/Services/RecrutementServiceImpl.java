package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Annonce;
import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.Offre;
import com.workify.workify_ag.Entities.Recrutement;
import com.workify.workify_ag.Repositorys.RecrutementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecrutementServiceImpl implements RecrutementService{
    @Autowired
    private RecrutementRepository recrutementRepository;

    @Autowired
    private AnnonceService annonceService; // Assurez-vous que cette ligne est présente

    /**
     * Ajoute un recrutement à l'historique.
     *
     * @param offre           L'offre concernée.
     * @param candidat        Le candidat recruté.
     * @param dateRecrutement La date du recrutement.
     * @return Le recrutement créé.
     */
    public Recrutement ajouterRecrutement(Offre offre, Candidat candidat, Date dateRecrutement) {
        Recrutement recrutement = new Recrutement(offre, candidat, dateRecrutement);
        return recrutementRepository.save(recrutement);
    }

    /**
     * Récupère l'historique des recrutements.
     *
     * @return La liste des recrutements avec les informations nécessaires.
     */
    public List<Recrutement> getHistoriqueRecrutement() {
        return recrutementRepository.findAll();
    }
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
