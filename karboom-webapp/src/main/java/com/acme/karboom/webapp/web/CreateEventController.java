package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.acmefireworks.Event;
import org.acmefireworks.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/createEvent")
@Scope("request")
public class CreateEventController {

    private Event event;

    @Autowired
    public CreateEventController(EventSpringService event) {
        this.event = event;
    }

    @ModelAttribute(value="peopleAttendingEvent")
    public Collection<Person> getPeopleAttendingEvent() {
        return event.getPeopleAttendingEvent();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getViewForPageLoad(ModelMap model) {
        Person person = new Person();
        model.addAttribute("person",person);
        return "createEvent";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView getViewForFormSubmission(@ModelAttribute(value="person") Person person, BindingResult result) {
        this.event.addPersonToEvent(person);
        ModelAndView mav = new ModelAndView("createEvent");
        mav.addObject("person", new Person());
        return mav;
    }


}
