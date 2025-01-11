package com.workify.workify_ag.Services.JournalService;

import com.workify.workify_ag.Entities.Abonnement;
import com.workify.workify_ag.Entities.Entreprise;
import com.workify.workify_ag.Entities.Journal;
import com.workify.workify_ag.Entities.User;
import com.workify.workify_ag.Repositorys.AbonnementRepo.AbonnementRepository;
import com.workify.workify_ag.Repositorys.EntrepriseRepo.EntrepriseRepository;
import com.workify.workify_ag.Repositorys.JournalRepo.JournalRepository;
import com.workify.workify_ag.Repositorys.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalServiceImp implements JournalService {

    private final JournalRepository  journalRepository;
    private final AbonnementRepository abonnementRepository;
    private final EntrepriseRepository entrepriseRepository;


    @Autowired
    public JournalServiceImp(JournalRepository journalRepository, AbonnementRepository abonnementRepository,EntrepriseRepository entrepriseRepository) {
        this.journalRepository=journalRepository;
        this.abonnementRepository=abonnementRepository;
        this.entrepriseRepository=entrepriseRepository;

    }
    public List<Journal> getAllJournals() {

        return journalRepository.findAll();
    }
    public Optional<Journal> getJournalByCategorie(String categorie) {

        return journalRepository.findByCategorie(categorie);
    }
    public List<Journal> getJournalByLibelle(String libelle) {

        return journalRepository.findByLibelle(libelle);

    }

    public long getTotalJournals() {

        return journalRepository.countAllJournals();

    }
    public Journal ajouterJournal(Journal journal) {

        return journalRepository.save(journal);

    }
    public Abonnement subscribeToJournal(Long entrepriseId, Long journalId,Abonnement abonnement) {

        Entreprise entreprise = entrepriseRepository.findById(entrepriseId)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID : " + entrepriseId));

        Journal journal = journalRepository.findById(journalId)
                .orElseThrow(() -> new RuntimeException("Journal non trouvé avec l'ID : " + journalId));

        return abonnementRepository.save(abonnement);
    }


}
