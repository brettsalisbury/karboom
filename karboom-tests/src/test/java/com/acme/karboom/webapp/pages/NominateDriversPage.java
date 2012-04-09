package com.acme.karboom.webapp.pages;

import ch.lambdaj.Lambda;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 31/03/12
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class NominateDriversPage {

    private WebElement header;
    private WebDriver driver;
    private WebElement currentDrivers;
    private WebElement nominateDrivers;

    public NominateDriversPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return header.getText();
    }

    public void nominatePersonAsDriver(String driver) {
        nominateDrivers.findElement(By.name(driver)).findElement(By.id("nominateDriver")).click();
        nominateDrivers.submit();
    }


    public Collection<String> getDrivers() {
        return Lambda.extractProperty(currentDrivers.findElements(By.tagName("tr")), "text");
    }
}
