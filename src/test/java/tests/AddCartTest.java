package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import utilities.DataProviders;

public class AddCartTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void addToCartTest(String username, String password) {


        LoginPage loginPage = new LoginPage(getDriver());

        AddCartPage addCartPage = new AddCartPage(getDriver());


        log.info("User is on Login Page");


        loginPage.login(username, password);


        log.info("Login attempted with user: " + username);


        Assert.assertTrue(
                getDriver().getCurrentUrl().contains("inventory.html"),
                "Login failed for user: " + username
        );


        log.info("User is on Inventory Page - Starting Add to Cart flow");


        addCartPage.addProductToCart();


        log.info("Item added and cart opened successfully");
    }
}