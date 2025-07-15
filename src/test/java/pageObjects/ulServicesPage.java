package pageObjects;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;


public class ulServicesPage extends basePage{
	
	public ulServicesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[normalize-space()='UL Services']")
	WebElement ulServicesLink;
	
	@FindBy(tagName = "iframe")
	WebElement iframe;
	
	public void clickULServices() {
		ulServicesLink.click();
	}
	public WebElement getIframe() {
		return iframe;
	}
	public String getIframeSrc() {
		return iframe.getAttribute("src");
	}
	
	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement nameInput;
	
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement mobileInput;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement emailInput;
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement cityInput;
	
	@FindBy(xpath = "//div[@class='MocG8c HZ3kWc mhLiyf LMgvRb KKjvXb DEh1R']")
	WebElement dropDown;
	
	@FindBy(xpath = "//div[@class='OA0qNb ncFHed QXL7Te']//div[@jsname='wQNmvb' and @role='option']")
	List<WebElement> timeSlotOptions;
	
	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	WebElement submitButton;
	
	
	public void fillForm(String name, String mobile, String email, String city, String timeSlot) {
		nameInput.clear(); nameInput.sendKeys(name);
		mobileInput.clear(); mobileInput.sendKeys(mobile);
		emailInput.clear(); emailInput.sendKeys(email);
		cityInput.clear(); cityInput.sendKeys(city);
		
		dropDown.click();
		for(WebElement option: timeSlotOptions) {
			if(option.getText().contains(timeSlot)) {
				option.click();
				break;
			}
		}
	}
	
	public void submitForm() {
		submitButton.click();
	}
}
