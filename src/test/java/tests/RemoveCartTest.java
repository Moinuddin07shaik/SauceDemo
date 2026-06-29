package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.AddCartPage;
import pages.LoginPage;
import pages.RemoveCartPage;
import utilities.DataProviders;


public class RemoveCartTest extends BaseClass
{
	

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void removeCartTest(String username, String password) throws Exception
	{
		LoginPage lp = new LoginPage(getDriver());
		lp.login(username, password);


		log.info("=========  Remove Cart items ============");

		AddCartPage ad = new AddCartPage(getDriver());
		ad.addProductToCart();

		Assert.assertTrue(
				getDriver().getCurrentUrl().contains("cart.html"),
				"Cart page not opened"
				);


		log.info("=======  removed exeution started ======= ");

		RemoveCartPage rm = new RemoveCartPage(getDriver(), getWait());
		rm.removeProduct();

		log.info(" ======== Product removed successfully =======");
	}
}