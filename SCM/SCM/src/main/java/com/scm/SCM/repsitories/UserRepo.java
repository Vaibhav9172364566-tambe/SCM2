package com.scm.SCM.repsitories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scm.SCM.entities.User;

public interface UserRepo  extends JpaRepository<User,String>{

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);

}
