package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class livingPage extends basePage {
	
	public livingPage(WebDriver driver) {
		super(driver);
		
	}
	Actions act = new Actions(driver);
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[4]/span")
	WebElement livingEle;
	
	public void moveToLiving() {
		act.moveToElement(livingEle).click().build().perform();
	}
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[4]/div/div/ul/li[2]/div/a")
	WebElement livingStorageEle;
	
	public void clickOnLivingStorageEle() {
		act.moveToElement(livingStorageEle).build().perform();
	}
	
	
	@FindBy(xpath="//*[@id='topnav_wrapper']/ul/li[4]/div/div/ul/li[2]/ul/li/a")
	List<WebElement> subMenuItems;
	
	public List<WebElement> getSubElementItems(){
		return subMenuItems;
	}

}
