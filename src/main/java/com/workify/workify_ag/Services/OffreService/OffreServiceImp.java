package com.workify.workify_ag.Services.OffreService;


import com.workify.workify_ag.DTOs.OffresDTO.FiltrerOffre;
import com.workify.workify_ag.DTOs.OffresDTO.OffreDTO;
import com.workify.workify_ag.Entities.*;
import com.workify.workify_ag.Repositorys.AbonnementRepo.AbonnementRepository;
import com.workify.workify_ag.Repositorys.EditionRepo.EditionRepository;
import com.workify.workify_ag.Repositorys.EntrepriseRepo.EntrepriseRepository;
import com.workify.workify_ag.Repositorys.JournalRepo.JournalRepository;
import com.workify.workify_ag.Repositorys.OffreRepo.OffreRepository;
import com.workify.workify_ag.Specification.OffreSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffreServiceImp implements OffreService{

    private final OffreRepository offreRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final EditionRepository editionRepository;
    private final JournalRepository journalRepository;
    private final AbonnementRepository abonnementRepository;

    public OffreServiceImp(OffreRepository offreRepository, EntrepriseRepository entrepriseRepository
    , EditionRepository editionRepository, JournalRepository journalRepository, AbonnementRepository abonnementRepository) {
        this.offreRepository = offreRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.editionRepository = editionRepository;
        this.journalRepository = journalRepository;
        this.abonnementRepository = abonnementRepository;
    }

    public List<OffreDTO> filtrerOffres(FiltrerOffre filtrerOffre) {
        Specification<Offre> spec = Specification.where(OffreSpecification.hasTitre(filtrerOffre.getTitre()))
                .and(OffreSpecification.hasVille(filtrerOffre.getVille()))
                .and(OffreSpecification.hasDomaine(filtrerOffre.getDomaine()))
                .and(OffreSpecification.hasNiveauEtude(filtrerOffre.getNiveauEtude()));

        List<Offre> offres = offreRepository.findAll(spec);

        // Convertir les offres en FiltrerOffre
        return offres.stream()
                .map(this::mapToOffreDTO) // Utiliser la méthode de conversion
                .collect(Collectors.toList());
    }

    public OffreDTO mapToOffreDTO(Offre offre) {
        OffreDTO offreDTO = new OffreDTO();
        offreDTO.setTitre(offre.getTitre());
        offreDTO.setNbrPost(offre.getNbrPost());
        offreDTO.setNbrAnneeExpDemander(offre.getNbrAnneeExpDemander());
        offreDTO.setCompetenceSouhaite(offre.getCompetenceSouhaite());
        offreDTO.setEtat(offre.isEtat());
        offreDTO.setNiveauEtude(offre.getNiveauEtude());
        offreDTO.setSalaire(offre.getSalaire());

        // Mapper les IDs des relations
        if (offre.getEdition() != null) {
            offreDTO.setEditionId(offre.getEdition().getIdEdition());
        }
        if (offre.getEntreprise() != null) {
            offreDTO.setEntreprise(offre.getEntreprise().getNomEntreprise());

            // Récupérer le journal via l'abonnement de l'entreprise
            if (!offre.getEntreprise().getAbonnements().isEmpty()) {
                Abonnement abonnement = offre.getEntreprise().getAbonnements().get(0); // Prendre le premier abonnement
                if (abonnement.getJournal() != null) {
                    offreDTO.setJournalNom(abonnement.getJournal().getNom());
                }
            }
        }

        return offreDTO;
    }

    @Override
    public Offre ajouterOffre(OffreDTO offreDTO) {
        // Créer une nouvelle instance d'Offre à partir de l'OffreDTO
        Offre offre = new Offre();
        offre.setTitre(offreDTO.getTitre());
        offre.setNbrAnneeExpDemander(offreDTO.getNbrAnneeExpDemander());
        offre.setCompetenceSouhaite(offreDTO.getCompetenceSouhaite());
        offre.setEtat(true);  // Mise à jour de l'état à true après la création
        offre.setNiveauEtude(offreDTO.getNiveauEtude());
        offre.setSalaire(offreDTO.getSalaire());
        Entreprise entrep =entrepriseRepository.findByNomEntreprise(offreDTO.getEntreprise());

        offre.setEntreprise(entrep);
        Journal journal = journalRepository.findByNom(offreDTO.getJournalNom())
                .orElseThrow(() -> new RuntimeException("Journal non trouvé avec l'ID : " + offreDTO.getJournalNom()));
        Abonnement abonnementActif = abonnementRepository.findByEntrepriseAndJournal(entrep, journal)
                .orElseThrow(() -> new RuntimeException("L'entreprise n'a pas d'abonnement actif pour ce journal"));

        if (!abonnementActif.isEtat()) {
            throw new RuntimeException("L'abonnement de l'entreprise pour ce journal est inactif");
        }

        Date aujourdHui = new Date();
        if (abonnementActif.getDateExpiration().before(aujourdHui)) {
            throw new RuntimeException("L'abonnement de l'entreprise pour ce journal a expiré");
        }

        // Récupérer l'édition du journal
        Edition edition = editionRepository.findById(offreDTO.getEditionId())
                .orElseThrow(() -> new RuntimeException("Édition non trouvée avec l'ID : " + offreDTO.getEditionId()));

        offre.setEdition(edition);



        return offreRepository.save(offre);
    }
    @Transactional
    public void supprimerOffre(Long idOffre) {
        try {
            // Récupérer l'offre
            Offre offre = offreRepository.findByIdOffre(idOffre)
                    .orElseThrow(() -> new RuntimeException("Offre non trouvée avec l'ID : " + idOffre));

            offreRepository.delete(offre);

        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la suppression de l'offre : " + e.getMessage());
        }
    }

    @Override
    public List<String> getListVille() {
        return offreRepository.findDistinctVilles();
    }

    @Override
    public List<String> getListFonction() {
        return offreRepository.findDistinctFonctions();
    }

    @Override
    public List<String> getListNiveauEtude() {
        return offreRepository.findDistinctNiveauxEtude();
    }

    @Override
    public List<Offre> getOffresActives() {
        return offreRepository.findByEtat(true);
    }

    @Override
    public List<Offre> getOffresDesactivees() {
        return offreRepository.findByEtat(false);
    }
}
