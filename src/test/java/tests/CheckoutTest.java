package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilites.ConfigReader;

public class CheckoutTest extends BaseClass {

    @Test
    public void checkout() throws Exception {

        LoginPage lp = new LoginPage(driver);
        ConfigReader config = new ConfigReader();

        log.info("====== User is on Login Page ======");

        lp.login(config.username(), config.password());

        log.info("Login Successful");

        AddCartPage ap = new AddCartPage(driver);
        ap.add();

        log.info("Product Added To Cart");

        ViewCartPage vp = new ViewCartPage(driver);
        vp.clickCheckout();

        log.info("Checkout Button Clicked");

        CheckoutPage cp = new CheckoutPage(driver);

        cp.checkoutInfo("Srinu", "Kumar", "500072");

        log.info("Checkout Information Entered");

        Assert.assertTrue(
                driver.getCurrentUrl().contains("checkout-step-two.html"),
                "Checkout Overview Page Not Opened");

        log.info("Checkout Overview Page Opened Successfully");
    }
}