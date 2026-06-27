package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginbtn;

    public void login(String uname, String pass) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(uname);

        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pass);
        
        Thread.sleep(3000);

        wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
        loginbtn.click();
        
        Thread.sleep(3000);
    }
}