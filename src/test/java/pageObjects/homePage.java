package pageObjects;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import factory.baseClass;

public class homePage extends basePage {
	
	public homePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="search")
	public WebElement searchBox;
	
	public WebElement searchBoxElement() {
		return searchBox;
	}

	@FindBy(id="search_button")
	WebElement searchButton;
	
	public void clickSearchButton() {
		searchButton.click();
	}

}
