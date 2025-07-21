package org.automation.pom.pages;

import org.automation.pom.base.BasePage;
import org.automation.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By usernameInput = By.cssSelector("input[placeholder='Username']");
    private By passwordInput = By.cssSelector("input[placeholder='Password']");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By requiredMessage = By.xpath("//span[text()='Required']");
    private By errorMessage =  By.xpath("//p[text()='Invalid credentials']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LoginPage waitPageToLoad() {
        findVisible(usernameInput);
        return this;
    }

    @Override
    public LoginPage verifyPage() {
        softAssert.assertTrue(findVisible(usernameInput).isDisplayed(),"campo username no ha sido cargado " +
                "correctamenye");
        softAssert.assertTrue(findVisible(passwordInput).isDisplayed(), "campo password no ha sido cargado " +
                "correctamente");
        softAssert.assertTrue(findClick(loginButton).isDisplayed(),"boton de login no ha sido cargado correctamente");
        softAssert.assertAll();
        return this;
    }

    public LoginPage load(){
        load("/");
        return this;
    }

    public LoginPage enterUsername(String username){
        WebElement e = findVisible(usernameInput);
        e.clear();
        e.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        WebElement e = findVisible(passwordInput);
        e.clear();
        e.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        findVisible(loginButton).click();
        return this;
    }

    public DashboardPage login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage(driver);
    }

    public String getRequiredMessage(){
        return findVisible(requiredMessage).getText();
    }

    public String getErrorMessage(){
        return findVisible(errorMessage).getText();
    }

}
