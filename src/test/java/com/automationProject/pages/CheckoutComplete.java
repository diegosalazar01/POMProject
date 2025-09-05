package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutComplete {

    private WebDriver driver;

    private By thankYouMessage = By.className("complete-header");
    private By orderMessage = By.className("complete-text");

    public CheckoutComplete(WebDriver driver) {
        this.driver = driver;
    }

    public String getThankYouMessage() {
        WebElement thankYouMessageElement = driver.findElement(thankYouMessage);
        return thankYouMessageElement.getText();

    }

    public String getOrderMessage(){
        WebElement orderMessageElement = driver.findElement(orderMessage);
        return orderMessageElement.getText();
    }
}
