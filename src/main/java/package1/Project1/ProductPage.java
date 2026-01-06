package package1.Project1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class ProductPage {
	WebDriver driver;
	@FindBy(id = "nav-logo-sprites")
	private WebElement amazonlogo;
	
	@FindBy(id = "a-autoid-1")
	private WebElement addtocart;
	
	@FindBy(xpath="//span[text()='Men']/preceding-sibling::div")
	private WebElement Mencheckbox;
	
	@FindBy(xpath="//div[@data-component-type='s-search-result']//h2//span")
	private List<WebElement> productTitles;
	
	@FindBy(id="a-autoid-154")
	private WebElement filterItemAddToCart;
	
	@FindBy(xpath="//a[@class='a-link-normal s-no-outline']")
	private List<WebElement> productsList;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartBtn;
	
	@FindBy(id = "nav-cart-count")
	private WebElement cartCount;
	
	@FindBy(xpath="//span[@class='a-icon a-icon-small-add']")
	private WebElement increaseQuantity;
	
	@FindBy(xpath="//span[@data-a-selector='value']")
	private WebElement Quantity;
	
	@FindBy(xpath="//span[contains(@class,'a-icon-small-remove')]/parent::button")
	private WebElement decreaseQuantity;
	
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement delete;
	
	@FindBy(xpath="(//span[@class='a-price-whole' or @data-a-color='price'])[1]")
	private WebElement productprice;
	
	@FindBy(xpath="(//div[@id='averageCustomerReviews'])[1]")
	private WebElement RatingandReview;
	
	@FindBy(xpath="//div[@id='feature-bullets']//ul")
	private WebElement description;
	
	public void verifyAmazonHomePage(WebDriver driver) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Wait for the logo to be visible
	    wait.until(ExpectedConditions.visibilityOf(amazonlogo));
        Reporter.log("Amazon is launched");
	    // Assert logo is displayed
	    Assert.assertTrue(amazonlogo.isDisplayed(), "Amazon logo is not displayed!");
	}
	
	public void AddToCart()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();

	        boolean isButtonGone = wait.until(ExpectedConditions.invisibilityOf(addtocart));
            
	        Reporter.log("Add to cart button is not visible");
	        // Assert that the button is gone
	        Assert.assertTrue(isButtonGone, "Add to Cart button is still visible after clicking!");
	        System.out.println("Add to Cart button clicked and no longer visible.");
	}
	
	public void verifyMenfilterselection() {
	    
	    Mencheckbox.click();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

	    wait.until(ExpectedConditions.visibilityOfAllElements(productTitles));

	    Assert.assertTrue(productTitles.size() > 0, "No products found!");

	    for (WebElement title : productTitles) {

	        String text = title.getText().toLowerCase();

	        Assert.assertFalse(
	                text.contains("women") || text.contains("girls") || text.contains("ladies"),
	                "Women's product found in Men filter: " + text
	            );
	    	}
	}
	
public void ProductDetailsToAddToCart() throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    // wait until at least 1 product is present
    wait.until(driver -> productsList.size() > 0);

    System.out.println("Products found: " + productsList.size());

    // click first product
    productsList.get(0).click();	

	Set <String>pcid=driver.getWindowHandles();
	System.out.println(pcid);
	Iterator<String> id=pcid.iterator();
	String parentid=id.next();
	String childid=id.next();
	driver.switchTo().window(childid);
	
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

    wait1.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

    addToCartBtn.click();
	 
}	

public void ProductDetailsInformation() throws InterruptedException
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    // wait until at least 1 product is present
    wait.until(driver -> productsList.size() > 0);

    System.out.println("Products found: " + productsList.size());

    // click first product
    productsList.get(0).click();	

    String parent = driver.getWindowHandle();

    for(String handle : driver.getWindowHandles()){
        if(!handle.equals(parent)){
            driver.switchTo().window(handle);
            break;
        }
    }
    
    Reporter.log("Price is displayed");
    // Verify price
    WebElement price = wait.until(ExpectedConditions.visibilityOf(productprice));

    Assert.assertTrue(price.isDisplayed(), "❌ Price NOT displayed");
    System.out.println("Price = " + price.getText());
    
    Reporter.log("Review and Ratings displayed");
    // VERIFY REVIEWS/RATING
    WebElement RatingAndReview = wait.until(ExpectedConditions.visibilityOf(RatingandReview));

    Assert.assertTrue(RatingandReview.isDisplayed(), "❌ Reviews NOT displayed");
    System.out.println("ReviewsAndRating = " + RatingandReview.getText());
    
    
    Reporter.log("Description shown");
    // ====== VERIFY DESCRIPTION / ABOUT THIS ITEM ======
    WebElement Description = wait.until(ExpectedConditions.visibilityOf(description));

    Assert.assertTrue(description.isDisplayed(), "❌ Description NOT displayed");
    System.out.println("Description = " + description.getText());
    
    System.out.println("🎉 Product page validated successfully!");
    
}

public void IncreaseandDecreaseItemQuantity()
{
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(addtocart)).click();
        
        cartCount.click();       
        
        
        String parent = driver.getWindowHandle();

        for(String handle : driver.getWindowHandles()){
            if(!handle.equals(parent)){
                driver.switchTo().window(handle);
                break;
            }
        }
        
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait1.until(ExpectedConditions.elementToBeClickable(increaseQuantity)).click();	
    	
    	
    	WebDriverWait wait2= new WebDriverWait(driver, Duration.ofSeconds(30));
    	wait2.until(ExpectedConditions.elementToBeClickable(decreaseQuantity)).click();
    	boolean isdecreasebuttongone = wait2.until(ExpectedConditions.invisibilityOf(decreaseQuantity));

        // Assert that the decrease button is gone
        Assert.assertTrue(isdecreasebuttongone, "decrease button is still visible after clicking!");
        //System.out.println("Add to Cart button clicked and no longer visible.");
    	
    	   	
}

	public ProductPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
