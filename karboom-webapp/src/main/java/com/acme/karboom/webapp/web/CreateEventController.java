package com.acme.karboom.webapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateEventController {

    @RequestMapping("/createEvent")
    public String getViewForPageLoad() {
        return "createEvent";
    }
}
