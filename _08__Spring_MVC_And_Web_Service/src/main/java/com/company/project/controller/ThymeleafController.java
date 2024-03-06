package com.company.project.controller;

import com.company.project.model.User;
import com.company.project.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "controller_thymeleaf")
public class ThymeleafController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public ThymeleafController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @RequestMapping(path = "/thymeleaf", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayThymeleaf(Model model) throws Exception {
        model.addAttribute("title", "THYMELEAF");
        model.addAttribute("pageTitle", "[ THYMELEAF - PAGE ]");
        model.addAttribute("message", "LEARN THYMELEAF");
        User user = userServiceImp.readUser(1L); // will throw Exception if user is not found...
        List<User> userList = userServiceImp.readUsers();
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
