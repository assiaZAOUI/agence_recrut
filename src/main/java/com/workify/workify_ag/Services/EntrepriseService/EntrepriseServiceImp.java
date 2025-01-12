package com.workify.workify_ag.Services.EntrepriseService;

import com.workify.workify_ag.Entities.Entreprise;
import com.workify.workify_ag.Repositorys.EntrepriseRepo.EntrepriseRepository;
import org.springframework.stereotype.Service;

@Service
public class EntrepriseServiceImp implements EntrepriseService {
    private final EntrepriseRepository entrepriseRepository ;

    public EntrepriseServiceImp(EntrepriseRepository entrepriseRepository) {
        this.entrepriseRepository = entrepriseRepository;
    }

    public void afficherEntreprise() {}

    public void ModifierEntreprise(Long idEntreprise,Entreprise entreprise) {

        Entreprise entrepriseExistante = entrepriseRepository.findById(idEntreprise)
                .orElseThrow(() -> new RuntimeException("Entreprise non trouvée avec l'ID : " + idEntreprise));

        // Mettre à jour les champs de l'entreprise existante
        entrepriseExistante.setNomEntreprise(entreprise.getNomEntreprise());
        entrepriseExistante.setRaisonSocial(entreprise.getRaisonSocial());
        entrepriseExistante.setDescription(entreprise.getDescription());
        entrepriseExistante.setVille(entreprise.getVille());
        entrepriseExistante.setPhoto(entreprise.getPhoto());

        // Enregistrer les modifications
         entrepriseRepository.save(entrepriseExistante);

    }


}
