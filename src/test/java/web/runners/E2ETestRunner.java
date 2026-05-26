package web.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/web.features/e2e_customer.feature",
        glue = "web.steps",
        plugin = {"pretty", "html:target/e2e-report.html"}
)
public class E2ETestRunner {
}