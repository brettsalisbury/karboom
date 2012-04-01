package com.acme.karboom.webapp.tests;

import com.acme.karboom.webapp.pages.AddDriversPage;
import com.acme.karboom.webapp.pages.CreateEventPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

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

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/karboom-webapp/createEvent");
        createEventPage = PageFactory.initElements(driver, CreateEventPage.class);
    }

    @Test
    public void shouldBeAbleToNavigateToSiteAndAddAUser() {

        createANewEventAndAddAttendees();
        nominateDriversAndAddDetails();
    }

    private void nominateDriversAndAddDetails() {
        addDriverToEvent("Eric", "Idle");
        addDriverToEvent("John", "Cleese");
    }

    private void addDriverToEvent(String firstName, String surname) {
        // given

        // when
        createEventPage.addName(firstName, surname);

        // then
        String actualName = String.format("%s %s", firstName, surname);
        assertTrue(createEventPage.getEventAttendees().contains(actualName));
    }

    private void createANewEventAndAddAttendees() {
        // given

        // when
        AddDriversPage page = createEventPage.moveToNextPage();

        // then
        assertTrue(page.getTitle().contains("drivers"));
    }

    @After
    public void closeDown() {
        this.driver.close();
    }
}
