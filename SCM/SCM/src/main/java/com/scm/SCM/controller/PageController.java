package com.scm.SCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.SCM.entities.User;
import com.scm.SCM.forms.UserForm;
import com.scm.SCM.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")

    public String home(Model model){
        System.out.println("Home page handler");
        model.addAttribute("name", "Vaibhav Tambe");
        model.addAttribute("Youtube", "hb");
        model.addAttribute("a", "b");
        return "home";


    


    }

            //about route

         @RequestMapping("/about")
             public String aboutPage() {
              System.out.println("about page handler");
              return "about";
    }

            //services 


    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("services page handler");
        return "services";
    }

    //contact page

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }


    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    
    @GetMapping("/register")
    public String register(Model model) {
        UserForm userForm=new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    //processing register
    @RequestMapping(value = "do-register",method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm){
        System.out.println("Processinggggggggggg");
        System.out.println(userForm);

        //save to db
    
        //userForm to   -->>user
        User user=User.builder()
        .name(userForm.getName())
        .email(userForm.getEmail())
        .password(userForm.getPassword())
        .about(userForm.getAbout())
        .phoneNumber(userForm.getPhoneNumber())
        .profilePic("/SCM/src/main/resources/static/images/user.png")

        .build();
       User savedUser= userService.saveUser(user);
       System.out.println("saved user");


        return "redirect:/register";
    }
}

