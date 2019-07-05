package com.capital.test;

import com.capital.manager.DriverManager;
import com.capital.pageobject.AuthForm;
import com.capital.pageobject.CapitalHome;
import com.capital.pageobject.CapitalTradingPlatform;
import com.capital.pageobject.DepositForm;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DepositMessageTest {

    private CapitalHome capitalHome; 
    private AuthForm authForm;
    private CapitalTradingPlatform capitalTradingPlatform;
    private DepositForm depositForm;

    private static final String depositMoney = "100";

    @BeforeTest
    public void setup() {
        WebDriver webDriver = DriverManager.getDriver(); 
        capitalHome = new CapitalHome(webDriver);
        authForm = new AuthForm(webDriver);
        capitalTradingPlatform = new CapitalTradingPlatform(webDriver);
        depositForm = new DepositForm(webDriver);
    }

    @Test
    public void depositMessageTest() {

        DriverManager.getDriver().get("link"); 

        capitalHome.clickLoginButton(); 
        authForm.fillOutForm();
        authForm.login();
        capitalTradingPlatform.clickButtonDeposit();
        depositForm.depositMoney(depositMoney);

        Assert.assertEquals(depositForm.getTransactionMessage(),  
                "Thank you\n$" + depositMoney + " successfully deposited");        
    }

    @AfterTest
    public void finalization() {  
        DriverManager.closeDriver();
    }
}