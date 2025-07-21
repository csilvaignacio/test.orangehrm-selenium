package org.automation.pom.base;

import org.automation.pom.factory.DriverManager;
import org.automation.pom.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected SoftAssert softAssert;

    protected void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void startDriver(@Optional("CHROME") String browser){
        browser = System.getProperty("browser",browser);
        setDriver(new DriverManager().initializeDriver(browser));
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() throws InterruptedException {
        Thread.sleep(100);
        getDriver().quit();
    }
}
