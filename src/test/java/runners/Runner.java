package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features   = "src\\test\\resources\\features\\login.feature",
		glue 	   = "steps",
		tags 	   = "@valid_login",
		plugin 	   = {"pretty", "html:target/report.html", "json:target/report.json", "junit:target/report.xml"},
		monochrome = true
		)

public class Runner {

}
