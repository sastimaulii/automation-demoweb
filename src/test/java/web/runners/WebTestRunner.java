package web.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web.features",
        glue = "web.steps",
        plugin = {"pretty", "html:target/web-report.html"}
)
public class WebTestRunner {
}