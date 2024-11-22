package day_031_Scenario_Background_Variables_DataTables.openchart.orangeHRM.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_031_Scenario_Background_Variables_DataTables/openchart/orangeHRM/feature/OrangeHRM.feature"},
        glue = {"day_031_Scenario_Background_Variables_DataTables/openchart/orangeHRM/Stepsdef"},
        plugin = {"html:target/reports/cucumber.html"},
        tags = "@Smoke"
)

public class Runner extends AbstractTestNGCucumberTests {
}
