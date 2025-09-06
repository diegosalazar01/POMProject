package com.automationProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutComplete {

    private WebDriver driver;

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

    @FindBy(className = "complete-text")
    private WebElement orderMessage;

    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getThankYouMessage() {
        return thankYouMessage.getText();
    }

    public String getOrderMessage() {
        return orderMessage.getText();
    }
}
