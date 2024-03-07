package com.company._01__WebMVC.controller;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Consumer;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.company._01__WebMVC.service.InquiryServiceImp;
import com.company._01__WebMVC.model.Inquiry;
import com.company._01__WebMVC.model.Tag;
import org.springframework.validation.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "controller_inquiry")
public class InquiryController {

    private final InquiryServiceImp inquiryServiceImp;

    @Autowired
    public InquiryController(InquiryServiceImp inquiryServiceImp) {
        this.inquiryServiceImp = inquiryServiceImp;
    }

    @RequestMapping(path = "/inquiry", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView displayInquiry() {
        ModelAndView mnv = new ModelAndView("inquiry.html");
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
        try {
            inquiryServiceImp.createInquiry(inquiry);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
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