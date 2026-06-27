package tests;

import org.testng.Assert;
import org.testng.annotations.Test;



import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import utilities.DataProviders;


public class AddCartTest extends BaseClass
{

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void login(String username, String password) throws Exception 
	{
		LoginPage lt = new LoginPage(getDriver(), getWait());


		log.info("====== User is on Login Page ======");

		lt.login(username, password);
		
		Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"));

		log.info("Login attempted with user: " + username);
		log.info("==== user is in Home Screen ---- AddCartTest =====");

		AddCartPage ad = new AddCartPage(getDriver(), getWait());
		ad.add();

		
		log.info("items is displayed in after view Cart ---- AddCartTest");

	}

}
