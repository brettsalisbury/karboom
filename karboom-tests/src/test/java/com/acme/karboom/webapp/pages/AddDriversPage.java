package com.acme.karboom.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 31/03/12
 * Time: 5:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class AddDriversPage {

    private WebElement header;
    private WebDriver driver;

    public AddDriversPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return header.getText();
    }
}
