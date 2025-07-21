package org.automation.pom.base;

import org.automation.pom.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public abstract class BasePage <T extends BasePage<T>> {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        softAssert = new SoftAssert();
    }

    public void load(String endPoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl()+endPoint);
    }

    public WebElement findVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findClick(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public abstract T waitPageToLoad();
    public abstract T verifyPage();

}
