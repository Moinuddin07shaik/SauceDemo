package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionUtils;

public class AddCartPage {

    WebDriver driver;
    ActionUtils action;

    public AddCartPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addCartBtn;

    @FindBy(id = "shopping_cart_container")
    WebElement viewCartBtn;

    public void addProductToCart() {

        action.click(addCartBtn);
        action.click(viewCartBtn);

        action.waitUrlContains("cart.html");

        System.out.println("Navigated to cart page: " + driver.getCurrentUrl());
    }

	
}