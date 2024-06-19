package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * TestNGRunner class for executing Cucumber tests using TestNG.
 * Specifies the features, step definitions package, and other configuration options.
 */
@CucumberOptions(
    features = "src/test/java/cucumber", // Path to the directory containing feature files
    glue = "saucedemo.stepDefinitions", // Package containing step definitions
    monochrome = true, // Ensure console output is readable (removes color codes)
    plugin = {"html:target/cucumber.html"} // Generate HTML report at target/cucumber.html
    //tags="@runThis"
)
public class TestNGRunner extends AbstractTestNGCucumberTests {
    // No additional code is needed as AbstractTestNGCucumberTests handles Cucumber integration with TestNG.
}
