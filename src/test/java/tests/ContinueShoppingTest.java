package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.ContinueShoppingPage;
import pages.LoginPage;
import utilites.ConfigReader;

public class ContinueShoppingTest extends BaseClass
{

	@Test
	public void login() throws Exception
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

		ContinueShoppingPage cp = new ContinueShoppingPage(driver);

		// Step 1: Add first product (already done in login flow or previous page)
		cp.shopAndPrintProducts();

		Assert.assertTrue(
				driver.getCurrentUrl().contains("cart.html"),
				"Cart page not opened"
				);

		log.info("Continue shopping flow completed successfully");
	}



}
