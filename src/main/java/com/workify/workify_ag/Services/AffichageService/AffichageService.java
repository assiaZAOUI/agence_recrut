package com.workify.workify_ag.Services.AffichageService;

import org.springframework.stereotype.Service;


import com.workify.workify_ag.DTOs.EntrepCandiDTO;
import com.workify.workify_ag.DTOs.EntrepriseDTO.EntrepriseDTO;

import java.util.List;
@Service
public interface AffichageService {

    public List<EntrepCandiDTO> getAllCandidatsAndEntreprises() ;
    public EntrepriseDTO getEntrepriseById(Long id) ;
    }
