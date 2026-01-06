package package1.Project1;

import org.testng.annotations.Test;

import utility.BaseClass;

public class TestCase5_ReachingTillCartwithoutLogin extends BaseClass{
	
	@Test
	public void reachingtillcartwithoutlogin() throws InterruptedException
	{
		HomePage homepage = new HomePage(driver);
		
		homepage.verifyAmazonHomePage(driver);
			
		homepage.searchingproduct1(driver);
		
		ProductPage productpage = new ProductPage(driver);
		productpage.AddToCart();

}
}
