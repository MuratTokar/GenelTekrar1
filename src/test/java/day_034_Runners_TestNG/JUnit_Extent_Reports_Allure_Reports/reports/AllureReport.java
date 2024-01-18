package day_034_Runners_TestNG.JUnit_Extent_Reports_Allure_Reports.reports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_034_Runners_TestNG/JUnit_Extent_Reports_Allure_Reports/features/Feature34.feature"},
        glue = {"day_034_Runners_TestNG/JUnit_Extent_Reports_Allure_Reports/stepdefs"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html" ,
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"


        }

)

public class AllureReport extends AbstractTestNGCucumberTests {
}
