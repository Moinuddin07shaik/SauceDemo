package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveCartPage
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id="remove-sauce-labs-backpack")
    WebElement removeBtn;

    public RemoveCartPage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        PageFactory.initElements(driver, this);
    }

    public void removeProduct()
    {
        wait.until(ExpectedConditions.elementToBeClickable(removeBtn));
        removeBtn.click();
    }
}