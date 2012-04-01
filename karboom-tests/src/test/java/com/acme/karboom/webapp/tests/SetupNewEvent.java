package com.acme.karboom.webapp.tests;

import com.acme.karboom.webapp.pages.AddDriversPage;
import com.acme.karboom.webapp.pages.CreateEventPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 24/03/12
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetupNewEvent {

    private WebDriver driver;
    private CreateEventPage createEventPage;
    private List<String> attendees;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/karboom-webapp/createEvent");
        createEventPage = PageFactory.initElements(driver, CreateEventPage.class);
        attendees = Arrays.asList("Eric Idle", "John Cleese");
    }

    @Test
    public void shouldBeAbleToNavigateToSiteAndAddAUser() {

        createANewEventAndAddAttendees();
        nominateDriversAndAddDetails();
    }

    private void createANewEventAndAddAttendees() {
        for (String attendee : attendees) {
            addDriverToEvent(attendee);
        }
        moveFromNewEventToDriversPage();
    }

    private void addDriverToEvent(String name) {
        // given

        // when
        createEventPage.addName(name);

        // then
        assertTrue(createEventPage.getEventAttendees().contains(name));
    }

    private void moveFromNewEventToDriversPage() {
        // given

        // when
        AddDriversPage page = createEventPage.moveToNextPage();

        // then
        assertTrue(page.getTitle().contains("drivers"));
    }

    private void nominateDriversAndAddDetails() {

    }

    @After
    public void closeDown() {
        this.driver.close();
    }
}
