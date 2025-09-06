package com.automationProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HomePage {

    private WebDriver driver;

    @FindBy(className = "btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartButton;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement sidebarButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRandomAddToCartButton(int numberOfClicks) {
        Random random = new Random();
        Set<Integer> usedIndexes = new HashSet<>();

        for (int i = 0; i < numberOfClicks; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(addToCartButtons.size());
            } while (usedIndexes.contains(randomIndex));

            usedIndexes.add(randomIndex);
            addToCartButtons.get(randomIndex).click();
        }
    }

    public void navigateToCartPage() {
        cartButton.click();
    }

    public void clickSidebarButton() {
        sidebarButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }
}
