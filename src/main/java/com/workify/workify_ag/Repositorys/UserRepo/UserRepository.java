package com.workify.workify_ag.Repositorys.UserRepo;

import com.workify.workify_ag.Entities.Candidat;
import com.workify.workify_ag.Entities.ENUM.Roles;
import com.workify.workify_ag.Entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    @Query("SELECT c FROM User c WHERE c.id = :id")
    Optional<User> findById(@Param("id") Long id);
    Optional<User> findByRole(Roles role);
    @Transactional
    @Modifying
    @Query("update User u set u.password= ?2 where u.email =?1")
    void updatePassword(String email, String password);  // type peut être 'Admin', 'Candidat', 'Entreprise'

}
