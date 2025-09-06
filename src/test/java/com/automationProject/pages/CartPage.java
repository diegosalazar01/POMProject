package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    private By checkoutButton =  By.id("checkout");
    private By removeButton =  By.className("cart_button");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCheckoutStepOnePage() {
        WebElement navigateButton = driver.findElement(checkoutButton);
        navigateButton.click();
    }

    public void removeFromCart() {
        List<WebElement> removeButtons = driver.findElements(removeButton);

        for (int i = 0; i < removeButtons.size(); i++) {
            WebElement removeButtonElement = removeButtons.get(i);
            removeButtonElement.click();
        }
    }

    public boolean cartIsEmpty() {
        List<WebElement> removeButtonElement = driver.findElements(removeButton);
        return removeButtonElement.isEmpty();
    }

}
