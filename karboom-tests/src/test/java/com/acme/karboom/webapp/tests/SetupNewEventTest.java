package com.acme.karboom.webapp.tests;

import com.acme.karboom.webapp.pages.CreateEventPage;
import com.acme.karboom.webapp.pages.IternariesPage;
import com.acme.karboom.webapp.pages.NominateDriversPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 24/03/12
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class SetupNewEventTest {

    private WebDriver driver;
    private CreateEventPage createEventPage;
    private List<String> attendees;
    private List<String> drivers;
    private NominateDriversPage nominateDriversPage;
    private IternariesPage itenariesPage;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/karboom-webapp/createEvent");
        createEventPage = PageFactory.initElements(driver, CreateEventPage.class);
        attendees = Arrays.asList("Eric Idle", "John Cleese");
        drivers = Arrays.asList("John Cleese");
    }

    @Test
    public void shouldBeAbleToNavigateToSiteAndAddAUser() {

        createANewEventAndAddAttendees();
        nominateDriversAndAddDetails();
        viewMapAndItenararies();
    }

    private void viewMapAndItenararies() {
        // given

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
        nominateDriversPage = createEventPage.moveToNextPage();

        // then
        assertTrue(nominateDriversPage.getTitle().contains("drivers"));
    }

    private void nominateDriversAndAddDetails() {
        for (String driver : drivers) {
            nominateAsDriver(driver);
        }
        moveFromDriversToIternariesPage();
    }

    private void moveFromDriversToIternariesPage() {
        // given

        // when
        itenariesPage = nominateDriversPage.moveToNextPage();

        // then
        assertTrue(itenariesPage.getTitle().contains("iternary"));
    }

    private void nominateAsDriver(String driver) {
        // given

        // when
        nominateDriversPage.nominatePersonAsDriver(driver);

        // then
        assertTrue("Driver is not displayed in list of drivers", nominateDriversPage.getDrivers().contains(driver));
        assertFalse("Driver is still present in list of non drivers", nominateDriversPage.getNonDrivers().contains(driver));
    }

    @After
    public void closeDown() {
        this.driver.close();
    }
}
