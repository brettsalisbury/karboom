package com.acme.karboom.webapp.pages;

import ch.lambdaj.Lambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
    private WebElement nextPage;
    private WebDriver driver;

    public CreateEventPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addName(String name) {
        String[] splitNames = splitName(name);
        this.firstname.sendKeys(splitNames[0]);
        this.surname.sendKeys(splitNames[1]);
        this.firstname.submit();
    }

    private String[] splitName(String name) {
        return name.split(" ");
    }

    public Collection<String> getEventAttendees() {
        return Lambda.extractProperty(currentNames.findElements(By.tagName("tr")), "text");
    }

    public NominateDriversPage moveToNextPage() {
        this.nextPage.click();
        return PageFactory.initElements(driver, NominateDriversPage.class);
    }
}
