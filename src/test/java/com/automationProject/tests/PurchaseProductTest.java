package com.automationProject.tests;

import com.automationProject.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class PurchaseProductTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutStepOne checkoutStepOne;
    private CheckoutStepTwo checkoutStepTwo;
    private CheckoutComplete checkoutComplete;

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
        checkoutStepOne = new CheckoutStepOne(driver);
        checkoutStepTwo = new CheckoutStepTwo(driver);
        checkoutComplete = new CheckoutComplete(driver);
    }

    @Test(dataProvider = "loginData")
    public void PurchaseProductTest(String username, String password, int numberOfClicks, String firstName, String lastName, String zipCode ) {

        loginPage.goToLoginPage();
        loginPage.loginValidUser(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        homePage.clickRandomAddToCartButton(numberOfClicks);
        homePage.navigateToCartPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        cartPage.navigateToCheckoutStepOnePage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");

        checkoutStepOne.fillInformationForm(firstName,lastName,zipCode);
        checkoutStepOne.navigateToCheckoutStepTwoPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");

        checkoutStepTwo.navigateToCheckoutComplete();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");

        checkoutComplete.getThankYouMessage();
        Assert.assertEquals(checkoutComplete.getThankYouMessage(), "Thank you for your order!");
        checkoutComplete.getOrderMessage();
        Assert.assertEquals(checkoutComplete.getOrderMessage(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
           driver.quit();
       }
  }

}
