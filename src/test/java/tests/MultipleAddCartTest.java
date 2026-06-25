package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.MultipleAddCartPage;
import utilites.ConfigReader;

public class MultipleAddCartTest extends BaseClass
{
	@Test
	public void verifyMultipleAddCart() throws Exception
	{
	    LoginPage lt = new LoginPage(driver);
	    ConfigReader config = new ConfigReader();

	    log.info("====== user is on login page ======");

	    lt.login(config.username(), config.password());

	    log.info("Login successful");

	    MultipleAddCartPage mp = new MultipleAddCartPage(driver);

	    mp.add();

	    String count = mp.getCartCount();
	    System.out.println("Cart Count = " + count);

	    Assert.assertEquals(count.trim(), "2");

	    mp.openCart();

	    log.info("Two Products Added Successfully");
	}
}