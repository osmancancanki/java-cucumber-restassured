package testRunners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
//    plugin = {
//        "html:target/cucumberHtmlReport",
//        "json:target/cucumber-report.json"
//    }, // Plugin to generate HTML report and json report
        features = {
                "src/test/resources/features"
        },
        glue = {
                "stepDefs"
        },
        tags = {
                "@SmokeTest"
        })
public class SwaggerRunner {
}
