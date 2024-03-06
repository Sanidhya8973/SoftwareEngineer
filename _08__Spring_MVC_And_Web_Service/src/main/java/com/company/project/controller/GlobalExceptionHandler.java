package com.company.project.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class, Error.class})
    public ModelAndView handleException(Exception e) {
        ModelAndView mnv = new ModelAndView();
        mnv.setViewName("exception.html");
        mnv.addObject("title", "404");
        mnv.addObject("pageTitle", "404 PAGE NOT FOUND!");
        e.printStackTrace();
        mnv.addObject("message", "BAD REQUEST: " + e.getMessage());
        return mnv;
    }

}
