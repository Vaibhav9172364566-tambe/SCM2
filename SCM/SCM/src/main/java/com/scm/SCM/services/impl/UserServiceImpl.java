package com.scm.SCM.services.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.constraints.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.SCM.entities.User;
import com.scm.SCM.helpers.ResourceNotFoundException;
import com.scm.SCM.repsitories.UserRepo;
import com.scm.SCM.services.UserServices;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;
    private Logger logger=LoggerFactory.getLogger(this.getClass());
    

    @Override
    public User saveUser(User user) {

        //user id generated
        String userId=java.util.UUID.randomUUID().toString();
        user.setUserId(userId);
        return userRepo.save(user);
       
    }

    @Override
    public Optional<User> getUserById(String id) {
       
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
       User user2= userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
       user2.setName(user.getName());
       user2.setEmail(user.getEmail());
       user2.setPassword(user.getPassword());
       user2.setAbout(user.getAbout());
       user2.setPhoneNumber(user.getPhoneNumber());
       user2.setProfilePic(user.getProfilePic());
       user2.setEnabled(user.isEnabled());
       user2.setEmailVerified(user.isEmailVerified());
       user2.setPhoneVerified(user.isPhoneVerified());
       user2.setProvider(user.getProvider());
       user2.setProviderUserId(user.getProviderUserId());

       User save=userRepo.save(user2);
       return Optional.ofNullable(save);



      
    }

    @Override
    public void deleteuser(String id) {

        User user2= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));

        userRepo.delete(user2);
        
        
    }

    @Override
    public boolean isUserExit(String UserId) {

        User user2= userRepo.findById(UserId).orElse(null);

        return user2 !=null ? true: false;
    }

    @Override
    public boolean isUserExitByEmail(String email) {

       User user= userRepo.findByEmail(email).orElse(null);
        return user !=null ? true :false;


        
    }

    @Override
    public List<User> getAllUsers() {

        return userRepo.findAll();
        
    }

    @Override
    public User getUserByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByEmail'");
    }

}
