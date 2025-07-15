package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//FeatureFiles/First.feature",".//FeatureFiles/Second.feature",".//FeatureFiles/Third.feature"},
					//features = {".//FeatureFiles/First.feature"},
					//features = {".//FeatureFiles/Second.feature"},
					//features = {".//FeatureFiles/Third.feature"},
					//features = {"@target/rerun.txt"},
					glue="stepDefinations",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=false // to publish report in cucumber server
		
		
		)

public class TestRunner {

}
