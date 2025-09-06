package com.automationProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(id ="checkout")
    private WebElement checkoutButton;
    @FindBy(className = "cart_button")
    private List<WebElement> removeButtons;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToCheckoutStepOnePage() {
        checkoutButton.click();
    }

    public void removeFromCart() {
        for (WebElement removeButton : removeButtons) {
            removeButton.click();
        }
    }

    public boolean cartIsEmpty() {
        return removeButtons.isEmpty();
    }

}
