package com.scm.SCM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.SCM.entities.User;
import com.scm.SCM.forms.UserForm;
import com.scm.SCM.helpers.Message;
import com.scm.SCM.helpers.MessageType;
import com.scm.SCM.services.UserServices;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class PageController {

    @Autowired
    private UserServices services;

    @GetMapping("/")
    public String index() {
        return "/redirect/home";
    }
    


    @Autowired
    private UserServices userService;

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
    @RequestMapping(value = "/do-register",method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm ,
      BindingResult rBindingResult,HttpSession session){

        
        System.out.println("Processinggggggggggg");
        System.out.println(userForm);


        //validate form data

        if(rBindingResult.hasErrors()){
            return "register";
        }

        //save to db
    
        //userForm to   -->>user
        // User user=User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("/SCM/src/main/resources/static/images/user.png")
        // .build();

        User user=new User();
   
         user.setName(userForm.getName());
         user.setEmail(userForm.getEmail());
         user.setPassword(userForm.getPassword());
         user.setAbout(userForm.getAbout());
         user.setPhoneNumber(userForm.getPhoneNumber());
        //  user.setEnabled(true);
         user.setProfilePic("/SCM/src/main/resources/static/images/user.png");


       User savedUser= userService.saveUser(user);
       System.out.println("saved user");

       Message message= Message.builder().content("Registeration Succefull").type(MessageType.green).build();


       session.setAttribute("message",message );


        return "redirect:/register";
    }

    
}

