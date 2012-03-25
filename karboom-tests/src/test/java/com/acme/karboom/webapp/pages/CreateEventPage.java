package com.acme.karboom.webapp.pages;

import ch.lambdaj.Lambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 24/03/12
 * Time: 1:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreateEventPage {

    private WebElement firstname;
    private WebElement surname;
    private WebElement currentNames;
    private WebDriver driver;

    public CreateEventPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addName(String firstName, String lastName) {
        this.firstname.sendKeys(firstName);
        this.surname.sendKeys(lastName);
        this.firstname.submit();
    }

    public Collection<String> getEventAttendees() {
        return Lambda.extractProperty(currentNames.findElements(By.tagName("tr")), "text");
    }
}
