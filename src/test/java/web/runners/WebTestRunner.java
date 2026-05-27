package web.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:web/features",
        glue = {"web.steps", "web.hooks"},
        tags = "@web",
        plugin = {
                "pretty",
                "html:build/reports/web-report.html",
                "json:build/reports/web-report.json"
        },
        monochrome = true
)
public class WebTestRunner {
}