package com.automationProject.tests;

import com.automationProject.pages.CartPage;
import com.automationProject.pages.HomePage;
import com.automationProject.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RemoveElementsTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;

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

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
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
        cartPage.cartIsEmpty();
        Assert.assertTrue(cartPage.cartIsEmpty(), "Cart is not empty after removing items");

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
