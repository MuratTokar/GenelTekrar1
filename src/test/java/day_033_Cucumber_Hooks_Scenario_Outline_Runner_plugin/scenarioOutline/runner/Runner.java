package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin/scenarioOutline/features/ScenarioOutline.feature"},
        glue = {"day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin/scenarioOutline/steps"},
        tags = "@so2"
)

public class Runner extends AbstractTestNGCucumberTests {
}
