package com.scm.SCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/user")
public class UserController {

    //user dashboard
 
    @RequestMapping( value = "dashboard", method=RequestMethod.GET)
    public String userDashboard() {
        System.out.println("User Dashboard");
        return "user/dashboard";
    }
    

    //user profile page

    @RequestMapping( value = "/profile", method=RequestMethod.GET)
    public String userProfile() {
        System.out.println("User profile");
        return "user/profile";
    }

    //add contact page
    //view  contact

}
