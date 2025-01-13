package com.workify.workify_ag.Services.OffreService;

import com.workify.workify_ag.DTOs.OffresDTO.FiltrerOffre;
import com.workify.workify_ag.DTOs.OffresDTO.OffreDTO;
import com.workify.workify_ag.Entities.Offre;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OffreService {
    List<OffreDTO> filtrerOffres(FiltrerOffre filtrerOffre);
    Offre ajouterOffre(OffreDTO offreDTO);
    List<String> getListVille();
    List<String> getListFonction();
    List<String> getListNiveauEtude();
    List<Offre> getOffresActives();
    List<Offre> getOffresDesactivees();
    void supprimerOffre(Long idOffre); // Méthode pour supprimer une offre par son ID


}
