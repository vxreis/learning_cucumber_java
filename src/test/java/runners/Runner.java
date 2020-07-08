package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features   = "src\\test\\resources\\features\\login.feature",
		glue 	   = "steps",
		tags 	   = "@valid_login",
		plugin 	   = "pretty",
		monochrome = true
		)

public class Runner {

}
