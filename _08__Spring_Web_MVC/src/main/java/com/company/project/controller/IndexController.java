package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "controller_index")
public class IndexController {

    @RequestMapping(path = {"/", "/index"}, method = {RequestMethod.GET, RequestMethod.POST})
    public String displayIndex(Model model) {
        model.addAttribute("title", "INDEX");
        model.addAttribute("message", "[INDEX-PAGE]");
        return "index";
    }

}
