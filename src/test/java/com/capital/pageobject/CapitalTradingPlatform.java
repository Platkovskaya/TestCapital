package com.capital.pageobject;

import com.capital.pageobject.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CapitalTradingPlatform extends BasePage {

    @FindBy(xpath = "//icon-button2[4]")
    private WebElement depositButton;

    public CapitalTradingPlatform(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void clickButtonDeposit(){

        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 60);  
        webDriverWait.until(ExpectedConditions.visibilityOf(depositButton));

        depositButton.click();
    }
}