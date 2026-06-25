package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement addcart;
    
    @FindBy(id="shopping_cart_container")
    WebElement viewcart;

    public AddCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    public void add() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(addcart));
        addcart.click();
        
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(viewcart));
        viewcart.click();
        
        Thread.sleep(3000);

        wait.until(ExpectedConditions.urlContains("cart.html"));
    }
}