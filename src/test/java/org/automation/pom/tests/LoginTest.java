package org.automation.pom.tests;

import org.automation.pom.base.BaseTest;
import org.automation.pom.pages.LoginPage;
import org.automation.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test(description = "Verify succesful login whit valid credentials")
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(getDriver())
                .load()
                .waitPageToLoad()
                .verifyPage()
                .enterUsername(ConfigLoader.getInstance().getUsername())
                .enterPassword(ConfigLoader.getInstance().getPassword())
                .clickLoginButton();


        Assert.assertTrue(getDriver().getCurrentUrl().contains("/dashboard"));
    }

    @Test(description = "Verificar login invalido con usuario invalido")
    public void loginWithUserInvalid(){
        LoginPage loginPage = new LoginPage(getDriver())
                .load()
                .enterUsername(ConfigLoader.getInstance().getInvalidUsername())
                .enterUsername(ConfigLoader.getInstance().getPassword())
                .clickLoginButton();

        Assert.assertTrue(loginPage.getErrorMessage(),);

    }
}
