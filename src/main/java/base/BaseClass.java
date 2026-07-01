package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.ConfigReader;

public class BaseClass {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<WebDriverWait> wait = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public WebDriverWait getWait() {
        return wait.get();
    }

    public static Logger log = LogManager.getLogger(BaseClass.class);

    ConfigReader config = new ConfigReader();

    @Parameters("browser")
    @BeforeMethod
    public void launchBrowser(@Optional("Chrome") String browser) {

        WebDriver localDriver;

        if (browser.equalsIgnoreCase("chrome")) {

            localDriver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {
            localDriver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            localDriver = new EdgeDriver();

        } else {
            throw new RuntimeException("Invalid Browser Name: " + browser);
        }

        localDriver.manage().window().maximize();

        // ❌ NO IMPLICIT WAIT (as you asked)

        driver.set(localDriver);

        WebDriverWait explicitWait =
                new WebDriverWait(localDriver, Duration.ofSeconds(config.timeout()));

        wait.set(explicitWait);

        localDriver.get(config.url());

        log.info("Browser launched: " + browser);
    }

    @AfterMethod
    public void tearDown() {

        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }

        wait.remove();

        log.info("Browser closed successfully");
    }
}