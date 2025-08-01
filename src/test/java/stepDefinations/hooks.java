package stepDefinations;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.baseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks  {
	WebDriver driver;
	Properties p;
	
	@Before
	public void setup() throws IOException{
		driver=baseClass.initilizeBrowser();
		
		p=baseClass.getProperties();
		
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
	}
	
	@After
	public void tearDown(Scenario scenario) {
		TakesScreenshot ts=(TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		
		driver.quit();
	}
}
