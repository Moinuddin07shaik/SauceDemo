package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionUtils {

    WebDriver driver;
    WebDriverWait wait;   // ✅ REUSABLE WAIT

    private static final int TIMEOUT = 10;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;

        if (driver == null) {
            throw new RuntimeException("Driver is null in ActionUtils");
        }

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    // ================= BASIC WAITS =================

    public void waitForElementToAppear(WebElement element) {
        try {
            wait.until(d -> {
                try {
                    return element.isDisplayed();
                } catch (Exception e) {
                    return false;
                }
            });
        } catch (Exception e) {
            throw new TimeoutException("Element not visible: " + element, e);
        }
    }

    public void waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            throw new TimeoutException("Element not clickable: " + element, e);
        }
    }

    public void waitUrlContains(String text) {
        try {
            wait.until(ExpectedConditions.urlContains(text));
        } catch (Exception e) {
            throw new TimeoutException("URL does not contain: " + text, e);
        }
    }

    // ================= TEXT WAIT =================

    public void waitForTextToBe(By locator, String expectedText) {
        try {
            wait.until(d -> {
                try {
                    String text = d.findElement(locator).getText();
                    return text != null && text.trim().equals(expectedText);
                } catch (StaleElementReferenceException e) {
                    return false;
                }
            });
        } catch (Exception e) {
            throw new TimeoutException(
                    "Text did not match expected value: " + expectedText, e);
        }
    }

    // ================= CART WAIT =================

    public void waitForCartCountToBe(By locator, int expectedCount) {
        try {
            wait.until(d -> {
                try {
                    String text = d.findElement(locator).getText().trim();

                    if (text.isEmpty()) return false;

                    return Integer.parseInt(text) == expectedCount;

                } catch (StaleElementReferenceException | NumberFormatException e) {
                    return false;
                }
            });
        } catch (Exception e) {
            throw new TimeoutException(
                    "Cart count not reached expected value: " + expectedCount, e);
        }
    }

    // ================= ACTION METHODS =================

    public void click(WebElement element) {
        try {
            waitForElementToBeClickable(element);
            element.click();
        } catch (Exception e) {
            throw new ElementNotInteractableException(
                    "Failed to click element: " + element, e);
        }
    }

    public void safeClick(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", element);

            element.click();

        } catch (Exception e) {
            try {
                ((JavascriptExecutor) driver)
                        .executeScript("arguments[0].click();", element);
            } catch (Exception ignored) {}

            throw new ElementNotInteractableException(
                    "Safe click failed for element: " + element, e);
        }
    }

    public void sendKeys(WebElement element, String text) {
        try {
            waitForElementToAppear(element);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            throw new NoSuchElementException(
                    "Failed to send keys to element: " + element, e);
        }
    }

    public String getText(WebElement element) {
        try {
            waitForElementToAppear(element);

            String text = element.getText();
            return (text == null) ? "" : text.trim();

        } catch (Exception e) {
            throw new NoSuchElementException(
                    "Failed to get text from element: " + element, e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void moveToElement(WebElement element) {
        try {
            waitForElementToAppear(element);
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            throw new ElementNotInteractableException(
                    "Failed to hover on element: " + element, e);
        }
    }
}