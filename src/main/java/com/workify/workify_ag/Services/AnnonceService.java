package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Annonce;

import java.util.List;

public interface AnnonceService {
    Annonce postuler(Long candidatId, Long offreId);
    List<Annonce> getCandidaturesPourOffre(Long offreId);
}
