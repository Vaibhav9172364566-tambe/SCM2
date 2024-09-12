package com.scm.SCM.services;

import java.util.List;
import java.util.Optional;

import com.scm.SCM.entities.User;

public interface UserService {

    User saveUser(User user);
    Optional<User> getUserById(String id);
    Optional<User>  updateUser(User user);
    void deleteUser(String id);
    boolean isUserExit(String userId);
    boolean isUserExittByEmail(String email);
    List<User> getAllUser();

}
