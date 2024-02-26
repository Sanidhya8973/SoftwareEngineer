package com.company.project.controller;

import com.company.project.model.User;
import com.company.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller(value = "controller_thymeleaf")
public class ThymeleafController {

    private final UserService userService;

    @Autowired
    public ThymeleafController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/thymeleaf", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayThymeleaf(Model model) {
        model.addAttribute("title", "THYMELEAF");
        model.addAttribute("message", "[THYMELEAF-PAGE]");
        User user = userService.findById(1L);
        List<User> userList = userService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("ID", user.getId());
        model.addAttribute("userList", userList);
        return "thymeleaf.html";
    }

    @ResponseBody
    @RequestMapping(path = "/user", method = {RequestMethod.GET, RequestMethod.POST})
    public String api1(@RequestParam("uid1") Long uid) {
        return "API-1: USER -> id = " + uid;
    }

    @ResponseBody
    @RequestMapping(path = "/user/{uid2}", method = {RequestMethod.GET, RequestMethod.POST})
    public String api2(@PathVariable("uid2") Long uid) {
        return "API-2: USER -> id = " + uid;
    }

}
