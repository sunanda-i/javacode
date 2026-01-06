package package1.Project1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.BaseClass;
import utility.ExcelUtil;

public class TestCase6_LogintoamazonwithInvalidcredentials extends BaseClass {
	
	@DataProvider(name = "LoginData")
    public Object[][] getData() throws Exception {
    	String path = System.getProperty("user.dir")
                + "/Excelsheet/Testdata.xlsx";
        return ExcelUtil.getExcelData(path, "invalidlogin");
    }

    @Test(dataProvider = "LoginData")
    public void invalidLogin(String Username, String Password) throws InterruptedException {

    	HomePage homepage = new HomePage(driver);
		
		homepage.hoverOveronAccountList(driver);
		homepage.clickToSignIn(driver);
    	LoginPage loginpage =new LoginPage(driver);
		loginpage.enterUsername(Username);
		loginpage.clickOnContinue();
		loginpage.enterPassword(Password);
		loginpage.clickonSigin();
    	
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement errorBox = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.id("auth-error-message-box")
		        )
		);

		String errorMessage = errorBox.getText();
		System.out.println("Error message: " + errorMessage);

		Assert.assertTrue(
		        errorMessage.toLowerCase().contains("incorrect")
		        || errorMessage.toLowerCase().contains("problem"),
		        "Expected error not shown!");
    }
}




