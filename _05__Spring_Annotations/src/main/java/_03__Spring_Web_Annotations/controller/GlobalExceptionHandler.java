package _03__Spring_Web_Annotations.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "specify-excuse-for-corresponding-exception")
    public String onException(Exception e, Model model) {
        String title = "error";
        String httpStatusCode = HttpStatusCode.valueOf(500).toString();
        String httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.toString();
        String mainError = "> " + e.getMessage();
        String stackTrace = "<br>> " + e.getStackTrace().toString();
        String errorMsg = mainError + stackTrace;

        model.addAttribute("title", title);
        model.addAttribute("httpStatusCode", httpStatusCode);
        model.addAttribute("httpStatus", httpStatus);
        model.addAttribute("msg", errorMsg);

        return "message";
    }

}

// ---------------------------------------------------------------------------------------------------------
// message.jsp is a jsp file where we will display dynamic messages and change the webpage title accordingly
// ---------------------------------------------------------------------------------------------------------
// for example:-
// a) success messages
// b) failure messages
// c) when exception occurs
// d) trying to access priority/seniority/level based resources
// ---------------------------------------------------------------------------------------------------------
// <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
// <%@page isELIgnored="false"%>
// <!DOCTYPE html>
// <html>
//     <head>
//     <meta charset="ISO-8859-1">
//         <title>${title}</title>
//     </head>
//     <body>
//         <h1>${title}</h1>
//         <h2>${httpStatusCode}</h2>
//         <h2>${httpStatus}</h2>
//         <h2>${msg}</h2>
//     </body>
// </html>
// ---------------------------------------------------------------------------------------------------------


