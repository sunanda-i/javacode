package package1.Project1;

import org.testng.annotations.Test;

import utility.BaseClass;

public class TestCase9_AddorRemoveItemsFromCart extends BaseClass {
	
	@Test
	public void AddorRemoveItemsFromCart() 
	{			
	   HomePage homepage = new HomePage(driver);
	   
	   homepage.verifyAmazonHomePage(driver);
	   homepage.searchingproduct1(driver);
	   
	   ProductPage productpage = new ProductPage(driver);
	   productpage.IncreaseandDecreaseItemQuantity();
	   
	   
	
}
}
