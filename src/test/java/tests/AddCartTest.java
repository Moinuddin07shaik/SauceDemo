package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import utilites.ConfigReader;

public class AddCartTest extends BaseClass
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
}
	
}
