package web.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web.features",
        glue = "web.steps",
        tags = "@web",
        plugin = {"pretty", "html:build/web-report.html"}
)
public class WebTestRunner {
}