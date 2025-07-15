package stepDefinations;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.baseClass;
import io.cucumber.java.en.*;
import pageObjects.bookShelvesPage;
import pageObjects.livingPage;



public class living extends baseClass{
	
	livingPage lp;
	bookShelvesPage bp;
	
	static WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	List <WebElement> livingWebElements = new ArrayList<WebElement>();
	List <String> livingStrings=new ArrayList<String>();
	
	@Given("On the Living page")
	public void on_the_living_page() throws InterruptedException {
		lp=new livingPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
		baseClass.getLogger().info("Living Page.....");
		Thread.sleep(3000);
		lp.moveToLiving();
	}
	
	@When("choose a sub-menu item from Seating & Chairs or Living Storage")
	public void choose_a_sub_menu_item_from_seating_chairs_or_living_storage() throws InterruptedException {
		lp=new livingPage(driver);
		bp=new bookShelvesPage(driver);
		baseClass.getLogger().info("Living Page Submenu items....");
		Thread.sleep(3000);
		lp.clickOnLivingStorageEle();
		Thread.sleep(3000);
	}
	
	@Then("retrieve all items under the chosen sub-menu")
	public void retrieve_all_items_under_the_chosen_sub_menu() {
		lp=new livingPage(driver);
		baseClass.getLogger().info("Selecting Living page subMenu items.....");
		livingWebElements=lp.getSubElementItems();
		baseClass.getLogger().info("Living page subMenu items selected....");
	}
	
	@Then("print the retrieved items in the console")
	public void print_the_retrieved_items_in_the_console() {
		baseClass.getLogger().info("Printing Living page subMenu items.....");
		int i=1;
		for(WebElement ele:livingWebElements) {
			String livDetails=ele.getText();
			System.out.println(i+": "+livDetails);
			livingStrings.add(livDetails);
			i++;
			baseClass.getLogger().info("Living page subMenu items are printed....");
		}
		
	}

}
