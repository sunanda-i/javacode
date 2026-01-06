package utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void launch(@Optional("chrome") String nameofbrowser)
	{
	    if(nameofbrowser.equalsIgnoreCase("chrome"))
	    {
	    	ChromeOptions options = new ChromeOptions();
	    	options.addArguments("--incognito");
	        driver = new ChromeDriver();
	    }

	    driver.manage().window().maximize();
	    driver.get("https://www.amazon.in/");
	    driver.navigate().refresh();
	    
	}	
	@AfterMethod
	public void quit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
