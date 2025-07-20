package org.automation.pom.base;

import org.automation.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected WebDriverWait waitLong;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        waitLong = new WebDriverWait(driver,Duration.ofSeconds(15));
        softAssert = new SoftAssert();
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl()+endPoint);
    }

    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    public abstract void waitPageToLoad();
    public abstract void verifyPage();

}
