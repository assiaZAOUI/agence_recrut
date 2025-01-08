package com.workify.workify_ag.DTOs;

import lombok.Data;

@Data
public class SignInRequest {
    private String email;
    private String password;
}
