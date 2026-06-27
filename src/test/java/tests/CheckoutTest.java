package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ViewCartPage;
import utilities.DataProviders;

public class CheckoutTest extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void checkout(String username, String password) throws Exception {

		LoginPage lp = new LoginPage(getDriver(), getWait());
		lp.login(username, password);


		log.info("====== User is on Login Page ======");

		log.info("Login Successful");

		AddCartPage ap = new AddCartPage(getDriver(), getWait());
		ap.add();

		log.info("Product Added To Cart");

		ViewCartPage vp = new ViewCartPage(getDriver(), getWait());
		vp.clickCheckout();

		log.info("Checkout Button Clicked");

		CheckoutPage cp = new CheckoutPage(getDriver(), getWait());

		cp.checkoutInfo("Srinu", "Kumar", "500072");

		log.info("Checkout Information Entered");

		Assert.assertTrue(
				getDriver().getCurrentUrl().contains("checkout-step-two.html"),
				"Checkout Overview Page Not Opened");

		log.info("Checkout Overview Page Opened Successfully");
	}
}