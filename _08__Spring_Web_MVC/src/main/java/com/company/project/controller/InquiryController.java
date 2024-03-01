package com.company.project.controller;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;

import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.company.project.model.Inquiry;
import com.company.project.model.Tag;

@Controller(value = "controller_inquiry")
public class InquiryController {

    @RequestMapping(path = "/inquiry", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView displayHome() {
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("inquiry.html");
        mnv.addObject("title", "INQUIRY");
        mnv.addObject("pageTitle", "[ INQUIRY-FORM ]");
        mnv.addObject("message", "Do You Have Any Doubts? Just Ask It!");
        // this way we integrate Inquiry Class with frontend and backend for form validation
        mnv.addObject("inquiry", new Inquiry());
        mnv.addObject("fieldErrorMap", new HashMap<String, String>());
        return mnv;
    }

    @PostMapping(path = "/saveInquiry")
    public ModelAndView saveInquiry(@Valid @ModelAttribute(name = "inquiry") Inquiry inquiry, Errors errors) {
        ModelAndView mnv = new ModelAndView();
        // 1. using Hibernate Validator, validate the data coming form front-end to back-end
        if (errors.hasErrors()) {
            // Map<String, String> fieldErrorMap = new HashMap<>();
            // for (FieldError fieldError : errors.getFieldErrors()) {
            // fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            // }
            Map<String, String> fieldErrorMap = new HashMap<>();
            for (ObjectError error : errors.getAllErrors()) {
                if (error instanceof FieldError) {
                    FieldError fieldError = (FieldError) error;
                    fieldErrorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
                }
            }
            System.out.println("\n> ERRORS: " + LocalDateTime.now());
            fieldErrorMap.forEach((name, message) -> System.out.println(name + ": " + message));
            mnv.addObject("fieldErrorMap", fieldErrorMap);
            mnv.setViewName("inquiry.html");
            return mnv;
        }
        // 2. use an object of Service Layer and perform business logic there
        Consumer<Inquiry> log = (i) -> System.out.println(i.toString());
        log.accept(inquiry);
        // 3. return the obtained result from Service Layer
        mnv.setViewName("redirect:/inquiry");
        return mnv;
    }

    @PostMapping(path = "/saveInquiryX")
    public ModelAndView saveInquiry(@RequestParam(name = "email") String email, @RequestParam(name = "tag") Tag tag,
                                    @RequestParam(name = "question") String question) {
        Consumer<String> log = (str) -> System.out.println("LOG:" + str);
        log.accept(email);
        log.accept(tag.toString());
        log.accept(question);
        return new ModelAndView("redirect:/inquiry");
    }

}

