package day_031_Scenario_Background_Variables_DataTables.openchart.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_031_Scenario_Background_Variables_DataTables/openchart/features/OpencharttBackground.feature"},
        glue = {"day_031_Scenario_Background_Variables_DataTables/openchart/stepdefs"},
        dryRun = true // featurelerdeki steplerin tanimlanip tanimlanmadigini kontrol eder
)

public class RunnerOpencartBackground extends AbstractTestNGCucumberTests {




}
