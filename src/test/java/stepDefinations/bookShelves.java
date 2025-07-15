package stepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.baseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pageObjects.bookShelvesPage;
import pageObjects.homePage;

public class bookShelves extends baseClass{
	homePage hp;
	bookShelvesPage bp;
	
	Properties p;
	
	static WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
	
	List<WebElement> nameWebElements = new ArrayList<WebElement>();
	List<WebElement> priceWebElements = new ArrayList<WebElement>();
	List<WebElement> emiWebElements = new ArrayList<WebElement>();
	
	List<String> nameStrings = new ArrayList<String>();
	List<String> priceStrings = new ArrayList<String>();
	List<String> emiStrings = new ArrayList<String>();
	
	@Given("open the urbanladder page")
	public void open_the_urbanladder_page() {
		baseClass.getLogger().info("Opening the urbanLadder website");
    	hp=new homePage(baseClass.getDriver());
	}
	
	@When("search for BookShelves")
	public void search_for_book_shelves() throws IOException {
		p = new Properties();
		baseClass.getLogger().info("Entering the BookShelves in search box...");
		hp=new homePage(baseClass.getDriver());
		hp.searchBoxElement().sendKeys(baseClass.getProperties().getProperty("search_text"));
	}
	
	@When("click search button")
	public void click_search_button() {
		baseClass.getLogger().info("Entering the BookShelves in search box and click search button");
		hp=new homePage(baseClass.getDriver());
		hp.clickSearchButton();
	}
	
	@When("check the text as Search Results For Bookshelves is present")
	public void check_the_text_as_search_results_for_bookshelves_is_present() throws IOException {
		bp = new bookShelvesPage(driver);
		baseClass.getLogger().info("Checking the page is navigated...");
		hp=new homePage(baseClass.getDriver());
		Assert.assertEquals(bp.searching(), baseClass.getProperties().getProperty("after_search_text"));
		baseClass.getLogger().info("The Page is navigated Successfully....");
		if(bp.pop_up().isEnabled()) {
			baseClass.getLogger().info("If the popup is open...");
			myWait.until(ExpectedConditions.visibilityOf(bp.pop_up())).click();
			baseClass.getLogger().info("clicking the cancel button....");
			
		}
		else {
			baseClass.getLogger().info("Pop-up is not enabled...");
		}
		
	}
	
	@When("apply a filter to show items priced below {int}")
	public void apply_a_filter_to_show_items_priced_below(Integer int1) throws InterruptedException {
		bp = new bookShelvesPage(driver);
		baseClass.getLogger().info("Go to price...");
		baseClass.getLogger().info("click on the price...");
		bp.moveToPrice();
		Thread.sleep(3000);
		baseClass.getLogger().info("change the price to Rs.15000...");
		bp.sliding();
		Thread.sleep(3000);
		
		
	}
	
	@When("apply a filter to exclude out of stock items")
	public void apply_a_filter_to_exclude_out_of_stock_items() throws InterruptedException {
		bp = new bookShelvesPage(driver);
		baseClass.getLogger().info("Click the exclude out of stock checkbox....");
		bp.clickExcludeOutOfStock();
		Thread.sleep(2000);
		if(bp.in_Stock_Only().isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
		Thread.sleep(3000);
	}
	
	@When("select a category from Wall Shelves or Kid Bookshelves or Study Tables")
	public void select_a_category_from_wall_shelves_or_kid_bookshelves_or_study_tables() throws InterruptedException {
		baseClass.getLogger().info("Go to category...");
		bp.moveToCategory();
		Thread.sleep(3000);
		baseClass.getLogger().info("Click the KidsBookShelves...");
		bp.clickKidsBookShelves();
		Thread.sleep(2000);
	}
	
	@When("sort the items by price from High to Low")
	public void sort_the_items_by_price_from_high_to_low() throws InterruptedException {
		bp = new bookShelvesPage(driver);
		baseClass.getLogger().info("Go to Recommended options...");
		bp.clickHighToLow();
		Thread.sleep(2000);
		if(bp.valueDisplayHighToLow().isDisplayed()) {
			baseClass.getLogger().info("High to Low is selected...");
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
	
	@Then("fetch the top three items")
	public void fetch_the_top_three_items() {
		bp = new bookShelvesPage(driver);
		baseClass.getLogger().info("Fetching the details of top three items...");
		nameWebElements=bp.item_Names();
		priceWebElements = bp.prices();
		emiWebElements = bp.emiAmountDetail();
		baseClass.getLogger().info("The top 3 item details are fetched...");
		
	}
	
	@Then("print all details of the top three items in the console output")
	public void print_all_details_of_the_top_three_items_in_the_console_output() throws InterruptedException {
		bp = new bookShelvesPage(driver);
		baseClass.getLogger().info("Printing the details of top three items...");
		for (int i = 0; i < 3; i++) {
            WebElement item = nameWebElements.get(i);

            String details = item.getText();
            System.out.println("details: "+details);
            nameStrings.add(details);
            
            WebElement price_Detail=priceWebElements.get(i);
            String Product_Price=price_Detail.getText();
            System.out.println("Price: "+ Product_Price);
            priceStrings.add(Product_Price);
            
            WebElement emi_Details=emiWebElements.get(i);
            String emi_price=emi_Details.getText();
            System.out.println(emi_price);
            emiStrings.add(emi_price);
            
            
            System.out.println();
        }
		Thread.sleep(3000);
	}
	
}
