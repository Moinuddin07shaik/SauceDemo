package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ActionUtils;

public class MultipleAddCartPage {

    WebDriver driver;
    ActionUtils action;

    private static final int PRODUCT_COUNT = 2;

    private By cartBadge = By.className("shopping_cart_badge");

    public MultipleAddCartPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement backpackBtn;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement bikeLightBtn;

    @FindBy(className = "shopping_cart_link")
    WebElement viewCartBtn;

    // STEP 1
    public void addBackpack() {
        action.click(backpackBtn);
        action.waitForCartCountToBe(cartBadge, 1);
        System.out.println("After Backpack = " + getCartCount());
    }

    // STEP 2
    public void addBikeLight() {
        action.click(bikeLightBtn);
        action.waitForCartCountToBe(cartBadge, PRODUCT_COUNT);
        System.out.println("After Bike Light = " + getCartCount());
    }

    // SAFE GETTER
    public int getCartCount() {
        String text = driver.findElement(cartBadge).getText();
        return text.isEmpty() ? 0 : Integer.parseInt(text);
    }

    public void openCart() {
        action.click(viewCartBtn);
        action.waitUrlContains("cart.html");
    }
}