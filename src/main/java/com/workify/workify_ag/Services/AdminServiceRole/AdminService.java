package com.workify.workify_ag.Services.AdminServiceRole;

import com.workify.workify_ag.Entities.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long id);
    Admin saveAdmin(Admin admin);
    void deleteAdmin(Long id);
}

