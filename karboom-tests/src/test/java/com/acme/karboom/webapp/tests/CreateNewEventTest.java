package com.acme.karboom.webapp.tests;

import com.acme.karboom.webapp.pages.CreateEventPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/karboom-webapp/createEvent");
        createEventPage = PageFactory.initElements(driver, CreateEventPage.class);
    }

    @Test
    public void shouldBeAbleToNavigateToSiteAndAddAUser()
    {
        // given
        String expectedFirstName = "Eric";
        String expectedLastName = "Idle";

        // when
        createEventPage.addName(expectedFirstName, expectedLastName);

        // then
        String expectedLastNameAdded = String.format("%s %s", expectedFirstName, expectedLastName);
        assertThat(createEventPage.getLastNameAdded(), is(equalTo(expectedLastNameAdded)));
    }

    @After
    public void closeDown()
    {
        this.driver.close();
    }
}
