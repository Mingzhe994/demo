package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by Stuart on 24/9/17.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="Guest") String name, Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails){
            name = ((UserDetails)principal).getUsername();
        }else {
            name = principal.toString();
        }

        model.addAttribute("name", name);
        return "index";
    }


}
