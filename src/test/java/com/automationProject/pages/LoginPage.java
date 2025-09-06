package com.automationProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    protected WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    private final String loginUrl = "https://www.saucedemo.com/";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage(){
        driver.get(loginUrl);
    }

    public void loginValidUser(String username, String password) {
        userName.sendKeys(username);
        userPassword.sendKeys(password);
        loginButton.click();
    }


}
