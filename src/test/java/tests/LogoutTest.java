package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.BackHomePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.ViewCartPage;
import utilities.DataProviders;

public class LogoutTest extends BaseClass
{
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void CheckoutOverview(String username, String password) throws Exception
	{
	    LoginPage lp = new LoginPage(getDriver());
	    lp.login(username, password);

	    AddCartPage ap = new AddCartPage(getDriver());
	    ap.addProductToCart();;

	    ViewCartPage vp = new ViewCartPage(getDriver());
	    vp.clickCheckout();

	    CheckoutPage cp = new CheckoutPage(getDriver());
	    cp.checkoutInfo("Srinu", "Kumar", "500072");

	    CheckoutOverviewPage cop = new CheckoutOverviewPage(getDriver());
	    System.out.println("Current User : " + username);
	    System.out.println("Current URL  : " + getDriver().getCurrentUrl());
	    System.out.println("Page Source Contains Product : " +
	    		getDriver().getPageSource().contains("Sauce Labs Backpack"));


	    Assert.assertEquals(cop.getProductName(), "Sauce Labs Backpack");
	    Assert.assertEquals(cop.getProductPrice(), "$29.99");
	    Assert.assertEquals(cop.getPaymentInfo(), "SauceCard #31337");

	    System.out.println("Product Name : " + cop.getProductName());
	    System.out.println("Product Price : " + cop.getProductPrice());
	    System.out.println("Payment Info : " + cop.getPaymentInfo());
	   // System.out.println("Total Price : " + cop.getTotalPrice());

	    cop.clickFinish();

	    // Success Message Verification
	    String actualMessage = cop.getSuccessMessage();

	    System.out.println("Order Status : " + actualMessage);

	    Assert.assertEquals(actualMessage,
	            "Thank you for your order!");

	    log.info("Order Placed Successfully");
	    
	    BackHomePage bp = new BackHomePage(getDriver());

	    bp.clickBackHome();

	    Assert.assertTrue(
	    		getDriver().getCurrentUrl().contains("inventory.html"));

	    System.out.println("User navigated to Products Page");
	    
	    log.info("=======Click on menu icon ======");
	    
	    LogoutPage lp1 = new LogoutPage(getDriver(), getWait());

	    lp1.logout();
	    
	    log.info("======= User Should Navigated Back to Home Screeen ======");

	    Assert.assertTrue(
	    		getDriver().getCurrentUrl().contains("saucedemo.com"));

	    System.out.println("Logout Successful");
	}
}
