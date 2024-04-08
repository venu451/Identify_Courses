package testRunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;	
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"./FeatureFiles"},
//		features= {"./FeatureFiles/CourseSearch.feature"},
		glue="stepDefinations",
		plugin= {"pretty","html:reports/myreport.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/rerun.txt"
		},
		dryRun=false,
		monochrome=true,
		publish=true
				
		)
public class TestRunner {

}
