package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import com.acme.karboom.webapp.formobjects.NewDrivers;
import org.acmefireworks.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 31/03/12
 * Time: 5:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddDriversControllerTest {
    private AddDriversController addDriversController;
    private EventSpringService event;

    @Before
    public void setUp() throws Exception {
        EventSpringService event = new EventSpringService();
        this.addDriversController = new AddDriversController(event);
        this.event = event;
    }

    @Test
    public void shouldReturnCorrectViewName() {

        // given
        String expectedViewName = "addDrivers";
        ModelMap model = new ModelMap();

        // when
        String actualViewName = addDriversController.getViewForInitialPageLoad(model);

        // then
        assertThat(actualViewName, is(CoreMatchers.equalTo(expectedViewName)));
    }

    @Test
    public void shouldPlaceNewDriversIntoModelMapForPageLoad() {
        // given
        ModelMap model = new ModelMap();

        // when
        addDriversController.getViewForInitialPageLoad(model);

        // then
        assertTrue(model.containsAttribute("newDrivers"));
        NewDrivers actualNewDrivers = (NewDrivers) model.get("newDrivers");
        assertThat(actualNewDrivers, is(not(nullValue())));
    }

    @Test
    public void shouldPlaceNonDriversOnlyInListOfDrivers() {

        // given
        ModelMap model = new ModelMap();
        Person driver = new Person("Allan", "Border");
        Person nonDriver = new Person("Shane", "Warne");

        this.event.addPersonToEvent(driver);
        this.event.addPersonToEvent(nonDriver);
        this.event.addDriver(driver);

        // when
        addDriversController.getViewForInitialPageLoad(model);

        // then
        assertTrue(model.containsAttribute("nonDrivers"));
        Collection<String> nonDrivers = (Collection<String>) model.get("nonDrivers");
        assertThat(nonDrivers.size(), is(equalTo(1)));
        assertTrue(nonDrivers.containsAll(Arrays.asList(nonDriver.toString())));
    }

    @Test
    public void shouldPlaceCurrentDriversIntoModelMapForPageLoad() {
        // given
        ModelMap model = new ModelMap();
        Person expectedDriver = new Person("Eric", "Idle");
        this.event.addDriver(expectedDriver);

        // when
        addDriversController.getViewForInitialPageLoad(model);

        // then
        assertTrue(model.containsAttribute("nominatedDrivers"));
        Collection<String> actualNominatedDrivers = (Collection<String>) model.get("nominatedDrivers");
        Assert.assertThat(actualNominatedDrivers.size(), is(CoreMatchers.equalTo(1)));
        Assert.assertTrue(actualNominatedDrivers.containsAll(Arrays.asList(expectedDriver.toString())));
    }

    @Test
    public void shouldReturnAddDriverViewFromControllerOnAddingAllDrivers() {
        // given
        String expectedViewName = "redirect:addDrivers";

        // when
        String actualViewName = addDriversController.getViewForFormSubmission(new NewDrivers(), null);

        // then
        assertThat(expectedViewName, is(equalTo(actualViewName)));
    }

    @Test
    public void shouldPlaceDriversIntoListOfValidDrivers() {
        // given
        NewDrivers newDrivers = new NewDrivers();
        Person expectedDriver = new Person("John", "Cleese");
        Person nonDriver = new Person("Eric", "Idle");

        event.addPersonToEvent(expectedDriver);
        event.addPersonToEvent(nonDriver);

        newDrivers.setDrivers(new String[]{expectedDriver.toString()});

        // when
        addDriversController.getViewForFormSubmission(newDrivers, null);

        // then
        assertTrue(event.getDrivers().contains(expectedDriver));
        assertFalse(event.getDrivers().contains(nonDriver));
    }
}
