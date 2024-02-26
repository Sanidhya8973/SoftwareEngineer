package com.company.project.controller;

import com.company.project.model.Inquiry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.function.Consumer;

@Controller(value = "controller_inquiry")
public class InquiryController {

    @RequestMapping(path = "/inquiry", method = {RequestMethod.GET, RequestMethod.POST})
    public String displayInquiry(Model model) {
        model.addAttribute("title", "INQUIRY");
        model.addAttribute("message", "ANY DOUBTS? ASK QUESTIONS!");
        return "inquiry.html";
    }

    @PostMapping(path = "/saveInquiry")
    public ModelAndView saveInquiry(Inquiry inquiry) {
        // 1. using Hibernate Validator, validate the data coming form front-end to back-end
        // 2. use an object of Service Layer and perform business logic there
        Consumer<Inquiry> log = (i) -> System.out.println(i.toString());
        log.accept(inquiry);
        // 3. return the obtained result from Service Layer
        return new ModelAndView("redirect:/inquiry");
    }

    @PostMapping(path = "/saveInquiryX")
    public ModelAndView saveInquiry(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName, @RequestParam(name = "email") String email, @RequestParam(name = "contact") String contact, @RequestParam(name = "question") String question, @RequestParam(name = "type") Inquiry.Type type) {
        Consumer<String> log = (str) -> System.out.println("LOG:" + str);
        log.accept(firstName);
        log.accept(lastName);
        log.accept(email);
        log.accept(contact);
        log.accept(question);
        return new ModelAndView("redirect:/inquiry");
    }

}
