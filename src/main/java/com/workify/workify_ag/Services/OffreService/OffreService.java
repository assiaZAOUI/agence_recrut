package com.workify.workify_ag.Services.OffreService;

import com.workify.workify_ag.DTOs.FiltrerOffre;
import com.workify.workify_ag.DTOs.OffreDTO;
import com.workify.workify_ag.Entities.Offre;
import java.util.List;

public interface OffreService {
    List<Offre> filtrerOffres(FiltrerOffre filtrerOffre);
    public Offre ajouterOffre(OffreDTO offreDTO);

}
