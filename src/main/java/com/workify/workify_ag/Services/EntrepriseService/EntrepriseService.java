package com.workify.workify_ag.Services.EntrepriseService;

import com.workify.workify_ag.Entities.Entreprise;
import org.springframework.stereotype.Service;

@Service
public interface EntrepriseService {

    void ModifierEntreprise(Long idEntreprise,Entreprise entreprise);
    double calculatePercentageOfEntreprisesWithOffers();


}
