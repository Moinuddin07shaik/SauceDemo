package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleAddCartPage
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addcart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement blacklight;

    @FindBy(className = "shopping_cart_link")
    WebElement viewcart;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public MultipleAddCartPage(WebDriver driver,WebDriverWait wait)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void add()
    {
        wait.until(ExpectedConditions.elementToBeClickable(addcart));
        addcart.click();

        System.out.println("After Backpack = " + cartBadge.getText());

        wait.until(ExpectedConditions.visibilityOf(blacklight));
        wait.until(ExpectedConditions.elementToBeClickable(blacklight));
        blacklight.click();

        System.out.println("After Bike Light = " + cartBadge.getText());
    }

    public String getCartCount()
    {
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        return cartBadge.getText();
    }

    public void openCart() throws InterruptedException
    {
    	Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(viewcart));
        viewcart.click();
        
        Thread.sleep(3000);

        wait.until(ExpectedConditions.urlContains("cart.html"));
    }
}