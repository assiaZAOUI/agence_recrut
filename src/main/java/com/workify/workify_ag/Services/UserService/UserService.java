package com.workify.workify_ag.Services.UserService;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDetailsService userDetailsService();
}
