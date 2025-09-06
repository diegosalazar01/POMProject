package com.automationProject.tests;

import com.automationProject.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @Test(dataProvider = "loginData")
    public void logOutTest(String email, String password) {
        loginPage.goToLoginPage();
        loginPage.loginValidUser(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        homePage.clickSidebarButton();
        homePage.clickLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }
}
