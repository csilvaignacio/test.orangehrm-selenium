package org.automation.pom.pages;

import org.automation.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    private By usernameInput = By.cssSelector("input[placeholder='Username']");
    private By passwordInput = By.cssSelector("input[placeholder='Password']");
    private By loginButton = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(usernameInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    public LoginPage load(){
        load("/");
        return this;
    }

    public LoginPage enterUsername(String username){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        e.clear();
        e.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        e.clear();
        e.sendKeys(password);
        return this;
    }

    public DashboardPage clickLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        return new DashboardPage(driver);
    }


}
