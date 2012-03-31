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
public class CreateNewEventTest {

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
        // given
        String expectedFirstName = "Eric";
        String expectedLastName = "Idle";

        // when
        createEventPage.addName(expectedFirstName, expectedLastName);

        // then
        String expectedNameAdded = String.format("%s %s", expectedFirstName, expectedLastName);
        assertTrue(createEventPage.getEventAttendees().contains(expectedNameAdded));

        // given
        String expectedFirstName2 = "John";
        String expectedLastName2 = "Cleese";

        // when
        createEventPage.addName(expectedFirstName2, expectedLastName2);

        // then
        String expectedNameAdded2 = String.format("%s %s", expectedFirstName2, expectedLastName2);
        assertTrue(createEventPage.getEventAttendees().contains(expectedNameAdded2));

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
