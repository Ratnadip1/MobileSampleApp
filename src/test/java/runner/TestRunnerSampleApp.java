package runner;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import framework.utilities.BasePageSteps;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"stepdefs"},
snippets = SnippetType.CAMELCASE, tags = "@sample", plugin = {"pretty", "html:target/cucumber-pretty/cucumber-report.html", "json:target/cucumber-reports/CucumberTestReport.json"})
public class TestRunnerSampleApp {
	
	private static final Logger logger = Logger.getLogger(TestRunnerSampleApp.class);
	
	private static BasePageSteps baseSteps = new BasePageSteps();

	@BeforeClass
	public static void frameworkSetup() {
		try {
			baseSteps.startAppiumServer();
		}catch(Exception ex) {
			ex.printStackTrace();
			logger.error("Error occurred while starting Appium server: " + ex.getMessage());
		}
	}
}
