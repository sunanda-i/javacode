package package1.Project1;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage {
	
	WebDriver driver;
	@FindBy(xpath= "//span[text()='Edit addresses for orders and gifts']")
	private WebElement yourAddresses;
	
	@FindBy(xpath= "//a[@id='ya-myab-address-edit-btn-0']")
	private WebElement editAddresses;		
	
	@FindBy(id="address-ui-widgets-countryCode-dropdown-nativeId")
	private WebElement countryDropdown;
	
	@FindBy(xpath="//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']")
	private WebElement updateAddresses;
	
	@FindBy(id="yaab-alert-box")
	private WebElement alertsucess;
	
	public void yourAddresses(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.visibilityOf(yourAddresses));
	    
	    yourAddresses.click();
	}	
	
	public void editAddresses()
	{  
	    editAddresses.click();
	    
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	    wait1.until(ExpectedConditions.elementToBeClickable(countryDropdown));
	    
	    Select s1= new Select(countryDropdown);
	    s1.selectByValue("IN");
	    
	    updateAddresses.click();	
	    
	    Assert.assertTrue(alertsucess.isDisplayed(), "Adresess updated sucessfully!");
	    
	}	
	
	
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


}
