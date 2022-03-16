package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "features",
        glue = {"stepDefinitions"},
        tags = "@activity5",
        plugin = {"pretty","html: test-reports"}
)


public class ActivitiesRunner {

}
