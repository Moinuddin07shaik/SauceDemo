package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.DataProviders;

public class LoginTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void loginTest(String username, String password) {

        LoginPage loginPage = new LoginPage(getDriver());

        log.info("====== User is on Login Page ======");

        loginPage.login(username, password);

        log.info("Login attempted with user: " + username);

        String currentUrl = getDriver().getCurrentUrl();

        log.info("Current URL after login: " + currentUrl);


        Assert.assertTrue(
                currentUrl.contains("inventory.html"),
                "Login failed for user: " + username
        );


        log.info("Login successful for user: " + username);
    }
}