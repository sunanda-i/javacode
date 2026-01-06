package package1.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@aria-label='New to Amazon? Start here to create an account']")
	private WebElement starthere;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement username;
	
	@FindBy(xpath="//span[@id='continue']")
	private WebElement continuebutton;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	private WebElement proceedtocreateanaccount;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	private WebElement mobilenumber;
	
	@FindBy(xpath="//input[@id='ap_customer_name']")
	private WebElement firstandlastname;
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement verifymobilenumber;
	
	
	public void clickOnStarthere() throws InterruptedException
	{
		starthere.click();
		Thread.sleep(2000);
	}
	public void enterUsername()
	{
		username.sendKeys("sunanda.ivatury3@gmail.com");
	}
	public void clickOnContinue() throws InterruptedException
	{
		continuebutton.click();
		Thread.sleep(2000);
	}
	public void clicktoproceedtocreateanaccount()
	{
		proceedtocreateanaccount.click();
	}
	public void entermobilenumber()
	{
		mobilenumber.sendKeys("7032806080");
	}
	public void enterfirstnameandlastname()
	{
	    firstandlastname.sendKeys("Nandu");
	}
	public void enterpassword()
	{
		password.sendKeys("srinidhi28");
	}
	public void clickonVerifymobilenumber()
	{
		verifymobilenumber.click();
	}

	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
