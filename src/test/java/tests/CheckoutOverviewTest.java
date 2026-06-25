package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilites.ConfigReader;

public class CheckoutOverviewTest extends BaseClass
{
	@Test
	public void CheckoutOverview() throws Exception
	{
	    LoginPage lp = new LoginPage(driver);
	    ConfigReader config = new ConfigReader();

	    lp.login(config.username(), config.password());

	    AddCartPage ap = new AddCartPage(driver);
	    ap.add();

	    ViewCartPage vp = new ViewCartPage(driver);
	    vp.clickCheckout();

	    CheckoutPage cp = new CheckoutPage(driver);
	    cp.checkoutInfo("Srinu", "Kumar", "500072");

	    CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);

	    Assert.assertEquals(cop.getProductName(), "Sauce Labs Backpack");
	    Assert.assertEquals(cop.getProductPrice(), "$29.99");
	    Assert.assertEquals(cop.getPaymentInfo(), "SauceCard #31337");

	    System.out.println("Product Name : " + cop.getProductName());
	    System.out.println("Product Price : " + cop.getProductPrice());
	    System.out.println("Payment Info : " + cop.getPaymentInfo());
	    System.out.println("Total Price : " + cop.getTotalPrice());

	    cop.clickFinish();

	    // Success Message Verification
	    String actualMessage = cop.getSuccessMessage();

	    System.out.println("Order Status : " + actualMessage);

	    Assert.assertEquals(actualMessage,
	            "Thank you for your order!");

	    log.info("Order Placed Successfully");
	}
}
