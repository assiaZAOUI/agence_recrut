package com.workify.workify_ag.Services.AuthenticationService.Authentification;

import com.workify.workify_ag.DTOs.*;
import com.workify.workify_ag.DTOs.SignUpRequestCandidat;
import com.workify.workify_ag.DTOs.SignUpRequestEntreprise;
import com.workify.workify_ag.DTOs.jwtAuthenticationResponse;
import com.workify.workify_ag.Entities.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthentificationService {


    User signupEntreprise(SignUpRequestEntreprise signUpRequest);
    User signupCandidat(SignUpRequestCandidat signUpRequest);
    jwtAuthenticationResponse signin(SignInRequest signInRequest);
}

