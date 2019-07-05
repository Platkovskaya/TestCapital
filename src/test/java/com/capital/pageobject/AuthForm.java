package com.capital.pageobject;

import com.capital.pageobject.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthForm extends BasePage {

    @FindBy(name = "email")       
    private WebElement emailField; 

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'l_btn')]")  
    private WebElement continueButton;

    public AuthForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);  
    }

    public void fillOutForm() {  
        emailField.clear();  
        emailField.sendKeys("email");  
        passwordField.clear();
        passwordField.sendKeys("password"); 
    }

    public void login() {  
        continueButton.click();
    }
}
