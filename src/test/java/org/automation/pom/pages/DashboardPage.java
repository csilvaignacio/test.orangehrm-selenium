package org.automation.pom.pages;

import org.automation.pom.base.BasePage;
import org.automation.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    By sideMenu = By.cssSelector("nav[aria-label='Sidepanel']");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public DashboardPage waitPageToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu));
        return this;
    }

    @Override
    public DashboardPage verifyPage() {
        softAssert.assertTrue(findVisible(sideMenu).isDisplayed());
        softAssert.assertAll();
        return this;
    }

    public DashboardPage load(){
        load(ConfigLoader.getInstance().getDashboardUrl());
        return this;
    }

    public boolean verifySideMenuIsDisplayed(){
        try {
            WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(sideMenu));
            return menu.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

}
