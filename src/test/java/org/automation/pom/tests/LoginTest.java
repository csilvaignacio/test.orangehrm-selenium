package org.automation.pom.tests;

import org.automation.pom.base.BaseTest;
import org.automation.pom.pages.DashboardPage;
import org.automation.pom.pages.LoginPage;
import org.automation.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Verify succesful login whit valid credentials")
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(getDriver())
                .load()
                .enterUsername(ConfigLoader.getInstance().getUsername())
                .enterPassword(ConfigLoader.getInstance().getPassword());

        DashboardPage dashboardPage = loginPage.clickLoginButton();

        dashboardPage.waitPageToLoad();

        Assert.assertTrue(getDriver().getCurrentUrl().contains("/dashboard"));
        Assert.assertTrue(getDriver().getCurrentUrl().contains(ConfigLoader.getInstance().getDashboardUrl()));
        Assert.assertTrue(dashboardPage.verifySideMenuIsDisplayed());

        //prueba
    }


}
