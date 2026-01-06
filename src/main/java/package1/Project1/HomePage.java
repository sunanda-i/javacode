package package1.Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	@FindBy(id = "nav-logo-sprites")
	private WebElement amazonlogo;
	
	
	@FindBy(id = "nav-link-accountList")
	private WebElement accountlist;
	
	@FindBy(xpath="//span[text() ='Sign in']")
	private WebElement signin;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(xpath="//a[@class='nav-a']")
	private WebElement newuser;
	
	@FindBy(xpath="//button[@class='sc-fqkvVR sc-eulNck lajAPo kmtIpc']")
	private WebElement manageprofile;
	
	public void verifyAmazonHomePage(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Wait for the logo to be visible
	    wait.until(ExpectedConditions.visibilityOf(amazonlogo));

	    // Assert that the page title contains "Amazon"
	    Assert.assertTrue(driver.getTitle().contains("Amazon"),
	            "Amazon home page failed to load!");

	    // Optional: Assert logo is displayed
	    Assert.assertTrue(amazonlogo.isDisplayed(), "Amazon logo is not displayed!");
	}
public void hoverOveronAccountList(WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    wait.until(ExpectedConditions.visibilityOf(accountlist));

    Actions act = new Actions(driver);
    act.moveToElement(accountlist).perform();
}
public void clickToSignIn(WebDriver driver)
{
	signin.click();
}	

public void searchingproduct(WebDriver driver)
{
	search.sendKeys("Shoes" +Keys.ENTER);
}	

public void searchingproduct1(WebDriver driver)
{
	search.sendKeys("Apple iphone 17 pro max" +Keys.ENTER);
}	



public void newuser(WebDriver driver)
{
	newuser.click();
}	

public void manageprofile(WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.visibilityOf(accountlist));
    
    accountlist.click();
}

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


}
