package org.automation.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.automation.pom.constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public WebDriver initializeDriver(String browser){
        WebDriver driver;

        switch (DriverType.valueOf(browser)){
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("drivers").setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--no-sandbox");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("drivers").setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--disable-notifications");
                firefoxOptions.addArguments("--no-sandbox");
                driver = new FirefoxDriver(firefoxOptions);
                driver.manage().window().maximize();
            }
            default -> throw new IllegalArgumentException("Browser inavalido: "+browser);
        }
        return driver;
    }

}
