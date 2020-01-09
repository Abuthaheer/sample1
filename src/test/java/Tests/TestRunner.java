package Tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Requirements/HomePage.feature", glue = "stepDefinition", dryRun = false, plugin = {
		"pretty", "junit:XMLResults/report/cucumber.xml",

		"rerun:target/rerun.txt" }, monochrome = true, tags = { "~@ignore" })
public class TestRunner1 {

}
