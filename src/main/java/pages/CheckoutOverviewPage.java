package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutOverviewPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className="inventory_item_name")
    WebElement productName;

    @FindBy(className="inventory_item_price")
    WebElement productPrice;

    @FindBy(xpath="//div[text()='SauceCard #31337']")
    WebElement paymentInfo;

    @FindBy(className="summary_total_label")
    WebElement totalPrice;

    @FindBy(id="finish")
    WebElement finishBtn;
    
    @FindBy(className = "complete-header")
    WebElement successMessage;


    public CheckoutOverviewPage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public String getPaymentInfo() {
        return paymentInfo.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(successMessage));
        return successMessage.getText();
    }

    public void clickFinish() throws InterruptedException 
    {

        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
      
        
        getSuccessMessage();
    }
}