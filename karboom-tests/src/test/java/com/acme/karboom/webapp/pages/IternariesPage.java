package com.acme.karboom.webapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by IntelliJ IDEA.
 * User: Brett
 * Date: 15/04/12
 * Time: 4:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class IternariesPage {

    private WebDriver driver;
    private WebElement header;

    public IternariesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return header.getText();
    }
}
