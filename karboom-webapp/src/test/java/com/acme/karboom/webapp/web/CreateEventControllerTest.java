package com.acme.karboom.webapp.web;

import com.acme.karboom.webapp.domainwrappers.EventSpringService;
import org.acmefireworks.Event;
import org.acmefireworks.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

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
    public void setUp()
    {
        EventSpringService serviceEvent = new EventSpringService();
        this.createEventController = new CreateEventController(serviceEvent);
        this.event = serviceEvent;
    }

    @Test
    public void shouldReturnCreateEventViewFromControllerOnInitialPageLoad()
    {
        // Given
        String expectedViewName = "createEvent";
        ModelMap model = new ModelMap();

        // When
        String actualViewName = createEventController.getViewForPageLoad(model);

        // Then
        assertThat(actualViewName, is(equalTo(expectedViewName)));
    }

    @Test
    public void shouldCreateEmptyPersonInModelMapOnInitialPageLoad()
    {
        // Given
        ModelMap model = new ModelMap();
        Person expectedPerson = new Person();

        // When
        String actualViewName = createEventController.getViewForPageLoad(model);

        // Then
        assertTrue(model.containsAttribute("person"));
        Assert.assertThat((Person) model.get("person"), is(CoreMatchers.equalTo(expectedPerson)));
    }

    @Test
    public void shouldReturnCreateEventViewFromControllerOnAddingANewPerson()
    {
        // Given
        String expectedViewName = "createEvent";

        // When
        ModelAndView actualModelAndView = createEventController.getViewForFormSubmission(null, null);

        // Then
        ModelAndViewAssert.assertViewName(actualModelAndView, expectedViewName);
    }

    @Test
    public void shouldAddAllPeopleToCreateEventViewOnAddingANewPerson()
    {
        // Given
        Person person = new Person("Eric", "Idle");
        Person expectedPerson = new Person();

        // When
        ModelAndView actualModelAndView = createEventController.getViewForFormSubmission(person, null);

        // Then
        ModelAndViewAssert.assertModelAttributeValue(actualModelAndView,"person",expectedPerson);
    }

    @Test
    public void shouldReturnCurrentEventObjectFromSessionAsModelAttribute()
    {
        // Given
        Person expectedPerson = new Person("Eric", "Idle");
        this.event.addPersonToEvent(expectedPerson);

        // when
        Collection<Person> returnedCollection = createEventController.getPeopleAttendingEvent();

        // then
        Assert.assertThat(returnedCollection.size(), is(CoreMatchers.equalTo(1)));
        Assert.assertTrue(returnedCollection.containsAll(Arrays.asList(expectedPerson)));
    }

}
