package stepDefinations;

import org.openqa.selenium.*;
import factory.baseClass;
import io.cucumber.java.en.*;
import pageObjects.ulServicesPage;
import utilities.excelUtility;

public class ulServiceStep extends baseClass{
	
	ulServicesPage ul;
	String[] excelData;
	
	@Given("user navigates to UL Services section")
    public void user_navigates_to_ul_services_section() throws InterruptedException {
        ul = new ulServicesPage(driver);
        baseClass.getLogger().info("clicking UL Services button");
        ul.clickULServices();
        baseClass.getLogger().info("clicked UL Services button");
    }
	
	@When("user scrolls to UL Services using JavaScript")
    public void scroll_using_js() {
		baseClass.getLogger().info("Scrolling down the UL Service Page");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        baseClass.getLogger().info("Scrolled down the UL Service Page");
    }
	
	@When("switches to iframe and gets src URL")
    public void switch_to_iframe_get_src() throws InterruptedException {
		ul = new ulServicesPage(driver);
		baseClass.getLogger().info("Navigating to gform which is in iframe");
        String iframeSrc = ul.getIframeSrc();
        driver.navigate().to(iframeSrc);
        baseClass.getLogger().info("Navigated to gform which is in iframe");
    }
	
	@When("fetch data from excel sheet {string} and row {int}")
    public void fetch_data_from_excel(String sheetName, int rowNum) throws InterruptedException {
		baseClass.getLogger().info("Fetching user data from excel sheet");
        excelData = excelUtility.getRowData(sheetName, rowNum);
        baseClass.getLogger().info("Fetched user data from excel sheet");
    }
	
	@When("enters user details into the form")
    public void enters_user_details_into_the_form() throws InterruptedException {
		baseClass.getLogger().info("Filling gform with the user data from excel sheet");
        ul.fillForm(excelData[0], excelData[1], excelData[2], excelData[3], excelData[4]);
        baseClass.getLogger().info("Filled gform with the user data from excel sheet");
        Thread.sleep(1000);
    }
	
	@When("submit the form")
	public void submits_the_form() {
		baseClass.getLogger().info("Submitting gform");
		ul.submitForm();
		baseClass.getLogger().info("Submitted gform");
		
    }
	
	@Then("verify the form submission and take appropriate screenshot")
    public void verify_form_submission_and_take_screenshot() throws Exception {
        //Thread.sleep(1000);
        try {
            WebElement successMsg = driver.findElement(By.xpath("//div[@class='vHW8K']"));
            if (successMsg.isDisplayed()) {
                baseClass.getLogger().info("Form submitted successfully.");
                //Thread.sleep(2000);
                baseClass.takeScreenshot();
            }
        } catch (NoSuchElementException e) {
        	//Thread.sleep(1000);
            baseClass.getLogger().info("Invalid submission or error message displayed.");
            baseClass.takeScreenshot();
        }
    }

}
