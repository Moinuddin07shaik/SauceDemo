package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionUtils;

public class LoginPage {

    WebDriver driver;
    ActionUtils action;


    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.action = new ActionUtils(driver);

        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "user-name")
    WebElement username;


    @FindBy(id = "password")
    WebElement password;


    @FindBy(id = "login-button")
    WebElement loginBtn;


    public void login(String user, String pass) {

        action.sendKeys(username, user);

        action.sendKeys(password, pass);

        action.click(loginBtn);
    }
}