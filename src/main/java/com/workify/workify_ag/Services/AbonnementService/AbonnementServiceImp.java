package com.workify.workify_ag.Services.AbonnementService;

import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Entities.Entreprise;
import com.workify.workify_ag.Entities.Journal;
import com.workify.workify_ag.Repositorys.AbonnementRepo.AbonnementRepository;
import com.workify.workify_ag.Repositorys.EntrepriseRepo.EntrepriseRepository;
import com.workify.workify_ag.Repositorys.JournalRepo.JournalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbonnementServiceImp implements AbonnementService {


        private final EntrepriseRepository entrepriseRepository;
        private final JournalRepository journalRepository;
        private final AbonnementRepository abonnementRepository;

        public AbonnementServiceImp(EntrepriseRepository entrepriseRepository,
                                 JournalRepository journalRepository,
                                 AbonnementRepository abonnementRepository) {
            this.entrepriseRepository = entrepriseRepository;
            this.journalRepository = journalRepository;
            this.abonnementRepository = abonnementRepository;
        }

        @Transactional
        public Abonnement subscribeToJournal(Long entrepriseId, Long journalId, Abonnement abonnement) {
            // Vérifier si l'entreprise existe
            Entreprise entreprise = entrepriseRepository.findById(entrepriseId)
                    .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID : " + entrepriseId));

            // Vérifier si le journal existe
            Journal journal = journalRepository.findById(journalId)
                    .orElseThrow(() -> new RuntimeException("Journal non trouvé avec l'ID : " + journalId));

            // Associer l'entreprise et le journal à l'abonnement
            abonnement.setEntreprise(entreprise);
            abonnement.setJournal(journal);
            abonnement.setEtat(true);

            // Enregistrer l'abonnement
            return abonnementRepository.save(abonnement);
        }

        @Transactional
        public void unsubscribeFromJournal(Long entrepriseId, Long journalId) {
            // Vérifier si l'entreprise existe
            Entreprise entreprise = entrepriseRepository.findById(entrepriseId)
                    .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID : " + entrepriseId));

            // Vérifier si le journal existe
            Journal journal = journalRepository.findById(journalId)
                    .orElseThrow(() -> new RuntimeException("Journal non trouvé avec l'ID : " + journalId));

            // Rechercher l'abonnement correspondant
            Abonnement abonnement = abonnementRepository.findByEntrepriseAndJournal(entreprise, journal)
                    .orElseThrow(() -> new RuntimeException("Abonnement non trouvé pour l'entreprise et le journal spécifiés"));

            // Supprimer l'abonnement
            abonnementRepository.delete(abonnement);
        }

}
