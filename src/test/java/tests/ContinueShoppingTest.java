package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.ContinueShoppingPage;
import pages.LoginPage;
import utilities.DataProviders;


public class ContinueShoppingTest extends BaseClass
{

	@Test(dataProvider = "loginData",dataProviderClass = DataProviders.class)
	public void login(String username, String password) throws Exception
	{
		LoginPage lt = new LoginPage(getDriver(), getWait());
		lt.login(username, password);

		
		log.info(" ======= Add to cart page this =========");

		AddCartPage ad = new AddCartPage(getDriver(), getWait());
		ad.add();

		Assert.assertTrue(
				getDriver().getCurrentUrl().contains("cart.html"),
				"Cart page not opened"
				);

		log.info("======== item add to cart and items views ======== ");
		
		
		ContinueShoppingPage cp = new ContinueShoppingPage(getDriver(), getWait());

		// Step 1: Add first product (already done in login flow or previous page)
		cp.shopAndPrintProducts();
		
		log.info(" ======== Continue shopping flow completed successfully started ======== ");

		Assert.assertTrue(
				getDriver().getCurrentUrl().contains("cart.html"),
				"Cart page not opened"
				);

		log.info("Continue shopping flow completed successfully");
	}



}
