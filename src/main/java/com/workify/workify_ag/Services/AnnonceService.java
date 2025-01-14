package com.workify.workify_ag.Services;

import com.workify.workify_ag.Entities.Annonce;

import java.util.List;

public interface AnnonceService {
    Annonce postuler(Annonce annonce);
    List<Annonce> getCandidaturesPourOffre(Long offreId);
}
