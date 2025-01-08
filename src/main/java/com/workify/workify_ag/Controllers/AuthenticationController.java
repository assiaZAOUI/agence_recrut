package com.workify.workify_ag.Controllers;

import com.workify.workify_ag.DTOs.SignInRequest;

import com.workify.workify_ag.DTOs.SignUpRequestCandidat;
import com.workify.workify_ag.DTOs.SignUpRequestEntreprise;
import com.workify.workify_ag.Entities.User;

import com.workify.workify_ag.Services.AuthenticationService.Authentification.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthentificationService authentificationService;
    @PostMapping("/signupCandidat")
    public ResponseEntity<User> signup(@RequestBody SignUpRequestCandidat signUpRequestCandidat) {
        return ResponseEntity.ok(authentificationService.signupCandidat(signUpRequestCandidat));
    }

    @PostMapping("/signupEntreprise")
    public ResponseEntity<User> signup(@RequestBody SignUpRequestEntreprise signUpRequestEntreprise) {
        return ResponseEntity.ok(authentificationService.signupEntreprise(signUpRequestEntreprise));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignInRequest signInRequest) {
        try {
            return ResponseEntity.ok(authentificationService.signinCandidat(signInRequest));
        } catch (Exception e) {
            e.printStackTrace(); // ou utilisez un logger
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication failed: " + e.getMessage());
        }
    }

}
