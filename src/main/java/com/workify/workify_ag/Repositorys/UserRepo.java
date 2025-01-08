package com.workify.workify_ag.Repositorys;

import com.workify.workify_ag.Entities.ENUM.Roles;
import com.workify.workify_ag.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByRole(Roles role);
    @Transactional
    @Modifying
    @Query("update User u set u.password= ?2 where u.email =?1")
    void updatePassword(String email, String password);
}
