package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver;

@CucumberOptions(
        features = {"src/test/java/day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin/scenarioOutline2/feature/DemoFeature.feature"},
        glue = {"day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin/scenarioOutline2/stepss"},
        plugin = {"pretty",
        "json:target/cucumber/cucumber.json",
        "html:target/cucumber/cucumber.html"}
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeTest   // once testng sonra cucumber calisir
    @Parameters("browser")
    public void beforetest(@Optional("chrome") String browser){
       Driver.getDriver(browser);

    }
}
