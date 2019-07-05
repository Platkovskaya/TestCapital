package com.capital.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
 

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe"); 

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            chromeOptions.addArguments("disable-infobars");

            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void closeDriver() {  
        driver.close();
    }
}