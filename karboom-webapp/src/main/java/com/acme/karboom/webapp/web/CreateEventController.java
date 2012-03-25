package com.acme.karboom.webapp.web;

import ch.lambdaj.Lambda;
import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.acmefireworks.Event;
import org.acmefireworks.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@Controller
@RequestMapping("/createEvent")
@Scope("request")
public class CreateEventController {

    public static final String CREATE_EVENT_VIEW = "createEvent";
    public static final String ADD_PERSON_FORM_SUBMISSION_VIEW = String.format("redirect:%s", CREATE_EVENT_VIEW);

    private Event event;

    @Autowired
    public CreateEventController(EventSpringService event) {
        this.event = event;
    }

    @ModelAttribute(value = "person")
    public Person getPersonForForm() {
        return new Person();
    }

    @ModelAttribute(value = "peopleAttendingEvent")
    public Collection<String> getPeopleAttendingEvent() {
        return Lambda.extractString(event.getPeopleAttendingEvent());
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getViewForPageLoad() {
        return CREATE_EVENT_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getViewForFormSubmission(Person person, BindingResult result) {
        this.event.addPersonToEvent(person);
        return ADD_PERSON_FORM_SUBMISSION_VIEW;
    }
}
