package day_031_Scenario_Background_Variables_DataTables.openchart.gherkın;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_031_Scenario_Background_Variables_DataTables/openchart/gherkın/Gherkin.feature"},
        glue = {"day_031_Scenario_Background_Variables_DataTables/openchart/gherkın"}
)

public class Ruuner extends AbstractTestNGCucumberTests {
}
