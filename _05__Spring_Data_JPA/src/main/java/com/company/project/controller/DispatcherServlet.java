package com.company.project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.project.domain.Role;
import com.company.project.domain.User;
import com.company.project.repository.UserRepository;

@Controller(value = "controller_product")
public class DispatcherServlet {

	private final UserRepository userRepository;

	@Autowired
	public DispatcherServlet(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(path = { "", "/", "/index" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String goIndex(Model model) {
		model.addAttribute("title", "INDEX");
		return "index.html";
	}

	@RequestMapping(path = "/home", method = { RequestMethod.GET, RequestMethod.POST })
	public String goHome(Model model) {
		model.addAttribute("title", "HOME");
		model.addAttribute("message", "welcome home!");
		return "home.html";
	}

	@RequestMapping(path = "/thymeleaf", method = { RequestMethod.GET, RequestMethod.POST })
	public String display(Model model) {
		model.addAttribute("title", "THYMELEAF");
		model.addAttribute("message", "hello world!");
		User user = userRepository.findById(11L).get();
		model.addAttribute("user", user);
		model.addAttribute("ID", user.getId());
		List<User> userList = userRepository.findAll();
		model.addAttribute("userList", userList);
		return "thymeleaf.html";
	}

	@ResponseBody
	@RequestMapping(path = "/user/{uid1}", method = { RequestMethod.GET, RequestMethod.POST })
	public String api1(@PathVariable("uid1") Long uid) {
		return "API-1: USER -> id = " + uid;
	}

	@ResponseBody
	@RequestMapping(path = "/user", method = { RequestMethod.GET, RequestMethod.POST })
	public String api2(@RequestParam("uid2") Long uid) {
		return "API-2: USER -> id = " + uid;
	}

}
