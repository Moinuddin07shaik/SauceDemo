package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    public CheckoutPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void checkoutInfo(String fname, String lname, String zip) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(firstName));
        firstName.sendKeys(fname);

        lastName.sendKeys(lname);

        postalCode.sendKeys(zip);

        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
    }
}