package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilities.DataProviders;

public class LoginTest extends BaseClass {



	@Test(dataProvider = "loginData",  dataProviderClass = DataProviders.class)
	public void login(String username, String password) throws InterruptedException {

		LoginPage lp = new LoginPage(getDriver(), getWait());
		log.info("====== User is on Login Page ======");

		lp.login(username, password);

		log.info("Login attempted with user: " + username);
		
		Assert.assertTrue(getDriver().getCurrentUrl().contains("inventory"));
	}
}