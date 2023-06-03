package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
        "html:target/cucumber-reports1.html"},
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        tags = "@browser",
        dryRun = false
)


public class TestRunner {
}
