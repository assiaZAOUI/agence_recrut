package com.workify.workify_ag.DTOs;

import java.util.Date;

public class RecrutementRequest {
    private Long offreId;
    private Long candidatId;

    // Getters et setters
    public Long getOffreId() {
        return offreId;
    }

    public void setOffreId(Long offreId) {
        this.offreId = offreId;
    }

    public Long getCandidatId() {
        return candidatId;
    }

    public void setCandidatId(Long candidatId) {
        this.candidatId = candidatId;
    }
}