package com.workify.workify_ag.Services.OffreService;

import com.workify.workify_ag.DTOs.OffreDTO.FiltrerOffre;
import com.workify.workify_ag.DTOs.OffreDTO.OffreDTO;
import com.workify.workify_ag.Entities.Offre;

import java.util.List;
public interface OffreService {
    List<Offre> filtrerOffres(FiltrerOffre filtrerOffre);
    Offre ajouterOffre(OffreDTO offreDTO);

}
