package com.automationProject.tests;

import com.automationProject.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveElementsTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", 3},
                {"locked_out_user", "secret_sauce", 3},
                {"problem_user", "secret_sauce", 3},
                {"performance_glitch_user", "secret_sauce", 3},
                {"error_user", "secret_sauce", 3},
                {"visual_user", "secret_sauce", 3}
        };
    }

    @Test(dataProvider = "loginData")
    public void removeElementsTest(String username, String password, int numberOfClicks) {
        loginPage.goToLoginPage();
        loginPage.loginValidUser(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        homePage.clickRandomAddToCartButton(numberOfClicks);
        homePage.navigateToCartPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        cartPage.removeFromCart();
        Assert.assertTrue(cartPage.cartIsEmpty(), "Cart is not empty after removing items");
    }
}
