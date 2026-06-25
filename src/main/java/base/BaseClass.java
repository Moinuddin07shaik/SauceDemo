package base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilites.ConfigReader;

public class BaseClass 
{

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static 	Logger log = LogManager.getLogger(BaseClass.class);

	ConfigReader config = new ConfigReader();

	@BeforeMethod
	public void Launchbrowser()

	{
		log.info("===============  Test Execution Started ==============");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 wait = new WebDriverWait(driver,
	                Duration.ofSeconds(config.timeout()));
		driver.get(config.url());
		log.info("==================== application opned =======================");
	}
	@AfterMethod
	public void tearDown()
	{
		log.info("======== browser closed ================");
		driver.quit();
		log.info("============= execution completed ===========");
	}


}
