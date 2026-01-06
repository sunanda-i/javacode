package package1.Project1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage
{
	WebDriver driver;
	@FindBy(xpath="//input[@id='ap_email_login']")
	private WebElement username;
	
	@FindBy(xpath="//span[@id='continue']")
	private WebElement continuebutton;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signin;
	
	
	public void enterUsername(String uname) throws InterruptedException
	{
		username.sendKeys(uname);
		Thread.sleep(1000);
	}
	public void clickOnContinue()
	{
		continuebutton.click();
	}
	public void enterPassword(String pwd) throws InterruptedException
	{
		password.sendKeys(pwd);
		Thread.sleep(1000);
	}
	public void clickonSigin()
	{
		signin.click();
	}
	
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
