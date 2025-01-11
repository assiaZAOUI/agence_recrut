package com.workify.workify_ag;
import com.workify.workify_ag.Entities.Admin;
import com.workify.workify_ag.Entities.ENUM.Roles;
import com.workify.workify_ag.Entities.User;
import com.workify.workify_ag.Repositorys.UserRepo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@SpringBootApplication
public class WorkifyAgApplication {
    @Autowired
    private  UserRepository userRepo;

    public static void main(String[] args) {
        SpringApplication.run(WorkifyAgApplication.class, args);
    }

    @Bean
    CommandLineRunner start() {
        return args -> {
            Optional<User> admin = userRepo.findByRole(Roles.ADMIN);
            if (admin.isEmpty()) {  // Use isEmpty() to check for the absence of an admin user
                Admin newAdmin = new Admin();
                newAdmin.setEmail("zaouiassia1818@gmail.com");
                newAdmin.setRole(Roles.ADMIN);
                newAdmin.setPassword(new BCryptPasswordEncoder().encode("assia@2000"));
                userRepo.save(newAdmin);
            }
        };
    }
}