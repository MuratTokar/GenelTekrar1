package day_031_Scenario_Background_Variables_DataTables.openchart.datatables;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_031_Scenario_Background_Variables_DataTables/openchart/datatables/DataTables.feature"},
        glue = {"day_031_Scenario_Background_Variables_DataTables/openchart/datatables"}
)

public class Runner extends AbstractTestNGCucumberTests {
}
