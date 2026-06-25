package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContinueShoppingPage
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="continue-shopping")
    WebElement continueShopping;

    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement secondProduct;

    @FindBy(className="shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className="inventory_item_name")
    List<WebElement> cartProducts;

    public ContinueShoppingPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickContinueShopping()
    {
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
        continueShopping.click();
    }

    public void addSecondProduct()
    {
        wait.until(ExpectedConditions.elementToBeClickable(secondProduct));
        secondProduct.click();
    }

    public void openCart()
    {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }

    // ⭐ MAIN FLOW METHOD (UPDATED)
    public void shopAndPrintProducts()
    {
        clickContinueShopping();
        addSecondProduct();
        openCart();

        wait.until(ExpectedConditions.visibilityOfAllElements(cartProducts));

        System.out.println("===== CART PRODUCTS =====");

        for (WebElement product : cartProducts)
        {
            System.out.println(product.getText());
        }
    }
}