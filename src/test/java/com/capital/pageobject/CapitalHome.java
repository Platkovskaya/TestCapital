package com.capital.pageobject;

import com.capital.pageobject.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CapitalHome extends BasePage {

    @FindBy(id = "wg_loginBtn")
    private WebElement loginButton;

    public CapitalHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}