package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCartPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addcart;

    @FindBy(id = "shopping_cart_container")
    WebElement viewcart;

    public AddCartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void add() {

        wait.until(ExpectedConditions.elementToBeClickable(addcart));
        addcart.click();
        System.out.println("Product added to cart");

        wait.until(ExpectedConditions.elementToBeClickable(viewcart));
        viewcart.click();

        wait.until(ExpectedConditions.urlContains("cart.html"));

        System.out.println("Navigated to cart page: " + driver.getCurrentUrl());
    }
}