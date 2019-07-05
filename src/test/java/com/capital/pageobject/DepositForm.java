package com.capital.pageobject;

import com.capital.pageobject.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositForm extends BasePage {

    @FindBy(xpath = "//amount-input-number/input")
    private WebElement depositField;

    @FindBy(className = "btn-continue")
    private WebElement depositButton;

    @FindBy(className = "deposit-application__title")
    private WebElement transactionTitle;

    public DepositForm(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void depositMoney(String amount) {
        depositField.clear();
        depositField.sendKeys(amount);
        depositButton.click();
    }

    public String getTransactionMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(transactionTitle));
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(transactionTitle,
                "deposit processing…\nPlease wait – we are processing your payment. This process can take up to 30 seconds")));

        System.out.println("Transaction Title: " + transactionTitle.getText().replace("\n", " "));
        return transactionTitle.getText();
    }
}