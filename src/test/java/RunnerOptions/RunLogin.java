package RunnerOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		features="src/test/java/features",
		glue = "cucumber.stepDefTDD",
		plugin = {"html:target/HTML_report.html"},
		tags = "@TDD"
		
		)

public class RunLogin {

}
