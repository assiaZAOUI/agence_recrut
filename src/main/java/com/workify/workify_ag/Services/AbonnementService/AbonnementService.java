package com.workify.workify_ag.Services.AbonnementService;

import com.workify.workify_ag.Entities.Abonnement;

public interface AbonnementService {

    public Abonnement subscribeToJournal(Long entrepriseId, Long journalId, Abonnement abonnement) ;
    public void unsubscribeFromJournal(Long entrepriseId, Long journalId) ;
    }
