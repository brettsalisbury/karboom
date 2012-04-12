package com.acme.karboom.webapp.web;

import ch.lambdaj.Lambda;
import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import com.acme.karboom.webapp.formobjects.NewDrivers;
import org.acmefireworks.Event;
import org.acmefireworks.Person;
import org.hamcrest.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    private static final String ADD_DRIVERS_VIEW = "addDrivers";
    private static final String ADD_DRIVERS_FORM_SUBMISSION_VIEW = String.format("redirect:%s", ADD_DRIVERS_VIEW);

    private Event event;

    @Autowired
    public AddDriversController(EventSpringService event) {
        this.event = event;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getViewForInitialPageLoad(ModelMap model) {
        model.addAttribute("newDrivers", getDriverForForm());
        model.addAttribute("nominatedDrivers", convertDomainCollectionToFormCollection(this.event.getDrivers()));
        model.addAttribute("nonDrivers", convertDomainCollectionToFormCollection(this.event.getNonDrivingEventAttendees()));
        return ADD_DRIVERS_VIEW;
    }


    private NewDrivers getDriverForForm() {
        return new NewDrivers();
    }

    private Collection<String> convertDomainCollectionToFormCollection(Collection<Person> domainCollection) {
        return Lambda.extractString(domainCollection);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String getViewForFormSubmission(NewDrivers currentNewDrivers, BindingResult result) {
        addDriversToEvent(currentNewDrivers);
        return ADD_DRIVERS_FORM_SUBMISSION_VIEW;
    }

    private void addDriversToEvent(NewDrivers currentNewDrivers) {
        Collection<Person> drivers = this.convertStringsToDrivers(currentNewDrivers);
        for (Person driver : drivers) {
            this.event.addDriver(driver);
        }
    }

    private Collection<Person> convertStringsToDrivers(NewDrivers currentNewDrivers) {
        List<Person> drivers = new ArrayList<Person>();
        for (String val : currentNewDrivers.getDrivers()) {
            drivers.add((Person) Lambda.selectUnique(this.event.getPeopleAttendingEvent(), Lambda.having(Lambda.on(Person.class).toString(), Matchers.equalTo(val))));
        }

        return drivers;
    }
}
