package com.workify.workify_ag.Services.JournalService;

import com.workify.workify_ag.Entities.*;
import com.workify.workify_ag.Repositorys.AbonnementRepo.AbonnementRepository;
import com.workify.workify_ag.Repositorys.CategorieRepo.CategorieRepository;
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
    private final CategorieRepository categorieRepository;



    @Autowired
    public JournalServiceImp(JournalRepository journalRepository, AbonnementRepository abonnementRepository,EntrepriseRepository entrepriseRepository,CategorieRepository categorieRepository) {
        this.journalRepository=journalRepository;
        this.abonnementRepository=abonnementRepository;
        this.entrepriseRepository=entrepriseRepository;
        this.categorieRepository = categorieRepository;
    }
    public List<Journal> getAllJournals() {

        return journalRepository.findAll();
    }
    public List<Journal> getJournalByCategorie(String categorie) {

        return journalRepository.findByCategorie(categorie);
    }
    public List<Journal> getJournalByLibelle(String libelle) {

        return journalRepository.findByLibelle(libelle);

    }

    public long getTotalJournals() {

        return journalRepository.countAllJournals();

    }
    public Journal ajouterJournal(Journal journal) {
        // Récupérer la catégorie associée au journal
        Categorie categorie = journal.getCategorie();

        if (categorie != null) {
            // Si la catégorie a un ID, vérifiez si elle existe déjà
            if (categorie.getIdCategorie() != null) {
                Optional<Categorie> existingCategorie = categorieRepository.findById(categorie.getIdCategorie());
                if (existingCategorie.isPresent()) {
                    // Utiliser la catégorie existante
                    journal.setCategorie(existingCategorie.get());
                } else {
                    throw new RuntimeException("Catégorie non trouvée avec l'ID : " + categorie.getIdCategorie());
                }
            } else if (categorie.getLibelle() != null) {
                // Si la catégorie n'a pas d'ID mais a un libellé, recherchez-la par libellé
                Optional<Categorie> existingCategorie = categorieRepository.findByLibelle(categorie.getLibelle());
                if (existingCategorie.isPresent()) {
                    // Utiliser la catégorie existante
                    journal.setCategorie(existingCategorie.get());
                } else {
                    // Créer une nouvelle catégorie si elle n'existe pas
                    categorie = categorieRepository.save(categorie);
                    journal.setCategorie(categorie);
                }
            } else {
                throw new IllegalArgumentException("La catégorie doit avoir un ID ou un libellé");
            }
        } else {
            throw new IllegalArgumentException("La catégorie est obligatoire");
        }

        // Sauvegarder le journal
        return journalRepository.save(journal);
    }

        public void SupprimerJournal(Long journalId) {

            Journal journal = journalRepository.findById(journalId)
                    .orElseThrow(() -> new RuntimeException("Journal non trouvé avec l'ID : " + journalId));

            journalRepository.delete(journal);



        }




}
