package com.automationProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    protected WebDriver driver;

    private By userName= By.id("user-name");
    private By userPassword= By.id("password");
    private By loginButton = By.id("login-button");


    private String loginUrl = "https://www.saucedemo.com/";


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage(){
        driver.get(loginUrl);
    }

    public void loginValidUser(String username, String password) {
        WebElement searchUsernameInput = driver.findElement(userName);
        searchUsernameInput.sendKeys(username);
        WebElement searchPasswordInput = driver.findElement(userPassword);
        searchPasswordInput.sendKeys(password);
        WebElement formButton = driver.findElement(loginButton);
        formButton.click();
    }


}
