package com.company.project.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public static ResponseEntity<String> handleException(Exception exception) {
        HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("exception-key", "exception-value");
        String responseBody = exception.getLocalizedMessage();
        return ResponseEntity.status(httpStatus).headers(responseHeaders).body(responseBody);
    }

    @ExceptionHandler(value = Error.class)
    public static ResponseEntity<String> handleError(Error error) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("error-key", "error-value");
        String responseBody = error.getLocalizedMessage();
        return ResponseEntity.status(httpStatus).headers(responseHeaders).body(responseBody);
    }

}
