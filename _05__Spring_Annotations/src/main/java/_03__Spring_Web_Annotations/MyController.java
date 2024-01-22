package _03__Spring_Web_Annotations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//----------------------
//Spring Web Annotations
//----------------------

@Controller(value = "myController")
@RequestMapping(path = "/website", method = RequestMethod.POST)
public class MyController {

// -------------------------------
// [1] Request Handler Annotations
// -------------------------------

// 1.1 @RequestMapping Annotation

    // basic
    @RequestMapping(path = "/home")
    public String serveRequestHome() {
        return "home";
    }

    // advance
    @RequestMapping(path = "/path", method = RequestMethod.POST, params = "parameter", headers = "header", consumes = "cosume", produces = "produce")
    public String serveRequest1() {
        return "serve-request-path";
    }

    // master
    @RequestMapping(path = "/path", method = RequestMethod.POST, params = {"parameter-1", "parameter-2"}, headers = {
            "header-1", "header-2"}, consumes = {"consume-1", "cosume-2"}, produces = {"produce-1", "produce-2"})
    public String serveRequest2() {
        return "serve-request-path";
    }

// 1.2 @RequestBody Annotation

    // basic
    @RequestMapping(path = "/home")
    public void serveRequestBodyHome(@RequestBody Object obj) {
        // business logic
    }

    // advance
    @RequestMapping(path = "/path", method = RequestMethod.POST, params = "parameter", headers = "header", consumes = "cosume", produces = "produce")
    public void serveRequestBody(@RequestBody Object obj) {
        // business logic
    }

// 1.3 @PathVariable Annotation

    // @RequestMapping(path = "/{obj}")
    // @RequestMapping(path = "/${obj}")
    // @RequestMapping(path = "/path/${obj}")
    // @RequestMapping(path = "/path/${obj-1}/path/${obj-2}")
    // @RequestMapping(path = { "/{obj}", "/${obj}", "/path/${obj}" })

    // basic
    @RequestMapping(path = "/{obj}")
    public Object pathVariable1(@PathVariable Object obj) {
        // business logic
        return obj;
    }

    @RequestMapping(path = {"/{obj}", "/${obj}", "/path/${obj}"})
    public Object pathVariable2(@PathVariable("obj") Object obj) {
        // business logic
        return obj;
    }

    @RequestMapping(path = "/path/${obj}")
    public Object pathVariable3(@PathVariable(required = false) Object obj) {
        // business logic
        return obj;
    }

    @RequestMapping(path = "/path/${obj-1}/path/${obj-2}")
    public Object pathVariable4(@PathVariable("obj-1") Object obj1, @PathVariable("obj-2") Object obj2) {
        Object obj = new Object();
        // business logic
        return obj;
    }

    // advance
    @RequestMapping(path = {"/path/${obj}", "/path/${obj-1}/path${obj-2}"}, params = {"param-1", "param-2"})
    public Object pathVariable5(@PathVariable("obj") Object obj1, @RequestParam("param-1") String str) {
        Object obj = new Object();
        // business logic
        return obj;
    }

// 1.3 @RequestParam Annotation

    // basic
    @RequestMapping(path = "/path")
    public String requestParam1(@RequestParam("id") String id) {
        return id;
    }

    @RequestMapping(path = "/path", params = "id")
    public String requestParam2(@RequestParam("id") String id) {
        return id;
    }

    @RequestMapping(path = "/path", params = {"id", "name"})
    public String requestParam3(@RequestParam("id") String id, @RequestParam("name") String name) {
        return id + ":" + name;
    }

    @RequestMapping(path = "/path")
    public String requestParam4(@RequestParam(defaultValue = "1") String id) {
        return id;
    }

    @RequestMapping(path = "/path")
    public String requestParam5(@RequestParam(required = false) String id) {
        return id;
    }

    // advance
    @RequestMapping(path = "/path/${obj-1}/path${obj-2}", params = "param", method = RequestMethod.GET)
    public Object requestParam6(@PathVariable("obj") Object obj1, @RequestParam("param-1") String str) {
        Object obj = new Object();
        // business logic
        return obj;
    }

    @RequestMapping(path = {"/path/${obj}", "/path/${obj-1}/path${obj-2}"}, params = {"param-1", "param-2"})
    public Object requestParam7(@PathVariable("obj") Object obj1, @RequestParam("param-1") String str) {
        Object obj = new Object();
        // business logic
        return obj;
    }

// 1.4 @RequestHeader Annotation

// 1.5 @CookieValue Annotation

// --------------------------------
// [2] Response Handler Annotations
// --------------------------------

// 2.1 @ResponseBody Annotation

    @ResponseBody
    @RequestMapping(path = "/path")
    public String responseBody() {
        return "Hello World!";
    }

    @ResponseBody
    @RequestMapping(path = "/path-class", method = RequestMethod.GET)
    public class Test {

        @RequestMapping(path = "/path-method")
        public String responseBody() {
            return "Hello World!";
        }

    }

// 2.2 @ExceptionHandler Annotation

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

// 2.3 @ResponseStatus Annotation

// -----------------------------------------------------------------------
// [3] Annotations That Do Not Manage HTTP Requests And Responses Directly
// -----------------------------------------------------------------------

// 3.1 @Controller Annotation

// 3.2 @RestController Annotation

// 3.3 @ModelAttribute Annotation

// 3.4 @CrossOrigin Annotation

}