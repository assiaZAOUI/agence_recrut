package com.workify.workify_ag.DTOs;

import lombok.Data;

@Data
public class jwtAuthenticationResponse {
    private String token;
    private String role;
}
