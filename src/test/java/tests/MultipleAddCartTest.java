package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.MultipleAddCartPage;
import utilities.DataProviders;

public class MultipleAddCartTest extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void verifyMultipleAddCart(String username, String password) {

	    WebDriver driver = getDriver();

	    LoginPage loginPage = new LoginPage(driver);
	    MultipleAddCartPage cartPage = new MultipleAddCartPage(driver);

	    log.info("====== Login Test Started ======");

	    loginPage.login(username, password);

	    log.info("Login attempted for user: " + username);

	    Assert.assertTrue(
	            driver.getCurrentUrl().contains("inventory.html"),
	            "Login failed for user: " + username +
	            " | Current URL: " + driver.getCurrentUrl()
	    );

	    log.info("Login successful - Inventory Page opened");

	    cartPage.addBackpack();
	    cartPage.addBikeLight();
	    int cartCount = cartPage.getCartCount();

	    log.info("Cart Count after adding products: " + cartCount);

	    Assert.assertEquals(
	            cartCount,
	            2,
	            "Cart count mismatch! Expected: 2 | Actual: " + cartCount
	    );
	    
	    cartPage.openCart();

	    Assert.assertTrue(
	            driver.getCurrentUrl().contains("cart.html"),
	            "Cart page not opened properly"
	    );

	    log.info("Cart opened successfully with 2 products");
	}
}