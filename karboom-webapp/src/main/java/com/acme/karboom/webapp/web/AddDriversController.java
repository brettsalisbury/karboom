package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 31/03/12
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/addDrivers")
@Scope("request")
public class AddDriversController {

    @Autowired
    public AddDriversController(EventSpringService serviceEvent) {
        //To change body of created methods use File | Settings | File Templates.
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getViewForInitialPageLoad() {
        return "addDrivers";
    }
}
