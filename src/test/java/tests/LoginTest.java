package tests;



import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utilites.ConfigReader;

public class LoginTest extends BaseClass
{
	@Test
	public void login()
	{

		LoginPage lt = new LoginPage(driver);
		ConfigReader config = new ConfigReader();
		//lt.login("standard_user","secret_sauce");
		log.info("====== user is on login page======");    	
		lt.login(config.username(),config.password());
		log.info("Login successful");


	}
}
