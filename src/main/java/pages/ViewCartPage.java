package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCartPage {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public ViewCartPage(WebDriver driver,WebDriverWait wait) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	public void clickCheckout() throws InterruptedException {

		wait.until(ExpectedConditions.urlContains("cart.html"));
		
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
		checkoutBtn.click();
		
		Thread.sleep(3000);

		wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));
	}
}