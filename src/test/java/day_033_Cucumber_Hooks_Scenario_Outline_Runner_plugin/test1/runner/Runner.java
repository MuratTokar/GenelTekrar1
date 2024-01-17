package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.test1.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin/test1/features/HooksFeatures.feature"},
        glue = {"day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin/test1/step"}
       // plugin = {"pretty"} // buraya raporlari ekleriz.Pretty ekleyince isleyen stepleride yazar
       // plugin = {"progress"} //steplerin basina nokta ekledi.Daha cok pretty kullanilir

)

public class Runner extends AbstractTestNGCucumberTests {
}
