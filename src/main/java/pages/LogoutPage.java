package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutPage
{
    WebDriver driver;
    
    WebDriverWait wait;

    @FindBy(id="react-burger-menu-btn")
    WebElement menuBtn;

    @FindBy(id="logout_sidebar_link")
    WebElement logoutBtn;

    public LogoutPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void logout() throws InterruptedException
    {
        menuBtn.click();
        Thread.sleep(4000);
        logoutBtn.click();
    }
}