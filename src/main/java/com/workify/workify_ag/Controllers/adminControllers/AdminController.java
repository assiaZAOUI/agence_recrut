package com.workify.workify_ag.Controllers.adminControllers;

import com.workify.workify_ag.DTOs.AdminDTO.UserDTO;
import com.workify.workify_ag.Entities.Admin;
import com.workify.workify_ag.Services.AdminServiceRole.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")  // Le chemin de l'API pour accéder aux Admins
public class AdminController {
}