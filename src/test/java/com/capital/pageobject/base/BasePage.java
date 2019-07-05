package com.capital.pageobject.base;

import org.openqa.selenium.WebDriver;
 
 
public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return this.driver;
    }
}