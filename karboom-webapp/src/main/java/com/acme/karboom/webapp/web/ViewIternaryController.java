package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.acmefireworks.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 15/04/12
 * Time: 4:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/viewIternary")
@Scope("request")
public class ViewIternaryController {

    private Event event;

    @Autowired
    public ViewIternaryController(EventSpringService event) {
        this.event = event;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getViewForInitialPageLoad(ModelMap model) {
        return "viewIternary";
    }
}
