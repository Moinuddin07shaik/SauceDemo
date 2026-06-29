package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilities.DataProviders;

public class CheckoutOverviewTest extends BaseClass
{
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void CheckoutOverview(String username, String password) throws Exception
	{
		LoginPage lp = new LoginPage(getDriver());
		lp.login(username, password);


		AddCartPage acp = new AddCartPage(getDriver());
		acp.addProductToCart();;

		ViewCartPage vp = new ViewCartPage(getDriver());
		vp.clickCheckout();

		CheckoutPage cp = new CheckoutPage(getDriver());
		cp.checkoutInfo("Srinu", "Kumar", "500072");

		log.info(" ======== Checkout overview page is displayed ========== ");

		CheckoutOverviewPage cop = new CheckoutOverviewPage(getDriver());

		Assert.assertEquals(cop.getProductName(), "Sauce Labs Backpack");
		Assert.assertEquals(cop.getProductPrice(), "$29.99");
		Assert.assertEquals(cop.getPaymentInfo(), "SauceCard #31337");

		System.out.println("Product Name : " + cop.getProductName());
		System.out.println("Product Price : " + cop.getProductPrice());
		System.out.println("Payment Info : " + cop.getPaymentInfo());
	//	System.out.println("Total Price : " + cop.getTotalPrice());

		cop.clickFinish();

		log.info(" ======== Checkout overview page is completed ========== ");

		// Success Message Verification
		String actualMessage = cop.getSuccessMessage();

		System.out.println("Order Status : " + actualMessage);

		Assert.assertEquals(actualMessage,
				"Thank you for your order!");

		log.info("Order Placed Successfully");
	}
}
