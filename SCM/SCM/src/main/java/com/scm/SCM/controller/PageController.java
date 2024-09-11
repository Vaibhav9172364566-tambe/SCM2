package com.scm.SCM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

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
}

