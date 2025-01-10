package com.workify.workify_ag.Services.AuthenticationService.Authentification;

import com.workify.workify_ag.DTOs.*;
import com.workify.workify_ag.DTOs.SignUpRequestEntreprise;
import com.workify.workify_ag.DTOs.jwtAuthenticationResponse;
import com.workify.workify_ag.Entities.ENUM.Roles;
import com.workify.workify_ag.Entities.User;
import com.workify.workify_ag.Repositorys.UserRepo.UserRepo;
import com.workify.workify_ag.Services.JWT.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthentificationServiceImpl implements AuthentificationService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signupEntreprise(SignUpRequestEntreprise signUpRequest) {
        // Logique pour inscrire un utilisateur avec un rôle "ENTREPRISE"
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));  // Hashing du mot de passe
        user.setRole(Roles.ENTREPRISE);  // Assignation du rôle "ENTREPRISE"

        return userRepo.save(user);  // Sauvegarde de l'utilisateur dans la base de données
    }

    @Override
    public User signupCandidat(SignUpRequestCandidat signUpRequest) {
        // Logique pour inscrire un utilisateur avec un rôle "CANDIDAT"
        User user = new User();
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));  // Hashing du mot de passe
        user.setRole(Roles.CANDIDAT);  // Assignation du rôle "CANDIDAT"

        return userRepo.save(user);  // Sauvegarde de l'utilisateur dans la base de données
    }

    @Override
    public jwtAuthenticationResponse signinEntreprise(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                signInRequest.getPassword()));
        var user = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);

        jwtAuthenticationResponse jwtAuthenticationResponse = new jwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRole(user.getRole().toString());

        return jwtAuthenticationResponse;
    }

    @Override
    public jwtAuthenticationResponse signinCandidat(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),
                signInRequest.getPassword()));
        var user = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);

        jwtAuthenticationResponse jwtAuthenticationResponse = new jwtAuthenticationResponse();

        jwtAuthenticationResponse.setToken(jwt);
        jwtAuthenticationResponse.setRole(user.getRole().toString());

        return jwtAuthenticationResponse;
    }

}
