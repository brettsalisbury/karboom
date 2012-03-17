package com.acme.karboom.webapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

    @RequestMapping("/helloworld")
    @ResponseBody
    public String helloWorld() {
        return "<html><body>Hello World!</body></html>";
    }
}
