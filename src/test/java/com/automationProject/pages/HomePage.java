package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HomePage {
    private WebDriver driver;

    private By addToCartButton = By.className("btn_inventory");
    private By cartButton = By.className("shopping_cart_link");
    private By sidebarButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRandomAddToCartButton(int numberOfClicks) {
        List<WebElement> addToCartButtons = driver.findElements(addToCartButton);

        Random random = new Random();
        Set<Integer> usedIndexes = new HashSet<>();

        for (int i = 0; i < numberOfClicks; i++) {
            int randomIndex;
            do {
                randomIndex = random.nextInt(addToCartButtons.size());
            } while (usedIndexes.contains(randomIndex));

            usedIndexes.add(randomIndex);

            WebElement button = addToCartButtons.get(randomIndex);
            button.click();
        }
    }

    public void navigateToCartPage() {
        WebElement navigateButton = driver.findElement(cartButton);
        navigateButton.click();
    }

    public void clickSidebarButton() {
        WebElement sidebar = driver.findElement(sidebarButton);
        sidebar.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }
    public void clickLogoutButton() {
        WebElement logout = driver.findElement(logoutButton);
        logout.click();
    }
}
