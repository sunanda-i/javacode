package package1.Project1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.BaseClass;
import utility.ExcelUtil;

public class TestCase7_UserEditProfile extends BaseClass{
	
	@DataProvider(name = "LoginData")
	    public Object[][] getData() throws Exception {
	    	String path = System.getProperty("user.dir")
	                + "/Excelsheet/Testdata.xlsx";
	        return ExcelUtil.getExcelData(path, "validcredentials");
	    }
		
		@Test(dataProvider = "LoginData")
		public void withValidCredentials(String Username, String Password) throws InterruptedException
		{
			HomePage homepage = new HomePage(driver);
			
			homepage.hoverOveronAccountList(driver);
			homepage.clickToSignIn(driver);
			
	    	LoginPage loginpage =new LoginPage(driver);
			loginpage.enterUsername(Username);
			loginpage.clickOnContinue();
			loginpage.enterPassword(Password);
			loginpage.clickonSigin();
			
			homepage.hoverOveronAccountList(driver);
			homepage.manageprofile(driver);
			
			ProfilePage profilepage = new ProfilePage(driver);
			profilepage.yourAddresses(driver);
			profilepage.editAddresses();
			
			
		}
		


}
