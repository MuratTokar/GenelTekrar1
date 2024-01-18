package day_034_Runners_TestNG.JUnit_Extent_Reports_Allure_Reports.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/day_034_Runners_TestNG/JUnit_Extent_Reports_Allure_Reports/features/Feature34.feature"},
        glue = {"day_034_Runners_TestNG/JUnit_Extent_Reports_Allure_Reports/stepdefs"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html",
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml"
        }

)

public class RunnerJunit  {
}





