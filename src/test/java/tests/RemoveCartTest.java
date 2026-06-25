package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import pages.RemoveCartPage;
import utilites.ConfigReader;

public class RemoveCartTest extends BaseClass
{
    @Test
    public void removeCartTest() throws Exception
    {
        LoginPage lt = new LoginPage(driver);
        ConfigReader config = new ConfigReader();

        lt.login(config.username(), config.password());

        AddCartPage ad = new AddCartPage(driver);
        ad.add();

        Assert.assertTrue(
            driver.getCurrentUrl().contains("cart.html"),
            "Cart page not opened"
        );

        RemoveCartPage rm = new RemoveCartPage(driver);
        rm.removeProduct();

        log.info("Product removed successfully");
    }
}