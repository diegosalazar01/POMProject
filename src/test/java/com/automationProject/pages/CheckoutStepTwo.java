package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepTwo {

    private WebDriver driver;

    private By finishButton = By.id("finish");

    public CheckoutStepTwo(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCheckoutComplete() {
        WebElement finishButtonElement = driver.findElement(finishButton);
        finishButtonElement.click();
    }
}
