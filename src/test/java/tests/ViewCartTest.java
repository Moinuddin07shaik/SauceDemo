package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilites.ConfigReader;

public class ViewCartTest extends BaseClass
{
    @Test
    public void view() throws Exception
    {
        LoginPage lt = new LoginPage(driver);
        ConfigReader config = new ConfigReader();

        log.info("====== user is on login page ======");

        lt.login(config.username(), config.password());

        log.info("Login successful");

        AddCartPage ad = new AddCartPage(driver);

        log.info("====== add item to cart ==========");

        ad.add();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart.html"),
                "Cart page not opened");

        log.info("Cart page opened successfully");

        ViewCartPage vcp = new ViewCartPage(driver);

        vcp.clickCheckout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-one.html"),
                "Checkout page not opened");

        log.info("Checkout page opened successfully");
    }
}