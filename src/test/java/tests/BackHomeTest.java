package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.BackHomePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilities.DataProviders;

public class BackHomeTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void endToEndCheckoutTest(String username, String password) throws Exception {


        LoginPage loginPage = new LoginPage(getDriver());

        AddCartPage addCartPage = new AddCartPage(getDriver());

        ViewCartPage viewCartPage = new ViewCartPage(getDriver());

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());

        CheckoutOverviewPage overview =
                new CheckoutOverviewPage(getDriver());

        BackHomePage backHomePage = new BackHomePage(getDriver());


        log.info("User login started");


        loginPage.login(username, password);


        Assert.assertTrue(
                getDriver().getCurrentUrl().contains("inventory.html"),
                "Login failed for user: " + username
        );


        log.info("Adding product to cart");


        addCartPage.addProductToCart();


        log.info("Navigating to cart and checkout");


        viewCartPage.clickCheckout();


        checkoutPage.checkoutInfo(
                "Srinu",
                "Kumar",
                "500072"
        );


		Assert.assertEquals(
				overview.getProductName(),
                "Sauce Labs Backpack"
        );


        Assert.assertEquals(
        		overview.getProductPrice(),
                "$29.99"
        );


        Assert.assertEquals(
        		overview.getPaymentInfo(),
                "SauceCard #31337"
        );


        log.info("Order summary validated");


        overview.clickFinish();


        Assert.assertEquals(
        		overview.getSuccessMessage(),
                "Thank you for your order!"
        );


        log.info("Order placed successfully");


        backHomePage.clickBackHome();


        Assert.assertTrue(
                getDriver().getCurrentUrl().contains("inventory.html"),
                "User not navigated back to home page"
        );


        log.info("User successfully returned to home page");
    }
}