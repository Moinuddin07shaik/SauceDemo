package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BackHomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "back-to-products")
    WebElement backHomeBtn;

    public BackHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickBackHome() {
        wait.until(ExpectedConditions.elementToBeClickable(backHomeBtn));
        backHomeBtn.click();
    }
}