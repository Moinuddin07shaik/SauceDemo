package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.MultipleAddCartPage;
import utilities.DataProviders;

public class MultipleAddCartTest extends BaseClass
{
	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void verifyMultipleAddCart(String username, String password) throws Exception
	{
		LoginPage lt = new LoginPage(getDriver(), getWait());


		log.info("====== user is on login page ======");


		lt.login(username, password);
		log.info("Login successful");

		log.info("==== user is in Home Screen ---- MultipleAddCartTest =====");

		MultipleAddCartPage mp = new MultipleAddCartPage(getDriver(), getWait());

		mp.add();

		String count = mp.getCartCount();
		System.out.println("Cart Count = " + count);

		Assert.assertEquals(count.trim(), "2");

		mp.openCart();

		log.info("Two Products Added Successfully");

	}
}