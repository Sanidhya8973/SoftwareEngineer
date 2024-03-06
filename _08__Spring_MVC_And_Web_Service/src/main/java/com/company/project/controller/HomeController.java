package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "controller_home")
public class HomeController {

    @RequestMapping(path = "/home", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayHome(Model model) {
        model.addAttribute("title", "HOME");
        model.addAttribute("pageTitle", "[ HOME PAGE ]");
        model.addAttribute("message", "WELCOME HOME!");
        return "home.html";
    }

}
