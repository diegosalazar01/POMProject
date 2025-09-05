package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutStepOne {

    private WebDriver driver;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By zipCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public CheckoutStepOne(WebDriver driver) {
        this.driver = driver;
    }

    public void fillInformationForm(String firstName, String lastName, String zipCode) {
        WebElement firstNameFieldElement = driver.findElement(firstNameField);
        firstNameFieldElement.sendKeys(firstName);
        WebElement lastNameFieldElement = driver.findElement(lastNameField);
        lastNameFieldElement.sendKeys(lastName);
        WebElement zipCodeFieldElement = driver.findElement(zipCodeField);
        zipCodeFieldElement.sendKeys(zipCode);
    }

    public void navigateToCheckoutStepTwoPage() {
        WebElement continueButtonElement = driver.findElement(continueButton);
        continueButtonElement.click();
    }


}
