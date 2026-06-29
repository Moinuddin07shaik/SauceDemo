package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionUtils;


public class CheckoutOverviewPage {


    WebDriver driver;
    ActionUtils action;


    public CheckoutOverviewPage(WebDriver driver){

        this.driver = driver;
        this.action = new ActionUtils(driver);

        PageFactory.initElements(driver, this);

    }


    @FindBy(className = "inventory_item_name")
    WebElement productName;


    @FindBy(className = "inventory_item_price")
    WebElement productPrice;


    @FindBy(className = "summary_value_label")
    WebElement paymentInfo;


    @FindBy(id="finish")
    WebElement finishBtn;


    @FindBy(className="complete-header")
    WebElement successMessage;



    public String getProductName(){

        return action.getText(productName);

    }



    public String getProductPrice(){

        return action.getText(productPrice);

    }



    public String getPaymentInfo(){

        return action.getText(paymentInfo);

    }



    public void clickFinish(){

        action.click(finishBtn);

    }



    public String getSuccessMessage(){

        return action.getText(successMessage);

    }

}