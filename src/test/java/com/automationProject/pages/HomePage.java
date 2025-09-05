package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class HomePage {
    private WebDriver driver;

    private By addToCartButton = By.className("btn_inventory");
    private By cartButton = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRandomAddToCartButton(int numberOfClicks) {
        Random random = new Random();

        for (int i = 0; i < numberOfClicks; i++) {
            List<WebElement> addToCart = driver.findElements(addToCartButton);

            if (addToCart.size() <= 1) {
                System.out.println("No hay suficientes botones: Add to Cart");
                return;
            }

            int index = 1 + random.nextInt(addToCart.size() - 1);
            WebElement button = addToCart.get(index);

            button.click();
        }
    }

    public void navigateToCartPage() {
        WebElement navigateButton = driver.findElement(cartButton);
        navigateButton.click();
    }
}
