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

public class BackHomeTest extends BaseClass
{
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void CheckoutOverview(String username, String password) throws Exception
	{
	    LoginPage lp = new LoginPage(getDriver(), getWait());
	    lp.login(username, password);
	    

	    AddCartPage ap = new AddCartPage(getDriver(), getWait());
	    ap.add();

	    ViewCartPage vp = new ViewCartPage(getDriver(), getWait());
	    vp.clickCheckout();

	    CheckoutPage cp = new CheckoutPage(getDriver(), getWait());
	    cp.checkoutInfo("Srinu", "Kumar", "500072");

	    CheckoutOverviewPage cop = new CheckoutOverviewPage(getDriver(), getWait());

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

	    log.info("Order Placed Successfully for prodcut .... Back Home page");
	    
	    BackHomePage bp = new BackHomePage(getDriver(), getWait());
	    
	    log.info(" ======= Navigating back to Home Screen Started =====");

	    bp.clickBackHome();
	    
	    log.info(" ======= Navigating back to Home Screen Started =====");

	    Assert.assertTrue(
	    	    getDriver().getCurrentUrl().contains("inventory.html")
	    	);

	    System.out.println("User navigated to Products Page");
	}
}
