package com.automationProject.tests;

import com.automationProject.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PurchaseProductTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", 2, "Diego", "Salazar", "110011"},
                {"locked_out_user", "secret_sauce", 3, "Ana", "Lopez", "220022"},
                {"problem_user", "secret_sauce", 1, "Juan", "Perez", "330033"},
                {"performance_glitch_user", "secret_sauce", 4, "Maria", "Gomez", "440044"},
                {"error_user", "secret_sauce", 2, "Carlos", "Martinez", "550055"},
                {"visual_user", "secret_sauce", 3, "Laura", "Fernandez", "660066"}
        };
    }

    @Test(dataProvider = "loginData")
    public void purchaseProductTest(String username, String password, int numberOfClicks,
                                    String firstName, String lastName, String zipCode) {

        loginPage.goToLoginPage();
        loginPage.loginValidUser(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        homePage.clickRandomAddToCartButton(numberOfClicks);
        homePage.navigateToCartPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        cartPage.navigateToCheckoutStepOnePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

        checkoutStepOne.fillInformationForm(firstName, lastName, zipCode);
        checkoutStepOne.navigateToCheckoutStepTwoPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

        checkoutStepTwo.navigateToCheckoutComplete();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");

        Assert.assertEquals(checkoutComplete.getThankYouMessage(), "Thank you for your order!");
        Assert.assertEquals(checkoutComplete.getOrderMessage(),
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
