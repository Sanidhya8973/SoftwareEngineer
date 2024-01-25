package _03__Spring_Web_Annotations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.*;

// ----------
// Spring MVC
// ----------

@Controller(value = "myController")
public class MyController {

// --------------------------
// [1] Spring Web Annotations
// --------------------------

// ---------------------------------
// [1.1] Request Handler Annotations
// ---------------------------------

// 1.1.1 @RequestMapping Annotation

    // basic: method level annotation
    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String serveRequestHome() {
        return "home";
    }

    // basic: class level annotation
    @Controller
    @RequestMapping(path = "/website", method = RequestMethod.POST)
    public class Test1 {
        @RequestMapping(path = "/home")
        public String serveRequestHome() {
            return "home";
        }
    }

    // advance
    @RequestMapping(path = "/path", method = RequestMethod.POST, params = "parameter", headers = "key=value", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public String serveRequest1() {
        return "serve-request-path";
    }

    // master
    @RequestMapping(path = "/path", method = RequestMethod.POST, params = {"parameter-1", "parameter-2"}, headers = {"key1=value1", "key2=value2"}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String serveRequest2() {
        return "serve-request-path";
    }

    // fallback for all GET requests // fallback = backup
    @RequestMapping(path = "/*", method = RequestMethod.GET)
    @ResponseBody
    public String fallbackGET() {
        return "> Server Crashed: backup is live...";
    }

    // fallback for all POST requests // fallback = backup
    @RequestMapping(path = "/*", method = RequestMethod.POST)
    @ResponseBody
    public String fallbackPOST() {
        return "> Server Crashed: backup is live...";
    }

    // fallback for all requests // fallback = backup
    @RequestMapping(path = "/*", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
            RequestMethod.PATCH, RequestMethod.DELETE})
    @ResponseBody
    public String fallbackMechanism() {
        return "> Server Crashed: backup is live...";
    }

// 1.1.2 @RequestBody Annotation

    // basic
    @RequestMapping(path = "/home")
    public void serveRequestBodyHome(@RequestBody Object obj) {
        // business logic
    }

    // advance
    @RequestMapping(path = "/path", method = RequestMethod.POST, params = "parameter", headers = "key=value", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public void serveRequestBody(@RequestBody Object obj) {
        // business logic
    }

// 1.1.3 @PathVariable Annotation

    // @RequestMapping(path = "/{obj}")
    // @RequestMapping(path = "/path/{obj}")
    // @RequestMapping(path = "/path/{obj-1}/path/{obj-2}")
    // @RequestMapping(path = { "/{obj}", "/path/{obj}" })

    // @RequestMapping(path = "/path/q?{obj}")
    // @RequestMapping(path = "/path/search?{obj}")
    // @RequestMapping(path = "/search?{obj}")

    // basic
    @RequestMapping(path = "/search?{obj}")
    public Object pathVariable1(@PathVariable Object obj) {
        // business logic
        return obj;
    }

    @RequestMapping(path = {"/{obj}", "/path/{obj}"})
    public Object pathVariable2(@PathVariable("obj") Object obj) {
        // business logic
        return obj;
    }

    @RequestMapping(path = "/path/{obj}")
    public Object pathVariable3(@PathVariable(required = false) Object obj) {
        // business logic
        return obj;
    }

    @RequestMapping(path = "/path/{obj-1}/path/{obj-2}")
    public Object pathVariable4(@PathVariable("obj-1") Object obj1, @PathVariable("obj-2") Object obj2) {
        Object obj = new Object();
        // business logic
        return obj;
    }

    // advance
    @RequestMapping(path = {"/path/{obj}", "/path/{obj-1}/path/{obj-2}"}, params = {"param-1", "param-2"})
    public Object pathVariable5(@PathVariable("obj") Object obj1, @RequestParam("param-1") String str) {
        Object obj = new Object();
        // business logic
        return obj;
    }

// 1.1.3 @RequestParam Annotation

    // basic
    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String requestParam1(@RequestParam("id") String id) {
        return id;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST, params = "id")
    public String requestParam2(@RequestParam("id") String id) {
        return id;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST, params = {"id", "name"})
    public String requestParam3(@RequestParam("id") String id, @RequestParam("name") String name) {
        return id + ":" + name;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String requestParam4(@RequestParam(defaultValue = "1") String id) {
        return id;
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String requestParam5(@RequestParam(required = false) String id) {
        return id;
    }

    // advance
    @RequestMapping(path = "/path/{obj-1}/path/{obj-2}", params = "param", method = RequestMethod.POST)
    public Object requestParam6(@PathVariable("obj") Object obj1, @RequestParam("param-1") String str) {
        Object obj = new Object();
        // business logic
        return obj;
    }

    @RequestMapping(path = {"/path/{obj}", "/path/{obj-1}/path/{obj-2}"}, params = {"param-1", "param-2"}, method = RequestMethod.POST)
    public Object requestParam7(@PathVariable("obj") Object obj1, @RequestParam("param-1") String str) {
        Object obj = new Object();
        // business logic
        return obj;
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public String getKeyValue(@RequestParam("key") int key, @RequestParam("value") String value, Model model) {
        String keyValue = "KEY: " + key + " -> VALUE: " + value;
        System.out.println(keyValue);
        model.addAttribute("msg", keyValue);
        return "message";
    }

// 1.1.4 @RequestHeader Annotation

// 1.1.5 @CookieValue Annotation

// ----------------------------------
// [1.2] Response Handler Annotations
// ----------------------------------

// 1.2.1 @ResponseBody Annotation

    @RequestMapping(path = "/path")
    @ResponseBody
    public String responseBody() {
        return "Hello World!";
    }

    @RequestMapping(path = "/path-class", method = RequestMethod.GET)
    @ResponseBody
    public class Test2 {
        @RequestMapping(path = "/path-method")
        public String responseBody() {
            return "Hello World!";
        }
    }

// 1.2.2 @ExceptionHandler Annotation

    // basic
    @ExceptionHandler(IllegalArgumentException.class)
    public String onException1(Exception e) {
        return ">" + e.getMessage() + "\n" + e.getStackTrace();
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    public String onException2(Exception e) {
        return ">" + e.getMessage() + "\n" + e.getStackTrace();
    }

    @ExceptionHandler(value = {IllegalAccessException.class, IllegalAccessError.class})
    public String onException3(Exception e) {
        return ">" + e.getMessage() + "\n" + e.getStackTrace();
    }

    // advance
    @ExceptionHandler(value = {Exception.class})
    public String displayException(Model model, Exception e) {
        String key = "message";
        String value = e.getMessage();
        model.addAttribute(key, value);
        return "exception-page-path";
    }

    // there is a exception-page-path.jsp file where we have <%@page isELIgnored = false %>
    // now we will use this Model class to display dynamic Exception message
    // <h1> ${message} </h1>
    // OR go with traditional flow using jsp EL
    // <% String message = (String) request.getAttribute("message"); %>
    // <h1> <%= message %> </h1>

// 1.2.3 @ControllerAdvice Annotation

    @ControllerAdvice(value = "excpetion-handling-mechanism-for-enitre-project")
    public class ExceptionTest1 {

        @ExceptionHandler(value = {Exception.class})
        public String displayException(Model model, Exception e) {
            String key = "message";
            String value = e.getMessage();
            model.addAttribute(key, value);
            return "exception-page-path";
        }

        @ExceptionHandler(value = {IllegalAccessException.class, IllegalAccessError.class})
        public String onException3(Exception e) {
            return ">" + e.getMessage() + "\n" + e.getStackTrace();
        }

    }

// 1.2.4 @ResponseStatus Annotation

    // 1.2.4.1
    // returning HttpStatus code via @ResponseStatus
    @RequestMapping(path = "/path", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "specify-the-reason-here")
    public void responseStatus1() {
        // business logic
    }

    // 1.2.4.2
    // returning HttpStatus code via @ExceptionHandler and @ResponseStatus
    @RequestMapping(path = "/path", method = RequestMethod.GET)
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "specify-the-reason-here")
    public void responseStatus2(IllegalArgumentException exception) {
        // business logic
    }

    // 1.2.4.3
    // a) returning custom HttpStatus code via ResponseEntity class
    // b) returning custom HttpStatus code via an exception i.e. @ResponseStatus annotation on exception classes
    // c) returning custom HttpStatus code via @Controller and @ExceptionHandler annotations

    // 1.2.4.3
    // a) returning custom HttpStatus code via ResponseEntity class
    @RequestMapping(path = "/path", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity responseStatus3() {
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    // 1.2.4.3
    // b) returning custom HttpStatus code via an exception i.e. @ResponseStatus annotation on exception classes
    @ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "specify-the-reason-here")
    public class ForbiddenException extends RuntimeException {
        // business logic
    }

    @ResponseBody
    @RequestMapping(path = "/path/exception", method = RequestMethod.GET)
    public ResponseEntity responseStatus4() {
        throw new ForbiddenException();
    }

    // 1.2.4.3
    // c) returning custom HttpStatus code via @Controller & @ExceptionHandler annotations
    @ControllerAdvice(value = "excpetion-handling-mechanism-for-enitre-project")
    public class ExceptionTest2 {

        @ExceptionHandler(value = {Exception.class})
        public String displayException(Model model, Exception e) {
            String key = "message";
            String value = e.getMessage();
            model.addAttribute(key, value);
            return "exception-page-path";
        }

    }

// -----------------------------------------------------------------------
// [1.3] Annotations That Do Not Manage HTTP Requests And Responses Directly
// -----------------------------------------------------------------------

// 1.3.1 @Controller Annotation

    @Controller
    public class Test3 {
        // business logic
    }

    @Controller("myController")
    public class Test4 {
        // business logic
    }

    @Controller(value = "myController")
    public class Test5 {
        // business logic
    }

// 1.3.2 @RestController Annotation

    @Controller
    @ResponseBody
    public class Test6 {
        // business logic
    }

    @RestController
    public class Test7 {
        // business logic
    }

    @RestController(value = "myController")
    public class Test8 {
        // business logic
    }

// 1.3.3 @ModelAttribute Annotation

    // basic method-parameter level annotation
    @PostMapping(path = "/path")
    public void modelAttribute1(@ModelAttribute("obj") Object objX) {
        // business logic
    }

    @PostMapping(path = "/path")
    public void modelAttribute2(@ModelAttribute Object obj) {
        // business logic
    }

    // basic method level annotation
    @ModelAttribute("obj")
    public Object modelAttribute3(Object objX) {
        // Spring will automatically add the method’s return value to the model
        // business logic
        return objX;
    }

    @ModelAttribute
    public Object modelAttribute4(Object obj) {
        // Spring will automatically add the method’s return value to the model
        // business logic
        return obj;
    }

    // advance
    @RequestMapping(path = "/path", method = RequestMethod.GET, params = "param", headers = "header", consumes = "consume", produces = "produce")
    public void modelAttribute5(@ModelAttribute("obj") Object objX, @ModelAttribute Object obj) {
        // business logic
    }

    @ModelAttribute
    public Object modelAttribute6(Model model) {
        // set common key-value pairs that remains the same throughout the WebApp
        // for example set the user credentials throughout your WebApp to reduce the code complexity
        model.addAttribute("common-key", "common-values");
        return model;
    }

// 1.3.4 @CrossOrigin Annotation

    // basic: method level annotation
    @CrossOrigin
    @RequestMapping(path = "/path", method = RequestMethod.GET)
    public String enableCrossOrigin1() {
        return "path";
    }

    @CrossOrigin(origins = "http://example.com", maxAge = 3600)
    @RequestMapping(path = "/path/{id}", method = RequestMethod.GET)
    public String enableCrossOrigin2(@PathVariable long id) {
        return "path-id";
    }

    // basic: class level annotation
    @CrossOrigin
    @RequestMapping(path = "/website")
    public class Test {

        @RequestMapping(path = "/path", method = RequestMethod.GET)
        public String enableCrossOrigin1() {
            return "path";
        }

        @RequestMapping(path = "/path", method = RequestMethod.GET)
        public String enableCrossOrigin2() {
            return "path";
        }

    }

//---------------------------------------
// [2] Spring MVC: Redirection / Redirect
//---------------------------------------

// 2.1 using redirect prefix

    @RequestMapping(path = "/path", method = RequestMethod.POST)
    public String redirect1() {
        return "redirect:/path-of-redirection";
    }

    @RequestMapping(path = "/path", method = RequestMethod.POST)
    public String redirect2() {
        return "redirect:" + "https://www.google.com";
    }

    @RequestMapping(path = "/path", method = RequestMethod.POST)
    public String redirect3(String search) {
        return "redirect:" + "https://www.google.com/search?q=" + search;
    }

// 2.2 using RedirectView class

    @RequestMapping(path = "/path", method = RequestMethod.POST)
    public RedirectView redirect4() {
        String myUrl = "https://www.google.com/search";
        RedirectView rv = new RedirectView();
        rv.setUrl(myUrl);
        return rv;
    }

    @RequestMapping(path = "/path", method = RequestMethod.POST)
    public RedirectView redirect5(String search) {
        String myUrl = "https://www.google.com/search?q=" + search;
        RedirectView rv = new RedirectView();
        rv.setUrl(myUrl);
        return rv;
    }

// --------------------------------------------------------------------------------
// [3] Spring MVC: Handle Messages To Be Displayed on HTML Form When There Is Error
// --------------------------------------------------------------------------------

    @RequestMapping(path = "/form", method = RequestMethod.POST)
    public String getForm(BindingResult br, @ModelAttribute("obj") Object obj, Model m) {
        if (br.hasErrors()) {
            m.addAttribute("message", "msg-value");
            return "form";
            // at view->form there is a jstl tag to display the error
            // <form:errors path="user.*" />
        }

        return "user-profile";
    }

}
