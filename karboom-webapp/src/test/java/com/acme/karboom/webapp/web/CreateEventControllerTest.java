package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.acmefireworks.Event;
import org.acmefireworks.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 17/03/12
 * Time: 6:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateEventControllerTest {

    private CreateEventController createEventController;
    private Event event;

    @Before
    public void setUp() {
        EventSpringService serviceEvent = new EventSpringService();
        this.createEventController = new CreateEventController(serviceEvent);
        this.event = serviceEvent;
    }

    @Test
    public void shouldReturnCreateEventViewFromControllerOnInitialPageLoad() {

        // Given
        String expectedViewName = "createEvent";
        ModelMap model = new ModelMap();

        // When
        String actualViewName = createEventController.getViewForPageLoad(model);

        // Then
        assertThat(actualViewName, is(CoreMatchers.equalTo(expectedViewName)));
    }

    @Test
    public void shouldCreateEmptyPersonInModelMap() {

        // Given
        Person expectedPerson = new Person();
        ModelMap model = new ModelMap();

        // When
        createEventController.getViewForPageLoad(model);

        // Then
        Assert.assertTrue(model.containsAttribute("person"));
        Person actualPerson = (Person) model.get("person");
        Assert.assertThat(actualPerson, is(CoreMatchers.equalTo(expectedPerson)));
    }

    @Test
    public void shouldReturnCreateEventViewFromControllerOnAddingANewPerson() {
        // Given
        String expectedViewName = "redirect:createEvent";

        // When
        String actualViewName = createEventController.getViewForFormSubmission(null, null);

        // Then
        assertThat(actualViewName, is(CoreMatchers.equalTo(expectedViewName)));
    }

    @Test
    public void shouldAddPersonToListOfPeopleAttendingEventOnFormSubmission() {
        // Given
        Person person = new Person("Eric", "Idle");

        // When
        createEventController.getViewForFormSubmission(person, null);

        // Then
        this.event.getPeopleAttendingEvent().contains(person);
    }

    @Test
    public void shouldReturnCurrentEventObjectFromSessionAsModelAttribute() {
        // Given
        Person expectedPerson = new Person("Eric", "Idle");
        this.event.addPersonToEvent(expectedPerson);
        ModelMap model = new ModelMap();

        // when
        createEventController.getViewForPageLoad(model);

        // then
        Assert.assertTrue(model.containsAttribute("peopleAttendingEvent"));
        Collection<Person> actualCollection = (Collection<Person>) model.get("peopleAttendingEvent");
        Assert.assertThat(actualCollection.size(), is(CoreMatchers.equalTo(1)));
        Assert.assertTrue(actualCollection.containsAll(Arrays.asList(expectedPerson.toString())));
    }

}
