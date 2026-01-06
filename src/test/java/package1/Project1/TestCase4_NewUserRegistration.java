package package1.Project1;

import org.testng.annotations.Test;

import utility.BaseClass;

public class TestCase4_NewUserRegistration extends BaseClass {
	@Test
	public void withValidCredentials() throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		
		homepage.hoverOveronAccountList(driver);
		
		
		RegisterPage registerpage = new RegisterPage(driver);
		registerpage.clickOnStarthere();
		registerpage.enterUsername();
		registerpage.clickOnContinue();
		registerpage.clicktoproceedtocreateanaccount();
		registerpage.entermobilenumber();
		registerpage.enterfirstnameandlastname();
		registerpage.enterpassword();
		registerpage.clickonVerifymobilenumber();

}
}
