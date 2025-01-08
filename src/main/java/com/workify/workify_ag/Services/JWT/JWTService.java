package com.workify.workify_ag.Services.JWT;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;

public interface JWTService {
    String generateToken(UserDetails userDetails);

    String extractUsername(String token);

    boolean isTokenValid(String token, UserDetails userDetails);


    String generateRefreshToken(HashMap<String, Object> extractClaims, UserDetails userDetails);

}
