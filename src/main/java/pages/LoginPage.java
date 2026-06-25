package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class LoginPage 
{

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id="user-name") WebElement unname;
	@FindBy(id="password") WebElement paass;
	@FindBy(id="login-button") WebElement loginbtn;

	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public void login(String uname,String pass)
	{
		wait.until(ExpectedConditions.visibilityOf(unname));
		unname.sendKeys(uname);

		wait.until(ExpectedConditions.visibilityOf(paass));
		paass.sendKeys(pass);

		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();

	}


}
