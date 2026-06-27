package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilities.DataProviders;

public class ViewCartTest extends BaseClass
{
	
	
    @Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void view(String username, String password) throws Exception
    {
        LoginPage lt = new LoginPage(getDriver(), getWait());
        lt.login(username, password);
        

        log.info("====== user is on login page ======");

       
        log.info("Login successful");

        AddCartPage ad = new AddCartPage(getDriver(), getWait());

        log.info("====== add item to cart ViewCart ==========");

        ad.add();

        Assert.assertTrue(
        		getDriver().getCurrentUrl().contains("cart.html"),
                "Cart page not opened");

        log.info("Cart page opened successfully");

        ViewCartPage vcp = new ViewCartPage(getDriver(), getWait());

        vcp.clickCheckout();

        Assert.assertTrue(
        		getDriver().getCurrentUrl().contains("checkout-step-one.html"),
                "Checkout page not opened");

        log.info("Checkout page details opened successfully");
    }
}